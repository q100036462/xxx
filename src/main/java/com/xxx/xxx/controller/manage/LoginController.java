package com.xxx.xxx.controller.manage;

import com.xxx.xxx.entity.User;
import com.xxx.xxx.service.UserService;
import com.xxx.xxx.utils.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        //使用subject.isAuthenticated()判断用户是否已验证返回true/false.
        if(SecurityUtils.getSubject().isAuthenticated()){
            User user = UserUtils.getUser();
            session.setAttribute("userinfo", user);
        }else{
            model.addAttribute("error", "登陆名或密码错误！");
        }
        return "login";
    }

    @RequestMapping("/")
    public String turnIndexPage() {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    @RequestMapping("toReg")
    private String toReg(){
        return "reg";
    }

    @RequestMapping("/main")
    public String main(){
        return "page/main";
    }

    @RequestMapping("/totest")
    public String totest(){
        return "test";
    }

}
