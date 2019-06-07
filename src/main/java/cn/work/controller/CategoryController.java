package cn.work.controller;

import cn.work.entity.Category;
import cn.work.service.CategoryService;
import cn.work.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * CategoryController Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-07 19:04
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String list(Model model){
        List<Category> categorys=categoryService.getAllCategorys();
        model.addAttribute("categorys", categorys);
        return "admin/columnManage";
    }

    @PostMapping(value = "search")
    public String list(Model model, @RequestParam String name) {
        List<Category> categorys = categoryService.getCategoriesByName(name);
        model.addAttribute("categorys", categorys);
        return "admin/columnManage";
    }
    @PostMapping(value = "update")
    public String updateCategory(@Valid Category category) {
        categoryService.updateT(category.getId(),category.getName(),Constants.Status.ENABLE);
        return "redirect:/category";
    }
    @PostMapping(value = "create")
    public String createCategory(@Valid Category category) {
        categoryService.insertT(category.getName(),category.getFid(),Constants.Status.ENABLE);
        return "redirect:/category/";
    }
    @GetMapping("forbid")
    public String forbidCategory(ServletRequest request) {
        int categoryId = Integer.valueOf(request.getParameter("id"));
        Category category =  categoryService.getCategory(categoryId);
        if(category.getStatus()== Constants.Status.DISABLE){
            categoryService.forbid(category.getId(),Constants.Status.ENABLE);}
        else{
            categoryService.forbid(category.getId(),Constants.Status.DISABLE);}
        return "redirect:/category";
    }
    @RequestMapping(value = "delete")
    public String delete(ServletRequest request) {
        int categoryId = Integer.valueOf(request.getParameter("id"));
        try {
            categoryService.deleteById(categoryId);
        }catch (Exception e){
        }
        return "redirect:/category/";
    }
}
