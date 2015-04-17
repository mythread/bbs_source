package com.bbs.viewparse;

import java.util.Map;

/**
 * @author jie.xu 2014年11月29日 下午9:42:37
 */
public interface ViewPaser {

	/**
	 * 
	 * @param map
	 *            view页面动态数据
	 * 
	 * @param reloadPath
	 *            模板加载路径
	 * 
	 * @param viewRelativePath
	 *            view模板相对对路径
	 * @return
	 */
	public String viewToHtml(Map<String, Object> map, String reloadPath,
			String viewRelativePath);

}
