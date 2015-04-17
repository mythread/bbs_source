package com.bbs.mapper;

import java.util.List;

import com.bbs.core.GenericMapper;
import com.bbs.model.Comments;
import com.bbs.model.CommentsExample;

/**
 * 类CommentsMapper.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月17日 下午11:00:58
 */
public interface CommentsMapper extends GenericMapper<Comments, CommentsExample, Integer> {

    List<Comments> selectByTpoicId(Integer topicId);

    Integer count(Comments comments);

    List<Comments> selectByPage(Comments comments);
}
