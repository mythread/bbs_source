package com.bbs.viewparse;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * 类VelocityViewPaser.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月29日 下午9:45:50
 */
public class VelocityViewPaser implements ViewPaser {

	private static VelocityViewPaser instance = new VelocityViewPaser();

	private VelocityViewPaser() {

	}

	public static VelocityViewPaser getInstance() {
		return instance;
	}

	@Override
	public String viewToHtml(Map<String, Object> map, String reloadPath,
			String viewRelativePath) {
		Properties pro = new Properties();
		pro.setProperty("resource.loader", "file");
		pro.setProperty("file.resource.loader.path", reloadPath);
		pro.setProperty("input.encoding", "utf-8");
		pro.setProperty("output.encoding", "utf-8");
		VelocityEngine ve = new VelocityEngine(pro);
		StringWriter sw = new StringWriter();
		VelocityContext velocityContext = new VelocityContext(map);
		ve.mergeTemplate(viewRelativePath, "utf-8", velocityContext, sw);
		String html = sw.toString();
		return html;
	}
}
