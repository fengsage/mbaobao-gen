/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package ${groupId}.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	Create by mabaobao-web-archetype
 *
 */
public class CookieUtil {
	
	public static void addCookie(HttpServletResponse resp, Cookie cookie) {
		cookie.setPath("/");
		resp.addCookie(cookie);
	}
	
	public static Cookie getCookie(HttpServletRequest req, String name) {
		if (req == null || req.getCookies() == null || req.getCookies().length == 0) {
			return null;
		}
		for (Cookie cookie : req.getCookies()) {
			if (name.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}
	
}
