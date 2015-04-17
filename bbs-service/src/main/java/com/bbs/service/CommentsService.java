package com.bbs.service;

import java.util.List;

import com.bbs.core.GenericService;
import com.bbs.core.Pagination;
import com.bbs.model.Comments;
import com.bbs.model.CommentsExample;

/**
 * 类CommentsService.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午1:54:37
 */
public interface CommentsService extends GenericService<Comments, CommentsExample, Integer> {

    List<Comments> selectByTpoicId(Integer topicId);

    public Pagination selectByPage(Pagination pagination, Comments comments);
}
