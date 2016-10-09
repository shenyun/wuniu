package cn.shenyun.wuniu.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yong.luo on 2016/5/20.
 */
@Component
public class FastdfsCfgManager {
    @Value("${fastdfs.connect_timeout:2}")
    private int connectTimeout;
    @Value("${fastdfs.network_timeout:3}")
    private int networkTimeout;
    @Value("${fastdfs.charset:UTF-8}")
    private String charset;
    @Value("${fastdfs.anti_steal_token:false}")
    private boolean antiStealToken;
    @Value("${fastdfs.network_timeout}")
    private String secretKey;

    @Value("${fastdfs.http.tracker_http_domain:http://10.16.30.87}")
    private String trackerHttpDomain;
    @Value("${fastdfs.http.tracker_http_port:80}")
    private int trackerHttpPort;
    @Value("${fastdfs.tracker_server}")
    private String trackerServer;

    /**
     * 返回图片服务器的地址端口,如果是80端口则不加端口
     * @return http://10.16.30.87:8080   or http://10.16.30.87
     */
    public String getImgUrlPref(){
        if(this.trackerHttpPort==80){
            return trackerHttpDomain;
        }
        return this.trackerHttpDomain+":"+this.trackerHttpPort;
    }

    public String getTrackerHttpDomain() {
        return trackerHttpDomain;
    }

    public void setTrackerHttpDomain(String trackerHttpDomain) {
        this.trackerHttpDomain = trackerHttpDomain;
    }

    public int getTrackerHttpPort() {
        return trackerHttpPort;
    }

    public void setTrackerHttpPort(int trackerHttpPort) {
        this.trackerHttpPort = trackerHttpPort;
    }


    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getNetworkTimeout() {
        return networkTimeout;
    }

    public void setNetworkTimeout(int networkTimeout) {
        this.networkTimeout = networkTimeout;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public boolean isAntiStealToken() {
        return antiStealToken;
    }

    public void setAntiStealToken(boolean antiStealToken) {
        this.antiStealToken = antiStealToken;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTrackerServer() {
        return trackerServer;
    }

    public void setTrackerServer(String trackerServer) {
        this.trackerServer = trackerServer;
    }


}
