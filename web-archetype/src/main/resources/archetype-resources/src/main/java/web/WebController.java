/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */

package ${groupId}.web;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *	Create by mabaobao-web-archetype
 *
 */
@Controller
public class WebController {
	
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response,
						Map<String, Object> modelMap) throws UnsupportedEncodingException {
		
		return "index";
	}
}
