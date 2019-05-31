package cn.work.controller;

import cn.work.controller.request.Accout;
import cn.work.entity.User;
import cn.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserManagerController {
    @Autowired
    UserService userService;
    @RequestMapping("/manager")
    public String getMannger(Model model){
        model.addAttribute("userList",userService.getAllUsers());
        return "/admin/userManagePage";
    }
    @RequestMapping("/delete")
    public String delete(Model model, int userId) {
        userService.delete(userId);
        return "redirect:manager";
    }
    @RequestMapping("/save")
    public String save(Model model,@Valid Accout newUser) {
        userService.insertT(newUser.getUserName(),newUser.getUserPwd(),newUser.getUserPhone(),newUser.getUserEmail());
        return "redirect:manager";
    }
    @RequestMapping("/update")
    public String update(Model model, User newUser) {
        userService.updateT(newUser);
        return "redirect:manager";
    }
    @RequestMapping("/search")
    public String search(Model model, String search) {
        model.addAttribute("search",userService.getUserByName(search));
        return "/admin/userManagePage";
    }

}
