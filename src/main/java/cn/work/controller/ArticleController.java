package cn.work.controller;


import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.service.CategoryService;
import cn.work.service.CompetitionService;
import cn.work.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Controller
public class ArticleController {
    @Autowired
    CompetitionService competitionService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String indexfirst(Model model){
        List<Category> categories = categoryService.findCategoriesByFidAndStatus(0, Constants.Status.ENABLE);
        model.addAttribute("categories", categories);
        return "index";
    }
    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
     public String index(Model model){
        List<Category> categories = categoryService.findCategoriesByFidAndStatus(0, Constants.Status.ENABLE);
        model.addAttribute("categories", categories);
        return "index";
    }
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public String categories(Model model, ServletRequest request){
        int categoryId = Integer.valueOf(request.getParameter("id"));
        Category category = categoryService.getCategory(categoryId);
        List<Category> rinks = categoryService.getCategoriesByFid(categoryId);
        List<Competition> list = new ArrayList<Competition>();
        for (Category top : rinks) {
            try {
                List<Competition> Competition = competitionService.getCompetitionByRank(top);
                for (Competition temp : Competition) {
                    list.add(temp);
                }
            } catch (Exception e) {
            }
        }
        model.addAttribute("type",category.getName());
        model.addAttribute("itemList",list);
        return "categoriesPage";
    }

}
