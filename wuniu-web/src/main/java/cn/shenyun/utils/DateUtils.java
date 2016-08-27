package cn.shenyun.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	private static Log logger = LogFactory.getLog(DateUtils.class);

	public static int getTimeInt(){
		return (int)(System.currentTimeMillis()/1000);
	}
	public static int getTimeInt(Date date){
		return (int)(date.getTime()/1000);
	}



	public static Date parseDatetime(String date){
		SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date s = t.parse(date);
			return s;
		} catch (ParseException e) {
			logger.error("method(parseDatetime) param="+date+"  error \r\n"+e.getMessage());
			return null;
		} 
	}
	public static Date getDate(long timestamp){
		return new Date(timestamp);
	}
	public static long getyyyyMMddHHmmssSSS(long date){
		SimpleDateFormat t = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		try {
			String s = t.format(date);
			return Long.parseLong(s);
		} catch (Exception e) {
			logger.error(e);
			return 0;
		} 
	}
	
	/**
	 * 2014-03-12 12:00:00==》20140312120000
	 * @param source
	 * @return
	 */
	public static String getShortFromyyyyMMddHHmmss(String source){
		long date=getDate(source);
		return getyyyyMMddHHmmssShort(date);
	}
	/**
	 * 20140312120000==>2014-03-12 12:00:00
	 * @param source
	 * @return
	 */
	public static String getyyyyMMddHHmmssFromShort(String source){
		long date=getDateFromShort(source);
		return getyyyyMMddHHmmss(date);
	}
	/**
	 * yyyy-MM-dd HH:mm:ss to date
	 * @param source
	 * @return
	 */
	public static long getDate(String source){
		SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return t.parse(source).getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 *  yyyyMMddHHmmss to date
	 * @param source
	 * @return
	 */
	public static long getDateFromShort(String source){
		SimpleDateFormat t = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return t.parse(source).getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 返回如 2014-03-12 12:00:00
	 * @param date
	 * @return
	 */
	public static String getyyyyMMddHHmmss(long date){
		SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String s = t.format(date);
			return s;
		} catch (Exception e) {
			logger.error(e);
			return "";
		} 
	}
	/**
	 * 返回如 20140312120000
	 * @param date
	 * @return
	 */
	public static String getyyyyMMddHHmmssShort(long date){
		SimpleDateFormat t = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			String s = t.format(date);
			return s;
		} catch (Exception e) {
			logger.error(e);
			return "";
		} 
	}
	
	/**
	 * 获取一个月的第一天的时间戳
	 * @return
	 */
	public static long getFirstDayOfMonth(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		long re = c.getTimeInMillis();
		
		return re;
	}
	
	/**
	 * 获取当月的最后一天末的时间戳
	 * @return
	 */
	public static long getLastTimeOfMonth(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		c.add(Calendar.MONTH, 1);
		long re = c.getTimeInMillis();		
		re -= 1;
		
		return re;
	}
	/**
	 *获取 yyyy-MM-dd HH:mm:ss.SSS
	 * @param time
	 * @return
	 */
	public static String getDatetimeSSS(long time){
		SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			Date s =  new Date();
			s.setTime(time);
			String re = t.format(s);
			return re;
		} catch (Exception e) {
			logger.error("method(parseDatetime) param="+time+"  error \r\n"+e.getMessage());
			return "";
		}
	}
	
	/**
	 * 根据时间得到天 格式yyyyMMdd
	 * @param time 时间
	 * @return
	 */
	public static int getDay(long time){
		String date = new SimpleDateFormat("yyyyMMdd").format(time);
		return Integer.parseInt(date);
	}
	
	/**
	 * 获取昨天最后时间的时间戳    结束时间yyyy-MM-dd 23:59:59
	 * 
	 * @return
	 */
	public static long getToDayLastTime() {
		Calendar cal = Calendar.getInstance();
		// 设置时间
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH,1);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime().getTime();
	}
	
	/**
	 * 得到yyyy-MM-dd格式的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getYear_Month_Day(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	/**
	 * 得到yyyy-MM-dd HH:mm:ss格式的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	/**
	 * 比较当前时间与给定时间的大小
	 * @param time
	 * @param minutes
	 * @return
	 */
	public static boolean compareDate(String time,int minutes){
		boolean b = false;
	    Date   nows=new   Date();  
	    System.out.println(nows);
	    Date date = parseDatetime(time);		
		long   minms=nows.getTime()-(date.getTime()+minutes*60*1000); 
		if (minms >= 0){
		   b=true;
		}			   
		 return b;
	}
	/**
	 * 根据传入的时间戳取得当天凌晨的时间戳 
	 * 如    ：2013-09-30 14:32:58.687  1380522778687(参数)
	 * 得到：2013-09-30 00:00:00.000  1380470400000(返回值)
	 * @param currentstamp
	 * @return
	 */
	public static long getZeroTimestamp(long currentstamp){
		Date date12=new Date(currentstamp);
		SimpleDateFormat f= new SimpleDateFormat("yyyyMMdd");
		try{
			String yyyyMMdd=f.format(date12);//20130923
			Date date = f.parse(yyyyMMdd);//
			return date.getTime();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	/**
	 * 根据传入的时间戳取得当天午夜的时间戳 
	 * 如    ：2013-09-30 14:32:58.687  1380522778687(参数)
	 * 得到：2013-09-30 23:59:59.999  1380556799999(返回值)
	 * @param currentstamp
	 * @return
	 */
	public static long getMidnightTimestamp(long currentstamp){
		Date date12=new Date(currentstamp);
		SimpleDateFormat f= new SimpleDateFormat("yyyyMMdd");
		try{
			String yyyyMMdd=f.format(date12);//20130923
			Date date = f.parse(yyyyMMdd);//凌晨时间戳
			return date.getTime()+24*60*60*1000L-1;//午夜时间戳
		}catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	
  
	public static void main(String[] args) {
		
		//System.out.println(getMidnightTimestamp(1380522778687L));
		//System.out.println(compareDate("2013-08-08 17:50:18",10));
	//	System.out.println(getDateFromyyyyMMddHHmmss("20140912160911"));
		System.out.println(getyyyyMMddHHmmssFromShort("20140912160911"));
		//System.out.println(getyyyyMMddHHmmssShort(System.currentTimeMillis()));
//		Map<String,Object> aa=new HashMap<String,Object>();
//		aa.put("sdf", "sdf");
//		System.out.println("sdf"+aa);
	}
	

}
