package com.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.core.GenericMapper;
import com.bbs.core.GenericServiceImpl;
import com.bbs.core.Pagination;
import com.bbs.mapper.CommentsMapper;
import com.bbs.model.Comments;
import com.bbs.model.CommentsExample;
import com.bbs.service.CommentsService;

/**
 * 类CommentsServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午2:03:36
 */
@Service("commentsService")
public class CommentsServiceImpl extends GenericServiceImpl<Comments, CommentsExample, Integer> implements
        CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    protected GenericMapper<Comments, CommentsExample, Integer> getGenericMapper() {
        return commentsMapper;
    }

    @Override
    public List<Comments> selectByTpoicId(Integer topicId) {
        return commentsMapper.selectByTpoicId(topicId);
    }

    @Override
    public Pagination selectByPage(Pagination pagination, Comments comments) {
        Integer count = commentsMapper.count(comments);
        List<Comments> dataList = new ArrayList<Comments>();
        if (count != null && count > 0) {
            comments.setPagination(pagination);
            dataList = commentsMapper.selectByPage(comments);
        }
        pagination.setCount(count);
        pagination.setDataList(dataList);
        return pagination;
    }

}
