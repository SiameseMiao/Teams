package cn.work.controller;

import cn.work.controller.request.Accout;
import cn.work.entity.User;
import cn.work.service.UserRoleService;
import cn.work.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class UserController {
    private String backToUrl="/index.html";

    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

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


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String subLogin(@Valid Accout accout, Model model, HttpServletRequest request) {

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(accout.getUserName(),
            accout.getUserPwd());

        try {
            token.setRememberMe(accout.getRememberMe());
            subject.login(token);
        } catch (Exception e) {
            return e.getMessage();
        }

        // 编码方式判断是否具有管理员身份
        if (subject.hasRole("manager")) {
            model.addAttribute("userList",userService.getAllUsers());
            return "redirect:manager";
        }
        model.addAttribute(accout);
        return "index";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@Valid Accout newUser, Model model, HttpServletRequest request){
        User user = userService.getUserByName(newUser.getUserName());
        if (user == null){
            model.addAttribute(newUser);
            userService.insertT(newUser.getUserName(),newUser.getUserPwd(),newUser.getUserPhone(),newUser.getUserEmail());
            userRoleService.insertT(newUser.getUserName(),"user");
            return "redirect:"+"loginPage";
        }else {
            model.addAttribute("message","用户名已被注册！");
            return "redirect:userRegister";
        }
    }

    //logout登出，其实就是删除之前登录时设置的session
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index.html";
    }

    @RequiresRoles("manager")
    @RequestMapping("/manager")
    public String manager(Model model) {
        model.addAttribute("userList",userService.getAllUsers());
        return "admin/userManagerPage";
    }
    //通过注解设置角色权限为manager才可访问
    @RequiresPermissions("user:delete")
    @RequestMapping("/delete")
    public String delete(Model model, int userId) {
        userService.delete(userId);
        return "redirect:manager";
    }
    @RequiresPermissions("user:save")
    @RequestMapping("/save")
    public String save(Model model,@Valid Accout newUser) {
        userService.insertT(newUser.getUserName(),newUser.getUserPwd(),newUser.getUserPhone(),newUser.getUserEmail());
        return "redirect:manager";
    }
    @RequiresPermissions("user:update")
    @RequestMapping("/update")
    public String update(Model model, User newUser) {
        userService.updateT(newUser);
        return "redirect:manager";
    }
    @RequiresPermissions("user:select")
    @RequestMapping("/search")
    public String search(Model model, String search) {
        model.addAttribute("userList",userService.getUserByName(search));
        return "/admin/userManagerPage";
    }
}