package com.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.core.GenericMapper;
import com.bbs.core.GenericServiceImpl;
import com.bbs.mapper.NodesMapper;
import com.bbs.model.Nodes;
import com.bbs.model.NodesExample;
import com.bbs.model.base.BasenodesExample.Criteria;
import com.bbs.service.NodesService;

/**
 * 类NodesServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午2:06:56
 */
@Service("nodesService")
public class NodesServiceImpl extends GenericServiceImpl<Nodes, NodesExample, Integer> implements NodesService {

    @Autowired
    private NodesMapper nodesMapper;

    @Override
    protected GenericMapper<Nodes, NodesExample, Integer> getGenericMapper() {
        return nodesMapper;
    }

    @Override
    public List<Nodes> selectParentNodes() {
        NodesExample nodesEx = new NodesExample();
        Criteria criteria = nodesEx.createCriteria();
        criteria.andParentIdIsNull();
        return nodesMapper.selectByExample(nodesEx);
    }

    @Override
    public List<Nodes> selectChildNodes(Integer parentId) {
        NodesExample nodesEx = new NodesExample();
        Criteria criteria = nodesEx.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return nodesMapper.selectByExample(nodesEx);
    }

}
