package com.bbs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbs.model.Nodes;
import com.bbs.model.Users;
import com.bbs.service.NodesService;
import com.bbs.web.vo.NodesVO;
import com.bbs.web.webuser.WebUser;

/**
 * @author jie.xu 2014年11月23日 下午10:00:16
 */
public class BaseController {

    @Autowired
    protected NodesService nodesService;

    /**
     * 获取ip
     * 
     * @param request
     * @return
     */
    protected String getRemoteHostIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    protected List<NodesVO> selectAllNodes() {
        // 查询节点
        List<NodesVO> list = new ArrayList<NodesVO>();
        List<Nodes> parentList = nodesService.selectParentNodes();
        for (Nodes n : parentList) {
            List<Nodes> childNodeList = nodesService.selectChildNodes(n.getId());
            list.add(new NodesVO(n, childNodeList));
        }
        return list;
    }

    protected void convertWebUserByUser(Users user) {
        WebUser u = WebUser.get();
        if (u == null && user != null) {
            u = new WebUser();
            u.setId(user.getId());
            u.setAvatar(user.getAvatar());
            u.setEmail(user.getEmail());
            u.setNickname(user.getNickname());
            WebUser.set(u);
        }
    }
}
