package org.successor.controller;

import cn.hutool.crypto.digest.DigestUtil;
import io.swagger.annotations.Api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.successor.domin.Feedback;
import org.successor.domin.User;
import org.successor.helper.doBookHelper;
import org.successor.service.BackStageService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fauchard
 */
@Api("BackStage")
@Controller
public class BackStageController {
/*    后台登录接口
    http://localhost:8080/backstage
    图书管理接口
    http://localhost:8080/bookManage */

    private static final Log logger = LogFactory.getLog(BackStageController.class);

    @Autowired
    private BackStageService backStageService;

    @RequestMapping(value = "/backstage")
    public String getLogin() {
        return "backstage/adminLogin";
    }

    /**
     * 登录接口
     * @param username
     * @param password
     * @param model
     * @param session
     * @return Stirng
     */
    @RequestMapping(value = "/backlogin")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password, Model model, HttpSession session) {
        String passwordMd5 = DigestUtil.md5Hex(password);
        boolean isLogin = backStageService.getLogin(username, passwordMd5);
        if (isLogin) {
            User user = backStageService.queryUser(username,passwordMd5);
            session.setAttribute("status", true);
            session.setAttribute("user",user);
            return "redirect:bookManage";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重试！");
            return "backstage/adminLogin";
        }
    }

//    退出登录
    @RequestMapping(value = "/backout")
    public String loginOut(HttpSession session){
        session.invalidate(); //销毁session
        return "backstage/adminLogin";
    }


    /**
        图书管理
     */
    @RequestMapping(value = "/bookManage")
    public String bookManage(Model model, HttpSession session) {
        if (null == session.getAttribute("status")) {
            return "backstage/adminLogin";
        }
        List<doBookHelper> bookList = backStageService.getUploadBooks();
        model.addAttribute("bookList", bookList);
        return "backstage/bookManage";
    }

    /**
     * 搜索图书
     * @param days
     * @param model
     * @param session
     * @return String
     */
    @RequestMapping(value = "/searchBookByDays")
    public String searchBookByDays(int days, Model model, HttpSession session) {
        if (null == session.getAttribute("status")) {
            return "backstage/adminLogin";
        }
        List<doBookHelper> bookList = backStageService.getBooksByDays(days);
        model.addAttribute("bookList", bookList);
        return "backstage/bookManage";
    }

    @RequestMapping(value = "/searchBookByTitle")
    public String searchBookByTitle(String title, Model model, HttpSession session) {
        if (null == session.getAttribute("status")) {
            return "backstage/adminLogin";
        }
        List<doBookHelper> bookList = backStageService.getBooksByTitle(title);
        model.addAttribute("bookList", bookList);
        return "backstage/bookManage";
    }

    @RequestMapping(value = "/searchBookByUser")
    public String searchBookByUser(long userId, Model model, HttpSession session) {
        if (null == session.getAttribute("status")) {
            return "backstage/adminLogin";
        }
        List<doBookHelper> bookList = backStageService.getBooksByUserId(userId);
        model.addAttribute("bookList", bookList);
        return "backstage/bookManage";
    }

    @RequestMapping(value = "/deleteBook")
    @ResponseBody
    public Map<String, Object> deleteBook(long bookId) {
        logger.info("you are removing a book!");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int result = backStageService.deleteBook(bookId);
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value = "/userManage")
    public String userManage(Model model, HttpSession session) {
        if (null == session.getAttribute("status")) {
            return "backstage/adminLogin";
        }
        Map<String, Object> resultMap;
        resultMap = backStageService.getUserByContribution();
        List<User> userList = (List<User>) resultMap.get("userList");
        int totalUser = (Integer) resultMap.get("totalUser");
        int weekUser = (Integer) resultMap.get("weekUser");
        int monthUser = (Integer) resultMap.get("monthUser");
        model.addAttribute("userList", userList);
        model.addAttribute("weekUser", weekUser);
        model.addAttribute("monthUser", monthUser);
        model.addAttribute("totalUser", totalUser);
        return "backstage/userManage";
    }

    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public Map<String, Integer> deleteUser(long userId) {
        logger.info("you are removing a user!");
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        int result = backStageService.deleteUser(userId);
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping(value = "/searchUser")
    public String searchUser(String user, Model model, HttpSession session) {
        if (null == session.getAttribute("status")) {
            return "backstage/adminLogin";
        }
        List<User> userList = backStageService.getUserBySearch(user);
        Map<String, Object> resultMap;
        resultMap = backStageService.getUserByContribution();
        int totalUser = (Integer) resultMap.get("totalUser");
        int weekUser = (Integer) resultMap.get("weekUser");
        int monthUser = (Integer) resultMap.get("monthUser");
        model.addAttribute("userList", userList);
        model.addAttribute("weekUser", weekUser);
        model.addAttribute("monthUser", monthUser);
        model.addAttribute("totalUser", totalUser);
        return "backstage/userManage";
    }

    @RequestMapping(value = "/feedbackManage")
    public String feedbackManage(Model model, HttpSession session) {
        if (null == session.getAttribute("status")) {
            return "backstage/adminLogin";
        }
        List<Feedback> feedbackList = backStageService.getFeedback();
        model.addAttribute("feedbackNum", feedbackList.size());
        model.addAttribute("feedbackList", feedbackList);
        return "backstage/feedbackManage";
    }

    @RequestMapping(value = "/setRead")
    @ResponseBody
    public void setFeedbackRead(int feedbackId) {
        backStageService.setOneFeedbackRead(feedbackId);
    }

    @RequestMapping(value = "/setAllRead")
    public String setAllFeedbackRead() {
        backStageService.setAllFeedbackRead();
        return "redirect:feedbackManage";
    }


}
