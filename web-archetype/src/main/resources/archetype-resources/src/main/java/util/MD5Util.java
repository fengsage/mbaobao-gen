package ${groupId}.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 *	Create by mabaobao-web-archetype
 *
 */
public class MD5Util {
	private static Logger	LOG			= Logger.getLogger("debugAppender");
	private static Logger	DATABASE	= Logger.getLogger("DATABASE");
	
	/**
	 * md5
	 * @param plainText
	 * @return
	 */
	public static String md5(String plainText) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			
			int i;
			
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();// 32位的加密
		} catch (NoSuchAlgorithmException e) {
			LOG.error("md5 fail：", e);
			DATABASE.error("md5 fail：", e);
		}
		return result;
	}
	
	/**
	 * 对给定的字符串进行加密
	 * @param s
	 * @return 加密后的16进制的字符串
	 */
	public final static String EncoderByMd5(String s) {
		if (LOG.isInfoEnabled()) {
			LOG.info("encrypt md5：" + s);
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			LOG.error("encrypt md5 fail：" + s, e);
			DATABASE.error("encrypt md5 fail：" + s, e);
			return null;
		}
	}
	
	/**
	 * chck password
	 * @param newStr
	 *        no encrypt password
	 * @param oldMD5Str
	 * 
	 * @return
	 */
	public final static boolean checkMD5(String newStr, String oldMD5Str) {
		String temp = EncoderByMd5(newStr);
		if (temp != null && temp.equals(oldMD5Str)) {
			return true;
		} else {
			return false;
		}
	}
}
