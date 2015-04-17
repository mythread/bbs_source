package com.bbs.mapper;

import java.util.List;

import com.bbs.core.GenericMapper;
import com.bbs.model.Topics;
import com.bbs.model.TopicsExample;

/**
 * 类TopicsMapper.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月17日 下午11:11:43
 */
public interface TopicsMapper extends GenericMapper<Topics, TopicsExample, Integer> {

    Integer count(Topics topic);

    List<Topics> selectByPage(Topics topic);
}
