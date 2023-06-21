package org.successor.controller;

import cn.hutool.crypto.digest.DigestUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.successor.domin.User;
import org.successor.helper.UserHelper;
import org.successor.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Api("登录")
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    private static final Log logger = LogFactory.getLog(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> index(@RequestBody User user, HttpSession session) {
        logger.info("you are logging in!");
        UserHelper userHelper = userService.getLoginUser(user.getUserCode(),DigestUtil.md5Hex(user.getUserPassword()));
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (null != userHelper) {
            session.setAttribute("userHelper",userHelper);
            resultMap.put("isLogined", true);
            resultMap.put("user", userHelper);
        } else {
            resultMap.put("isLogined", false);
        }
        return resultMap;
    }

    //退出登录
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        logger.info("you have logged out!");
        session.invalidate();
        return "redirect:/index";
    }

    private String emailFrom = "18924030432@163.com";
    /**
     *  找回密码
     *      输入邮箱号
     *      邮箱接收
     *
     *
     */
    @RequestMapping(value = "/reMail")
    public void findpassword(@RequestParam("email") String email, Model model, HttpSession session){
        //通过邮箱查询是否有这个用户存在
        User user = userService.queryByMail(email);
        //如果有进行下一步
        if (user != null ){
            //生成六位数验证码
            String captcha = String.valueOf(new Random().nextInt(899999) + 100000);
            session.setAttribute("captcha",captcha);
            //生成随机码发送到指定邮箱 进入密码重置模块
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(email);
            //邮件主题
            message.setSubject("新华书店重置密码");
            //邮件内容
            message.setText("localhost:8080/resetPassword"+captcha);
        }else{
            model.addAttribute("error", "发送邮箱失败,没有此用户");
        }
    }

    //密码重置模块
    @RequestMapping(value = "/resetPassword")
    public String resetPassword(){

        //密码修改成功后 跳转到登录页面
        return "login";
    }



}
