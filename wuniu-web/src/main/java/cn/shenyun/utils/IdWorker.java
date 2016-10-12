package cn.shenyun.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Random;

/**
 * Created by yong.luo on 2016/10/10.
 *
 * snowflake (Java版)
 * 第一位为未使用，接下来的41位为毫秒级时间(41位的长度可以使用69年)，
 * 然后是5位datacenterId和5位workerId(10位的长度最多支持部署1024个节点） ，
 * 最后12位是毫秒内的计数（12位的计数顺序号支持每个节点每毫秒产生4096个ID序号）
 * 一共加起来刚好64位，为一个Long型。(转换成字符串长度为18)
 * http://www.cnblogs.com/relucent/p/4955340.html
 */
public class IdWorker {
    //系统开始运行时间,2016/08/08 12:00:00
    private final long twepoch = 1470628800000L;
    //datacenterIdBits workerIdBits一共10位，可以支持1024台机器
    private final byte workerIdBits = 8;
    private final byte datacenterIdBits = 2;
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private final byte sequenceBits = 12;

    private final byte workerIdShift = sequenceBits;
    private final byte datacenterIdShift = sequenceBits + workerIdBits;
    private final byte timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private final int sequenceMask = -1 ^ (-1 << sequenceBits);//每毫秒 0-4095,共4096个

    private long workerId;
    private long datacenterId;
    private long sequence = 0;
    private long lastTimestamp = -1L;

    private static IdWorker idWorker;
//    static {
//        long workerId=0;
//        byte[] ipByte=getIp();
//        if(ipByte!=null) {
//            workerId=(int)ipByte[3];
//        }else {
//            workerId = new Random(System.currentTimeMillis()).nextInt() % 255;
//        }
//        idWorker=new IdWorker(workerId,0);
//    }
    public static synchronized IdWorker getInstence(){
        if(idWorker==null){
            long workerId=0;
            byte[] ipByte=getIp();
            if(ipByte!=null) {
                workerId=(int)ipByte[3];
            }else {
                workerId = new Random(System.currentTimeMillis()).nextInt() % 255;
            }
            idWorker=new IdWorker(workerId,0);
        }
        return idWorker;
    }
    public static long getId(){
        return getInstence().nextId();
    }
    /**
     *
     * @param workerId 机器号
     * @param datacenterId 数据中心id
     */
    public IdWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }
    private static byte[] getIp(){
        Enumeration<NetworkInterface> e= null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            e1.printStackTrace();
            return null;
        }
        InetAddress ip = null;
        while(e.hasMoreElements())
        {
            NetworkInterface netInterface = (NetworkInterface) e.nextElement();
//            System.out.println(netInterface.getName());
//            System.out.println(netInterface);
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements())
            {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address)
                {
                    if(!ip.getHostAddress().equals("127.0.0.1")){
                        return ip.getAddress();
                    }
//                    System.out.println(netInterface.getName());
                    //System.out.println("本机的IP = " + ip.getHostAddress()+","+netInterface.getName());
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        byte a=getIp()[3];
//        System.out.println(a);
//        long b=0;
//        b=a;
//        System.out.println(b);

//        long a=1L;
//        long b=a<<60;
//        268435456
//        System.out.println(b);
//        System.out.println(System.currentTimeMillis()-1470628800000L);

//        for (int i = 0; i <100 ; i++) {
//            System.out.println(IdWorker.getId());
//        }

//        System.out.println(2|2);
        long ip=(23260357879578657L<<43)>>(12+43);
        System.out.println(ip);


    }
    public static void main2(String[] args) throws SocketException {
        Enumeration<NetworkInterface> e=NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        while(e.hasMoreElements())
        {
            NetworkInterface netInterface = (NetworkInterface) e.nextElement();
//            System.out.println(netInterface.getName());
//            System.out.println(netInterface);
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements())
            {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address)
                {

//                    System.out.println(netInterface.getName());
                    //System.out.println("本机的IP = " + ip.getHostAddress()+","+netInterface.getName());
                }
            }
        }
    }

    public static void main1(String[] args) {

        IdWorker idWorker = new IdWorker(0, 0);
        System.out.println(idWorker.maxWorkerId);
        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }
    }
}
