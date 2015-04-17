package com.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.core.GenericMapper;
import com.bbs.core.GenericServiceImpl;
import com.bbs.core.Pagination;
import com.bbs.mapper.TopicsMapper;
import com.bbs.model.Topics;
import com.bbs.model.TopicsExample;
import com.bbs.service.TopicsService;

/**
 * 类TopicsServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午2:08:28
 */
@Service("topicsService")
public class TopicsServiceImpl extends GenericServiceImpl<Topics, TopicsExample, Integer> implements TopicsService {

    @Autowired
    private TopicsMapper topicsMapper;

    @Override
    protected GenericMapper<Topics, TopicsExample, Integer> getGenericMapper() {
        return topicsMapper;
    }

    @Override
    public Pagination selectByPage(Pagination pagination, Topics topic) {
        Integer count = topicsMapper.count(topic);
        List<Topics> dataList = new ArrayList<Topics>();
        if (count != null && count > 0) {
            topic.setPagination(pagination);
            dataList = topicsMapper.selectByPage(topic);
        }
        pagination.setCount(count);
        pagination.setDataList(dataList);
        return pagination;
    }
}
