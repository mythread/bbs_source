package com.bbs.model;

import com.bbs.model.base.Basenodes;

/**
 * 类Nodes.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月17日 下午10:26:02
 */
public class Nodes extends Basenodes {

    private Nodes parent;

    public Nodes getParent() {
        return parent;
    }

    public void setParent(Nodes parent) {
        this.parent = parent;
    }

}
