package cn.shenyun.wuniu.service;



import cn.shenyun.wuniu.conf.FastdfsCfgManager;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yong.luo on 2016/5/24.
 */
@Service
public class FastdfsService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private FastdfsCfgManager fastdfsCfgManager;
    @Autowired
    public FastdfsService(FastdfsCfgManager fastdfsCfgManager){
        this.fastdfsCfgManager=fastdfsCfgManager;
        init();
    }
    public void init(){
//        connect_timeout = 2
//        network_timeout = 3
//        charset = UTF-8
//        http.tracker_http_port = 80
//        http.anti_steal_token = no
//        http.secret_key = FastDFS1234567890
//        tracker_server = 10.16.30.87:22122,10.16.30.88:22122
        int connect_timeout = fastdfsCfgManager.getConnectTimeout();
        if(connect_timeout<=0){connect_timeout=2;}
        int network_timeout = fastdfsCfgManager.getNetworkTimeout();
        if(network_timeout<=0){network_timeout=3;}
        String charset = fastdfsCfgManager.getCharset();

        int tracker_http_port=fastdfsCfgManager.getTrackerHttpPort();
        boolean anti_steal_token=fastdfsCfgManager.isAntiStealToken();
        String secret_key=fastdfsCfgManager.getSecretKey();
        String tracker_server=fastdfsCfgManager.getTrackerServer();
        if(tracker_server==null){
            throw new RuntimeException("fastdfs's tracker_server must config");
        }

        //连接超时的时限，单位为毫秒
        ClientGlobal.setG_connect_timeout(connect_timeout * 1000);
        //网络超时的时限，单位为毫秒
        ClientGlobal.setG_network_timeout(network_timeout*1000);
        //字符集
        ClientGlobal.setG_charset(charset);

        ClientGlobal.setG_anti_steal_token(anti_steal_token);
        ClientGlobal.setG_secret_key(secret_key);
        //HTTP访问服务的端口号
        ClientGlobal.setG_tracker_http_port(tracker_http_port);
        //Tracker服务器列表
        List<InetSocketAddress> trackerServerList=new ArrayList<>();
        String[] servers=tracker_server.split(",");
        for (int i=0;i<servers.length;i++){
            String ip=servers[i].split(":")[0];
            int port=Integer.parseInt(servers[i].split(":")[1]);
            trackerServerList.add(new InetSocketAddress(ip,port));
        }

        InetSocketAddress[] addresses= (InetSocketAddress[])trackerServerList.toArray(new InetSocketAddress[trackerServerList.size()]);;
        ClientGlobal.setG_tracker_group(new TrackerGroup(addresses));
    }

    public String[] upload(byte[] buffer,String fileExtName) {
        TrackerServer trackerServer=null;
        try {
            //ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            //设置属性
            NameValuePair nvp [] = new NameValuePair[]{
//                    new NameValuePair("age", "18"),
//                    new NameValuePair("sex", "male")
            };

            //"MS01",
            String fileIds[] = storageClient.upload_file(buffer,fileExtName,null);
            System.out.println("组名：" + fileIds[0]);
            System.out.println("路径: " + fileIds[1]);
            return fileIds;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            //此处不关闭后面的操作要超时
            try {
                if(trackerServer!=null) {
                    trackerServer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public boolean delete(String group,String fileName){
        try {
            //ClientGlobal.init(conf_filename);
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer);
            int i = storageClient.delete_file(group, fileName);
            System.out.println( i==0 ? "删除成功" : "删除失败:"+i);
            return i==0?true:false;
        } catch (Exception e) {
            logger.warn("delete file error",e);
        }
        return false;
    }
}
