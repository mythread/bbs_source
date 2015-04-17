package com.bbs.service;

import java.util.List;

import com.bbs.core.GenericService;
import com.bbs.model.Nodes;
import com.bbs.model.NodesExample;

/**
 * 类NodesService.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午1:56:52
 */
public interface NodesService extends GenericService<Nodes, NodesExample, Integer> {

    /**
     * 查询parent_id == null 的节点
     */
    List<Nodes> selectParentNodes();

    /**
     * 通过parent_id 查询子节点
     */
    List<Nodes> selectChildNodes(Integer parentId);

}
