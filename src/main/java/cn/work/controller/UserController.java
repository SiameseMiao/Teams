package cn.work.controller;



import cn.work.controller.request.Accout;
import cn.work.entity.User;
import cn.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Controller
@RequestMapping("/home")
public class UserController {
    private String backToUrl="/index.html";
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public String login( String backTo){
        backToUrl=backTo;
        return "loginPage";
    }
    @RequestMapping(value = "/userRegister",method = RequestMethod.GET)
    public String register(){
        return "registerPage";
    }
    @RequestMapping(value = "/personal",method = RequestMethod.GET)
    public String personal(){
        return "personalPage";
    }

    //执行login操作，匹配用户名和密码，建立session持久连接
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@Valid Accout accout, Model model, HttpServletRequest request){
        accout = userService.checkAccount(accout.getUserName(),accout.getUserPwd());
        if (accout != null){
            if(accout.getUserName().equals("admin")) {
                return "redirect:/manager";
            }
            model.addAttribute(accout);
            request.getSession(true).setAttribute("userIfo",accout);
            return "redirect:"+backToUrl;
        }else {
            model.addAttribute("message","登录名或密码错误！");
            return "redirect:userLogin";
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@Valid Accout newUser, Model model, HttpServletRequest request){
        User user = userService.getUserByName(newUser.getUserName());
        if (user == null){
            model.addAttribute(newUser);
            request.getSession(true).setAttribute("userIfo",newUser);
            userService.insertT(newUser.getUserName(),newUser.getUserPwd(),newUser.getUserPhone(),newUser.getUserEmail());
            return "redirect:"+backToUrl;
        }else {
            model.addAttribute("message","用户名已被注册！");
            return "redirect:userRegister";
        }
    }
    //logout登出，其实就是删除之前登录时设置的session
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        Accout user= (Accout) request.getSession().getAttribute("userIfo");
        request.getSession().removeAttribute("userIfo");
        return "redirect:/index.html";
    }




}

