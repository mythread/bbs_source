/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司
 * FileName: MemberController.java
 * Author:   jie.xu
 * Date:     2014年12月28日 下午8:15:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.bbs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.core.Pagination;
import com.bbs.model.Accounts;
import com.bbs.model.AccountsExample;
import com.bbs.model.Comments;
import com.bbs.model.Topics;
import com.bbs.model.Users;
import com.bbs.model.UsersExample;
import com.bbs.service.AccountsService;
import com.bbs.service.CommentsService;
import com.bbs.service.TopicsService;
import com.bbs.service.UsersService;

/**
 * 〈一句话功能简述〉<br>
 * 个人中心
 * 
 * @author jie.xu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    @Autowired
    private TopicsService topicsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private AccountsService accountsService;

    @RequestMapping("{nickname}.htm")
    public String memberCenter(@PathVariable String nickname, Model model) {
        UsersExample usersEx = new UsersExample();
        com.bbs.model.base.BaseusersExample.Criteria criteria = usersEx.createCriteria();
        criteria.andNicknameEqualTo(nickname);
        List<Users> userList = usersService.selectByExample(usersEx);
        if (userList.isEmpty()) {
            return "redirect:/";
        }

        Users webUser = userList.get(0);
        model.addAttribute("user", webUser);
        AccountsExample accountEx = new AccountsExample();
        com.bbs.model.base.BaseaccountsExample.Criteria criteria2 = accountEx.createCriteria();
        criteria2.andUserIdEqualTo(webUser.getId());
        List<Accounts> accounts = accountsService.selectByExample(accountEx);
        Accounts account = null;
        if (accounts == null || accounts.isEmpty()) {
            account = new Accounts();
        } else {
            account = accounts.get(0);
        }
        model.addAttribute("account", account);

        // 最近创建的话题
        Topics t = new Topics();
        t.setUserId(webUser.getId());
        Pagination pagination = new Pagination();
        pagination.setLength(Integer.MAX_VALUE);
        pagination = topicsService.selectByPage(pagination, t);
        List<Topics> lastestTopics = pagination.getDataList();
        model.addAttribute("lastestTopics", lastestTopics);

        // 最近的回复
        Comments comment = new Comments();
        comment.setUserId(webUser.getId());
        Pagination cpagination = new Pagination();
        cpagination.setLength(Integer.MAX_VALUE);
        cpagination = commentsService.selectByPage(cpagination, comment);
        List<Comments> lastestComments = cpagination.getDataList();
        model.addAttribute("lastestComments", lastestComments);
        return "member/index";
    }
}
