package ${groupId}.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
/**
 *	Create by mabaobao-web-archetype
 *
 */
public class PropertiesHelp {
	protected static final Logger		LOG				= Logger.getLogger(PropertiesHelp.class);
	
	private String[]					fileName		= { "/properties/config.properties" };
	
	private static PropertiesHelp		propertiesHelps	= null;
	
	public static Map<Object, Object>	map				= null;
	
	private PropertiesHelp() {
		InputStream in = null;
		
		try {
			map = new HashMap<Object, Object>();
			for (String name : fileName) {
				in = PropertiesHelp.class.getResourceAsStream(name);
				Properties props = new Properties();
				props.load(in);
				Set<Object> keys = props.keySet();
				for (Object o : keys) {
					Object t = props.get(o);
					map.put(o, t);
				}
				in.close();
			}
			
		} catch (IOException e) {
			LOG.error(fileName + "read properties fail！");
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				LOG.error(fileName + "closed properties fail！");
			}
		}
	}
	
	public static String getProperty(String key) {
		if (propertiesHelps == null)
			propertiesHelps = new PropertiesHelp();
		try {
			if (LOG.isDebugEnabled()) {
				LOG.debug("properties value：" + (String) map.get(key));
			}
			return (String) map.get(key);
		} catch (Exception e) {
			LOG.error("read [" + key + "] fail" + e);
			return null;
		}
	}
}
