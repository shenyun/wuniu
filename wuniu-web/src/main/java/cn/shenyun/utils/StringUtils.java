package cn.shenyun.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unchecked")
public class StringUtils {

	/**
	 * 转换错误栈为为字符串。
	 *
	 * @param e
	 * @return
	 */
	public static String getExceptionStack(Throwable e) {
		if (e == null) return "";

		OutputStream ou = new ByteArrayOutputStream();
		PrintStream o = new PrintStream(ou);
		e.printStackTrace(o);
		return ou.toString();
	}

	/**
	 * 把 a=1,b=2格式的字符串转换成一个map对象
	 *
	 * @param content
	 * @return
	 */
	public static Map str2map(String content) {
		if (content == null || content.trim().equals("")) {
			return null;
		}
		String[] a = content.split(",");
		if (a.length == 0) {
			return null;
		}
		Map re = new HashMap();
		for (String s : a) {
			String[] as = s.split("=");
			if (as.length == 2) {
				re.put(as[0], as[1]);
			} else {
				re.put(as[0], null);
			}
		}
		return re;
	}

	/**
	 * 把map转换成key=value,key=value格式的字符串
	 *
	 * @param map
	 * @return
	 */
	public static String map2str(Map map) {
		if (map == null || map.size() == 0) {
			return "";
		}
		String re = map.toString();
		re = re.substring(1, re.length() - 1);
		re = re.replace("=null", "=");
		return re;
	}

	/**
	 * 把date转换成一个时间戳字符串yyyyMMddHHmmssSSS。
	 *
	 * @param date
	 * @return
	 */
	public static String date2long(Date date) {
		if (date == null) return null;
		SimpleDateFormat t = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String s = t.format(date);
		return s;
//		return ""+System.currentTimeMillis();
	}

	/**
	 * 检查当前对象是否不为空  包括NULL和空字符串
	 * 如果不为空返回true
	 *
	 * @param obj 要检查的对象
	 * @return boolean 返回true或false
	 */
	public static boolean isNotEmpty(Object obj) {
		boolean isTrue = false;
		if (null != obj) {
			isTrue = true;
		}
		if (obj instanceof String) {
			if (((String) obj).trim().length() > 0)
				isTrue = true;
			else
				isTrue = false;
		}
		if (obj instanceof List<?>) {
			if (((List<?>) obj).size() > 0) {
				isTrue = true;
			}
		}
		if (obj instanceof Map<?, ?>) {
			if (((Map<?, ?>) obj).size() > 0) {
				isTrue = true;
			}
		}
		return isTrue;
	}

	/**
	 * 检查当前对象是否为空  包括NULL和空字符串
	 * 如果为空返回true
	 *
	 * @param obj
	 * @return boolean
	 */
	public static boolean isEmpty(Object obj) {
		boolean isTrue = false;
		if (null == obj) {
			isTrue = true;
		}
		if (obj instanceof String) {
			if (((String) obj).trim().length() == 0)
				isTrue = true;
			else
				isTrue = false;
		}
		if (obj instanceof List<?>) {
			if (((List<?>) obj).size() < 0) {
				isTrue = true;
			}
		}
		if (obj instanceof Map<?, ?>) {
			if (((Map<?, ?>) obj).size() < 0) {
				isTrue = true;
			}
		}
		return isTrue;
	}

	/**
	 * 判断对象是否为空，为空则返回传来的默认值，不是空则返回对象的字符串形式
	 *
	 * @param obj    需要判断的对象
	 * @param defStr 默认值
	 * @return String
	 */
	public static String getString(Object obj, Object defStr) {
		return obj == null ? String.valueOf(defStr) : obj.toString();
	}

	/**
	 * 判断对象是否为空，为空则返回传来的0，不是空则返回对象的Long形式
	 *
	 * @param obj 需要判断的对象
	 * @return Long
	 */
	public static long getLong(Object obj) {
		return getLong(obj, 0);
	}

	/**
	 * 判断对象是否为空，为空则返回传来的defArg，不是空则返回对象的Long形式
	 *
	 * @param obj    需要判断的对象
	 * @param defArg 默认的Long值
	 * @return Long
	 */
	public static long getLong(Object obj, long defArg) {
		return Long.parseLong(getString(obj, defArg));
	}

	/**
	 * 判断对象是否为空，为空则返回传来的0，不是空则返回对象的Long形式
	 *
	 * @param obj 需要判断的对象
	 * @return Long
	 */
	public static int getInt(Object obj) {
		return getInt(obj, 0);
	}

	/**
	 * 判断对象是否为空，为空则返回传来的defArg，不是空则返回对象的Long形式
	 *
	 * @param obj    需要判断的对象
	 * @param defArg 默认的Long值
	 * @return Long
	 */
	public static int getInt(Object obj, long defArg) {
		return Integer.parseInt(getString(obj, defArg));
	}

	/**
	 * 获取guid带横杠36位
	 *
	 * @return
	 */
	public static String CreateGuid36() {
		String fguid = UUID.randomUUID().toString();
		return fguid;
	}

	/**
	 * 字符串右对齐,不足用0补齐
	 */
	public static String alignRight(long src, int len) {
		StringBuffer sbs = new StringBuffer();
		sbs.append(src);
		while (sbs.length() < len) {
			sbs.insert(0, "0");
		}
		return sbs.toString();
	}

	/**
	 * 字符串右对齐,不足用0补齐
	 */
	public static String alignRight(String src, int len) {
		StringBuffer sbs = new StringBuffer();
		sbs.append(src);
		while (sbs.length() < len) {
			sbs.insert(0, "0");
		}
		return sbs.toString();
	}

	/**
	 * 计算字符串长度，中文算2个字符，英文算一个字符
	 *
	 * @param content
	 * @return
	 */
	public static int length(String content) {
		try {
			return new String(content.getBytes("gb2312"), "iso-8859-1").length();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {

	}


}
