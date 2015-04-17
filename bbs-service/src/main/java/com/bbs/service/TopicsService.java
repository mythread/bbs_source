package com.bbs.service;

import com.bbs.core.GenericService;
import com.bbs.core.Pagination;
import com.bbs.model.Topics;
import com.bbs.model.TopicsExample;

/**
 * 类TopicsService.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午1:58:28
 */
public interface TopicsService extends GenericService<Topics, TopicsExample, Integer> {

    public Pagination selectByPage(Pagination pagination, Topics topic);
}
