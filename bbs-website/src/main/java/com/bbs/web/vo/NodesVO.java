/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司
 * FileName: NodesVO.java
 * Author:   jie.xu
 * Date:     2014年12月13日 下午3:04:01
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.bbs.web.vo;

import java.util.List;

import com.bbs.model.Nodes;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author jie.xu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NodesVO {

    private Nodes parent;
    private List<Nodes> childNodelist;

    public NodesVO(Nodes parentNode, List<Nodes> childNodeList) {
        this.parent = parentNode;
        this.childNodelist = childNodeList;
    }

    public Nodes getParent() {
        return parent;
    }

    public void setParent(Nodes parent) {
        this.parent = parent;
    }

    public List<Nodes> getChildNodelist() {
        return childNodelist;
    }

    public void setChildNodelist(List<Nodes> childNodelist) {
        this.childNodelist = childNodelist;
    }

    public boolean hasNoChildList() {
        if (childNodelist == null || childNodelist.isEmpty()) {
            return true;
        }
        return false;
    }

}
