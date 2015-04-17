package com.bbs.web.controller;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bbs.cookie.CookieKeyEnum;
import com.bbs.cookie.manager.CookieManager;
import com.bbs.cookie.manager.CookieManagerLocator;
import com.bbs.core.IResult;
import com.bbs.model.Accounts;
import com.bbs.model.AccountsExample;
import com.bbs.model.Users;
import com.bbs.model.UsersExample;
import com.bbs.model.base.BaseusersExample.Criteria;
import com.bbs.service.AccountsService;
import com.bbs.service.UsersService;
import com.bbs.service.constant.Constant;
import com.bbs.util.EncryptUtils;
import com.bbs.validator.FieldValidator;
import com.bbs.validator.Validator;
import com.bbs.web.utils.FileUploadUtils;
import com.bbs.web.webuser.WebUser;

/**
 * 
 * @author jie.xu 2014年11月18日 下午2:57:34
 */
@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AccountsService accountsService;

    /**
     * @ModelAttribute Users users
     * @param binder
     */
    @InitBinder("users")
    public void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("users.");
    }

    /**
     * 跳到注册页面
     */
    @RequestMapping("sign_up.htm")
    public String signUp() {
        return "users/signup";
    }

    @RequestMapping("sign_in.htm")
    public String tosignIn() {
        return "users/signin";
    }

    /**
     * 
     * 功能描述: 用户登入<br>
     * 〈功能详细描述〉
     * 
     * @param email
     * @param password
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("save_sign_in.htm")
    @Validator(fieldsValidate = {
            @FieldValidator(field = "email", required = true, maxLength = 32, message = "邮箱账号太长！"),
            @FieldValidator(field = "password", required = true, maxLength = 128, message = "密码太长！")}, view = "users/signin.vm")
    public String signIn(String email, String password, Model model, HttpServletRequest request,
            HttpServletResponse response) {
        email = StringUtils.trimToEmpty(email);
        password = StringUtils.trimToEmpty(password);
        UsersExample usersEx = new UsersExample();
        Criteria criteria = usersEx.createCriteria();
        criteria.andEmailEqualTo(email);
        criteria.andPasswordEqualTo(EncryptUtils.encrypt(password));
        List<Users> userList = usersService.selectByExample(usersEx);
        if (userList == null || userList.isEmpty()) {
            model.addAttribute(Constant.ERROR_MSG, "无效用户！");
            return "users/signin";
        }
        Users u = userList.get(0);
        CookieManager cookieManager = CookieManagerLocator.get(request, response);
        cookieManager.set(CookieKeyEnum.user_id, u.getId() + "");
        cookieManager.set(CookieKeyEnum.user_avatar, StringUtils.trimToEmpty(u.getAvatar()));
        cookieManager.set(CookieKeyEnum.user_email, StringUtils.trimToEmpty(u.getEmail()));
        cookieManager.set(CookieKeyEnum.user_nickname, StringUtils.trimToEmpty(u.getNickname()));

        // convertWebUserByUser(u);
        // model.addAttribute(Constant.SUCCESS_MSG, "登入成功");
        u.setSignInCount(u.getSignInCount() + 1);
        u.setLastSignInAt(u.getCurrentSignInAt());
        u.setLastSignInIp(u.getCurrentSignInIp());
        u.setCurrentSignInAt(new Date());
        u.setCurrentSignInIp(getRemoteHostIP(request));
        u.setUpdatedAt(new Date());
        usersService.updateByPrimaryKeySelective(u);
        return "redirect:/home.htm";
    }

    /**
     * 
     * 功能描述: <br>
     * 退出操作，清除cookie
     * 
     * @param request
     * @param response
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("sign_out.htm")
    public String signOut(HttpServletRequest request, HttpServletResponse response) {

        CookieManager cookieManager = CookieManagerLocator.get(request, response);
        cookieManager.set(CookieKeyEnum.user_id, "");
        cookieManager.set(CookieKeyEnum.user_avatar, "");
        cookieManager.set(CookieKeyEnum.user_email, "");
        cookieManager.set(CookieKeyEnum.user_nickname, "");

        return "redirect:/goodbye.htm";
    }

    /**
     * 注册
     */
    @RequestMapping("registe.htm")
    @Validator(fieldsValidate = {
            @FieldValidator(field = "nickname", required = true, maxLength = 20, message = "昵称字数太长！"),
            @FieldValidator(field = "email", required = true),
            @FieldValidator(field = "password", required = true, maxLength = 110, message = "密码太长"),
            @FieldValidator(field = "password_confirmation", required = true, maxLength = 110, message = "密码太长")}, view = "users/signup.vm")
    public String registe(String nickname, String email, String password, String password_confirmation, Model model,
            HttpServletRequest request, HttpServletResponse response) {
        password = StringUtils.trimToEmpty(password);
        password_confirmation = StringUtils.trimToEmpty(password_confirmation);
        if (!StringUtils.equals(password, password_confirmation)) {
            model.addAttribute(Constant.ERROR_MSG, "密码输入不一致！");
            return "users/signup";
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            model.addAttribute(Constant.ERROR_MSG, "email不合法！");
            return "users/signup";
        }

        // 验证nickname，email 数据库是否存在
        UsersExample usersEx = new UsersExample();
        Criteria criteria = usersEx.createCriteria();
        criteria.andNicknameEqualTo(nickname.trim());
        List<Users> usersList = usersService.selectByExample(usersEx);
        if (usersList != null && usersList.size() > 0) {
            model.addAttribute(Constant.ERROR_MSG, "该昵称已存在！");
            return "users/signup";
        }
        UsersExample usersEx2 = new UsersExample();
        Criteria criteria2 = usersEx2.createCriteria();
        criteria2.andEmailEqualTo(email.trim());
        List<Users> emailList = usersService.selectByExample(usersEx2);
        if (emailList != null && emailList.size() > 0) {
            model.addAttribute(Constant.ERROR_MSG, "该email已存在！");
            return "users/signup";
        }

        Users users = new Users();
        users.setNickname(StringUtils.trim(nickname));
        users.setEmail(StringUtils.trim(email));
        users.setPassword(EncryptUtils.encrypt(password));
        users.setSignInCount(1);
        Date date = new Date();
        users.setCreatedAt(date);
        users.setUpdatedAt(date);
        users.setCurrentSignInAt(date);
        users.setCurrentSignInIp(getRemoteHostIP(request));
        users.setType(0);
        users.setAvatar("/static/img/avatar_default.png");
        users = usersService.insert(users);

        if (users == null) {
            model.addAttribute(Constant.ERROR_MSG, "操作失败");
            return "users/signup";
        } else {
            // cookie写入
            CookieManager cookieManager = CookieManagerLocator.get(request, response);
            cookieManager.set(CookieKeyEnum.user_id, users.getId() + "");
            cookieManager.set(CookieKeyEnum.user_nickname, users.getNickname());
            cookieManager.set(CookieKeyEnum.user_email, users.getEmail());
            cookieManager.set(CookieKeyEnum.user_avatar, users.getAvatar());
            convertWebUserByUser(users);
            return "redirect:/";
        }
    }

    /**
     * 个人设置页面
     */
    @RequestMapping("settings.htm")
    public String settings(Integer updateFlag, Model model) {
        WebUser user = WebUser.get();
        AccountsExample accountEx = new AccountsExample();
        com.bbs.model.base.BaseaccountsExample.Criteria criteria = accountEx.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        List<Accounts> accounts = accountsService.selectByExample(accountEx);
        if (accounts.size() > 0) {
            model.addAttribute("account", accounts.get(0));
            if (updateFlag != null && updateFlag == 1) {
                model.addAttribute(Constant.SUCCESS_MSG, "更新成功");
                model.addAttribute("updateFlag", 1);
            }
        } else {
            model.addAttribute("account", new Accounts());
        }
        return "users/settings";
    }

    /**
     * 修改密码
     */
    @RequestMapping("update_password.htm")
    @Validator(fieldsValidate = {@FieldValidator(field = "current_password", required = true),
            @FieldValidator(field = "password", required = true),
            @FieldValidator(field = "password_confirmation", required = true)}, view = "users/settings.vm")
    public String updatePasswd(String current_password, String password, String password_confirmation, Model model) {
        WebUser user = WebUser.get();

        String encryptPasswd = EncryptUtils.encrypt(StringUtils.trim(current_password));

        UsersExample usersEX = new UsersExample();
        Criteria criteria = usersEX.createCriteria();
        criteria.andPasswordEqualTo(encryptPasswd);
        List<Users> usersList = usersService.selectByExample(usersEX);
        if (usersList != null && usersList.size() > 0) {
            model.addAttribute(Constant.ERROR_MSG, "当前密码输入无效");
            return "users/settings";
        }
        if (!password.trim().equals(password_confirmation.trim())) {
            model.addAttribute(Constant.ERROR_MSG, "两次密码输入不一致");
            return "users/settings";
        }
        // account
        AccountsExample accountsEx = new AccountsExample();
        com.bbs.model.base.BaseaccountsExample.Criteria acCriteria = accountsEx.createCriteria();
        acCriteria.andUserIdEqualTo(user.getId());
        List<Accounts> accountsList = accountsService.selectByExample(accountsEx);
        if (accountsList != null && accountsList.size() > 0) {
            model.addAttribute("account", accountsList.get(0));
        }

        String newEncryptPasswd = EncryptUtils.encrypt(password.trim());

        Users users = new Users();
        users.setPassword(newEncryptPasswd);
        users.setId(user.getId());
        users.setUpdatedAt(new Date());
        int flag = usersService.updateByPrimaryKeySelective(users);
        if (flag > 0) {
            model.addAttribute(Constant.SUCCESS_MSG, "密码修改成功");
        } else {
            model.addAttribute(Constant.ERROR_MSG, "密码修改失败");
        }
        return "users/settings";
    }

    /**
     * TODO:参数验证， 修改account表信息
     */
    @RequestMapping("update_account.htm")
    public String updateAccount(Accounts accounts, Model model) {
        WebUser user = WebUser.get();
        IResult<Accounts> result = accountsService.insertOrUpdate(accounts, user.getId());
        if (result.success()) {
            model.addAttribute("updateFlag", 1);
            return "redirect:settings.htm";
        } else {
            model.addAttribute(Constant.ERROR_MSG, result.message());
            return "users/settings";
        }
    }

    /**
     * <pre>
     * 上传头像
     * 72 x 64
     * 更新cookie 头像值
     * </pre>
     */
    @RequestMapping("update_avatar.htm")
    public String updateAvatar(MultipartFile avatar, Model model, HttpServletRequest request,
            HttpServletResponse response) {
        String type = "bbs_avatar";
        try {
            InputStream in = avatar.getInputStream();
            String fileName = avatar.getOriginalFilename();
            long size = avatar.getSize();
            IResult<String> result = FileUploadUtils.upload(in, type, fileName, size);
            if (!result.success()) {
                model.addAttribute(Constant.ERROR_MSG, result.message());
            } else {
                String avatarUrl = result.data();
                model.addAttribute(Constant.SUCCESS_MSG, result.message());
                CookieManager cookieManager = CookieManagerLocator.get(request, response);
                cookieManager.set(CookieKeyEnum.user_avatar, avatarUrl);

                // 更新头像
                WebUser webUser = WebUser.get();
                Users u = new Users();
                u.setId(webUser.getId());
                u.setAvatar(avatarUrl);
                u.setUpdatedAt(new Date());
                usersService.updateByPrimaryKeySelective(u);
                return "redirect:/users/settings.htm?updateFlag=1#avatar";
            }
        } catch (Exception e) {
            model.addAttribute(Constant.ERROR_MSG, "上传出错");
        }
        return "users/settings";
    }
}
