/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司
 * FileName: TopicsController.java
 * Author:   jie.xu
 * Date:     2014年12月13日 下午2:02:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.bbs.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import com.alibaba.fastjson.JSON;
import com.bbs.core.IResult;
import com.bbs.core.JsonResult;
import com.bbs.core.Pagination;
import com.bbs.model.Comments;
import com.bbs.model.Nodes;
import com.bbs.model.PictureTopic;
import com.bbs.model.PictureTopicExample;
import com.bbs.model.Topics;
import com.bbs.model.Users;
import com.bbs.model.base.BasePictureTopicExample.Criteria;
import com.bbs.service.CommentsService;
import com.bbs.service.NodesService;
import com.bbs.service.PictureTopicService;
import com.bbs.service.TopicsService;
import com.bbs.service.UsersService;
import com.bbs.service.constant.Constant;
import com.bbs.validator.FieldValidator;
import com.bbs.validator.Validator;
import com.bbs.web.utils.FileUploadUtils;
import com.bbs.web.vo.NodesVO;
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
@RequestMapping("/topics")
public class TopicsController extends BaseController {

    @Autowired
    private TopicsService topicsService;

    @Autowired
    private NodesService nodesService;

    @Autowired
    private PictureTopicService pictureTopicService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private UsersService usersService;

    /**
     * 
     * 功能描述: <br>
     * 跳到创建新话题页面
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("new_from_home.htm")
    public String newFromHome(Model model) {
        WebUser webUser = WebUser.get();
        if (!webUser.isLogin()) {
            return "redirect:/users/sign_in.htm";
        }
        List<NodesVO> list = selectAllNodes();

        Collections.sort(list, new Comparator<NodesVO>() {

            @Override
            public int compare(NodesVO o1, NodesVO o2) {
                if (o1.hasNoChildList() && !o2.hasNoChildList()) {
                    return -1;
                }
                if (!o1.hasNoChildList() && o2.hasNoChildList()) {
                    return 1;
                }
                return 0;
            }
        });
        model.addAttribute("nodeList", list);
        return "topics/newfromhome";
    }

    /**
     * 
     * 功能描述: <br>
     * 更多主题列表页
     * 
     * @param p
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("list.htm")
    public String list(Integer p, Model model) {
        if (p == null) {
            p = 1;
        }

        Pagination pagination = new Pagination();
        pagination.setLength(20);
        pagination.setCurrent(p);
        pagination = topicsService.selectByPage(pagination, new Topics());
        model.addAttribute("pagination", pagination);
        model.addAttribute("p", p);
        return "topics/list";

    }

    /**
     * 
     * 功能描述: <br>
     * 保存主题
     * 
     * @param title
     * @param content
     * @param nodeId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("create_from_home.htm")
    @Validator(fieldsValidate = {@FieldValidator(field = "title", required = true, maxLength = 150, message = "标题太长！"),
            @FieldValidator(field = "content", required = true, maxLength = 1000000, message = "内容太长"),
            @FieldValidator(field = "nodeId", required = true, message = "请选择个节点")}, view = "topics/newfromhome.vm")
    public String createFromHome(String title, String content, Integer nodeId, String[] picUrlAndAliasName,
            String picUrl, String aliasName, Model model) {
        WebUser webUser = WebUser.get();
        Topics topic = new Topics();
        topic.setUserId(webUser.getId());
        topic.setTitle(title);
        topic.setContent(HtmlUtils.htmlEscape(content));
        topic.setNodeId(nodeId);
        topic.setCreatedAt(new Date());
        topic.setUpdatedAt(new Date());
        topic.setLastRepliedAt(new Date());
        topic.setCommentsClosed((byte) 0);
        topic.setCommentsCount(0);
        topic.setBrowseNum(0);
        topic = topicsService.insert(topic);
        if (topic == null) {
            model.addAttribute(Constant.ERROR_MSG, "创建主题操作失败");
            return "topics/newfromhome";
        } else {
            if (picUrlAndAliasName != null && picUrlAndAliasName.length > 0) {
                for (String str : picUrlAndAliasName) {
                    // 向picture_topic 插入数据
                    String[] subArray = str.split("#");
                    PictureTopic pt = new PictureTopic();
                    pt.setCreatedAt(new Date());
                    pt.setUpdatedAt(new Date());
                    pt.setTopicId(topic.getId());
                    pt.setPicUrl(subArray[0]);
                    pt.setAliasName(subArray[1]);
                    pictureTopicService.insert(pt);
                }

            }
            return "redirect:/topics/" + topic.getId() + ".htm";
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 主题详情页，解析图片url
     * 
     * @param id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("{id}.htm")
    public String detail(@PathVariable("id") Integer id, Model model, HttpServletRequest request,
            HttpServletResponse response) {
        if (id == null) {
            return "redirect:/";
        }
        Topics topic = topicsService.selectByPrimaryKey(id);
        topic.setBrowseNum(topic.getBrowseNum() + 1);
        PictureTopicExample picEx = new PictureTopicExample();
        Criteria criteria = picEx.createCriteria();
        criteria.andTopicIdEqualTo(id);
        List<PictureTopic> picList = pictureTopicService.selectByExample(picEx);
        if (picList != null && picList.size() > 0) {
            // String content = topic.getContent();
            String content = HtmlUtils.htmlUnescape(topic.getContent());
            for (PictureTopic pt : picList) {
                content = StringUtils.replace(content, pt.getAliasName(), getImageHtml(pt.getPicUrl()));
            }
            topic.setContent(content);
        }

        // 更新浏览次数
        Topics updateTopic = new Topics();
        updateTopic.setId(id);
        updateTopic.setUpdatedAt(new Date());
        updateTopic.setBrowseNum(topic.getBrowseNum());
        topicsService.updateByPrimaryKeySelective(updateTopic);

        // 查询评论
        List<Comments> commentList = commentsService.selectByTpoicId(id);
        for (Comments c : commentList) {
            if (c.hasOldComment()) {
                c.setOldComment(commentsService.selectByPrimaryKey(id));
            }
        }

        model.addAttribute("topic", topic);
        model.addAttribute("commentList", commentList);

        Nodes node = nodesService.selectByPrimaryKey(topic.getNodeId());
        Integer parentNodeId = node.getParentId();
        if (parentNodeId != null) {
            node.setParent(nodesService.selectByPrimaryKey(parentNodeId));
        }
        model.addAttribute("node", node);

        Integer userId = topic.getUserId();
        Users user = usersService.selectByPrimaryKey(userId);
        if (user == null) {
            user = new Users();
        }
        model.addAttribute("user", user);
        model.addAttribute("headTitle", topic.getTitle());

        // CookieManager cm = CookieManagerLocator.get(request, response);
        // cm.set(CookieKeyEnum.user_email, "test");
        return "topics/detail";
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param picUrl
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String getImageHtml(String picUrl) {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<br>");
        sb.append("<img src=\"");
        sb.append(picUrl);
        sb.append("\"  class=\"external\"/>");
        sb.append("<br>");
        return sb.toString();
    }

    /**
     * 
     * 功能描述: <br>
     * 主题帖子的图片上传
     * 
     * @return
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("uploadPic.htm")
    @ResponseBody
    public void uploadTopicPic(MultipartFile upload, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String type = "bbs_topic";
        JsonResult json = null;
        try {
            InputStream in = upload.getInputStream();
            String fileName = upload.getOriginalFilename();
            long size = upload.getSize();
            IResult<String> result = FileUploadUtils.upload(in, type, fileName, size);
            if (!result.success()) {
                json = new JsonResult(false, "上传出错！");
            } else {
                String picUrl = result.data();
                json = new JsonResult(true, "", picUrl);
            }
        } catch (Exception e) {
            json = new JsonResult(false, "上传出错！");
        }
        response.setContentType("application/json");
        response.getWriter().write(JSON.toJSON(json).toString());
    }

    /**
     * 
     * 功能描述: <br>
     * 添加评论
     * 
     * @param topicId
     * @param content
     * @param oldCommentId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("{topicId}/comments.htm")
    @Validator(fieldsValidate = {@FieldValidator(field = "content", required = true, maxLength = 200, message = "评论字数太多")}, view = "topics/detail.vm")
    public String comment(@PathVariable("topicId") Integer topicId, String content, Integer oldCommentId) {
        WebUser user = WebUser.get();
        Comments comment = new Comments();
        content = HtmlUtils.htmlEscape(content);
        comment.setContent(getRealContent(content));
        comment.setCreatedAt(new Date());
        comment.setUpdatedAt(new Date());
        comment.setTopicId(topicId);
        comment.setUserId(user.getId());
        comment.setPostingDevice(getAtNickName(content));
        if (oldCommentId != null) {
            comment.setOldCommentId(oldCommentId);
        }
        comment = commentsService.insert(comment);
        if (comment != null) {
            // 更新主题
            Topics topic = topicsService.selectByPrimaryKey(topicId);
            topic.setCommentsCount(topic.getCommentsCount() + 1);
            topic.setUpdatedAt(new Date());
            topic.setLastRepliedAt(new Date());
            topic.setLastRepliedBy(user.getNickname());
            topicsService.updateByPrimaryKeySelective(topic);
        }
        return "redirect:/topics/" + topicId + ".htm";
    }

    /**
     * 获取@的用户昵称
     */
    private String getAtNickName(String comment) {
        int index = StringUtils.indexOf(comment, "@");
        if (index == -1) {
            return null;
        }
        String subComment = comment.substring(index);
        int spaceIndex = subComment.indexOf(" ");
        if (spaceIndex != -1) {
            return subComment.substring(index + 1, spaceIndex);
        } else {
            return null;
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 获取评论内容
     * 
     * @param content
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String getRealContent(String comment) {
        int index = StringUtils.indexOf(comment, "@");
        if (index == -1) {
            return comment;
        }
        String realComment = comment.substring(index + 1);
        int spaceIndex = realComment.indexOf(" ");
        if (spaceIndex != -1) {
            return realComment.substring(spaceIndex + 1);
        } else {
            return realComment;
        }
    }
}
