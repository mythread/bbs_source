/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司
 * FileName: NodesController.java
 * Author:   jie.xu
 * Date:     2014年12月26日 下午5:11:29
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.bbs.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.core.Pagination;
import com.bbs.model.Nodes;
import com.bbs.model.Topics;
import com.bbs.service.NodesService;
import com.bbs.service.TopicsService;
import com.bbs.service.constant.Constant;
import com.bbs.validator.FieldValidator;
import com.bbs.validator.Validator;
import com.bbs.web.webuser.WebUser;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author jie.xu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class NodesController extends BaseController {

    @Autowired
    private TopicsService topicsService;

    @Autowired
    private NodesService nodesService;

    @RequestMapping("/nodes/{id}.htm")
    public String list(@PathVariable("id") Integer id, Integer p, Model model) {
        if (p == null) {
            p = 1;
        }
        Topics t = new Topics();
        t.setNodeId(id);

        Pagination pagination = new Pagination();
        pagination.setLength(20);
        pagination.setCurrent(p);
        pagination = topicsService.selectByPage(pagination, t);
        model.addAttribute("pagination", pagination);
        model.addAttribute("nodeId", id);

        Nodes node = nodesService.selectByPrimaryKey(id);
        Integer parentNodeId = node.getParentId();
        if (parentNodeId != null) {
            node.setParent(nodesService.selectByPrimaryKey(parentNodeId));
        }
        model.addAttribute("node", node);
        return "nodes/list";
    }

    @RequestMapping("/nodes/{nodeId}/topics.htm")
    @Validator(fieldsValidate = {@FieldValidator(field = "title", required = true, maxLength = 150, message = "标题太长！"),
            @FieldValidator(field = "content", required = true, maxLength = 1000000, message = "内容太长")}, view = "nodes/list.vm")
    public String createTopicByNodeId(@PathVariable Integer nodeId, String title, String content, Model model) {
        if (nodeId == null) {
            return "redirect:/";
        }

        WebUser webUser = WebUser.get();
        Topics topic = new Topics();
        topic.setUserId(webUser.getId());
        topic.setTitle(title);
        topic.setContent(content);
        topic.setNodeId(nodeId);
        topic.setCreatedAt(new Date());
        topic.setUpdatedAt(new Date());
        topic.setCommentsClosed((byte) 0);
        topic.setCommentsCount(0);
        topic.setBrowseNum(0);
        topic = topicsService.insert(topic);
        if (topic == null) {
            model.addAttribute(Constant.ERROR_MSG, "创建主题操作失败");
            return "nodes/list";
        }
        return "redirect:/topics/" + topic.getId() + ".htm";
    }
}
