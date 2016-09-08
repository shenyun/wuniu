package cn.shenyun.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class HostUtils {

    private static Logger logger = LoggerFactory.getLogger(HostUtils.class);
    private static String hostAddress = null;
    private static String hostPort = null;
    private static final String ERROR_PORT = "-1";
    private static final String httpProtocol = "http";


    public static String getHostAddress(){
        if(hostAddress == null){
            try{
                hostAddress = InetAddress.getLocalHost().getHostAddress();
            }catch (UnknownHostException e){
                logger.error("Error get Ip Address.");
                hostAddress = "";
            }
        }
        return hostAddress;
    }

    public static String getPort(){
        if (hostPort == null) {
            try {
                //for tomcat 7
                hostPort = getPortByMBean(new ObjectName("Catalina", "type", "Service"));
                if(hostPort == null){
                    //for tomcat embed 7
                    hostPort = getPortByMBean(new ObjectName("Tomcat", "type", "Service"));
                }

            } catch (Exception e) {
                logger.warn("获取端口失败:{}", e.getMessage());
            }

            if (hostPort == null) {
                hostPort = ERROR_PORT;
            }
        }
        return hostPort;
    }

    public static boolean isErrorPort(String port) {
        return ERROR_PORT.equals(port);
    }

    private static String getPortByMBean(ObjectName name) {
        ArrayList<MBeanServer> mBeanServers = MBeanServerFactory.findMBeanServer(null);
        if (!mBeanServers.isEmpty()) {
            MBeanServer mBeanServer = mBeanServers.get(0);
            try {
                ObjectName[] objNames = (ObjectName[]) mBeanServer.getAttribute(name, "connectorNames");
                for (ObjectName on : objNames) {
                    String protocol = (String) mBeanServer.getAttribute(on, "protocol");
                    //HTTP/1.1  or  org.apache.coyote.http11.Http11NioProtocol
                    //如果是ajp协议，不会出现http这个字，所有检测协议里是否包含http就可以活动正确的端口
                    if (protocol.toLowerCase().contains(httpProtocol)) {
                        Integer p = (Integer) mBeanServer.getAttribute(on, "localPort");
                        if (p != null) {
                            String port = String.valueOf(p);
                            logger.info("获取服务端口成功:{}", port);
                            return port;
                        }
                    }
                }
            } catch (Exception e) {
                    logger.warn("通过{}获取服务端口失败", name.toString());
            }
        }
        return null;
    }
}
