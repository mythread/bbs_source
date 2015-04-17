package com.bbs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.core.Pagination;
import com.bbs.model.Nodes;
import com.bbs.model.Topics;
import com.bbs.service.TopicsService;
import com.bbs.web.vo.NodesVO;

/**
 * @author jie.xu 2014年11月14日 下午2:23:29
 */

@Controller
public class HomeController extends BaseController {

    @Autowired
    private TopicsService topicsService;

    @RequestMapping(value = "home.htm")
    public String home(HttpServletRequest request, Model model) {

        Pagination pagination = new Pagination();
        pagination.setLength(20);
        pagination = topicsService.selectByPage(pagination, new Topics());
        model.addAttribute("pagination", pagination);

        List<NodesVO> nodeList = selectAllNodes();
        model.addAttribute("nodeList", nodeList);
        List<Nodes> noChildParentList = new ArrayList<Nodes>();
        for (NodesVO n : nodeList) {
            if (n.hasNoChildList()) {
                noChildParentList.add(n.getParent());
            }
        }
        model.addAttribute("noChildParentNodeList", noChildParentList);
        return "home";
    }

    @RequestMapping("goodbye.htm")
    public String goodbye() {
        return "goodbye";
    }
}
