package cn.work.controller;

import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.entity.ResourceStore;
import cn.work.service.CategoryService;
import cn.work.service.CompetitionService;
import cn.work.service.StoreService;
import cn.work.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
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
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        List<Category> categories = categoryService.getCategoriesByFid(0);
        List<Category> list = new ArrayList<Category>();
        walkCategoryTree(categories, "|--", list);
        model.addAttribute("categorys", list);
        return "admin/columnManage";
    }

    public void walkCategoryTree(List<Category> categories, String prefix, List<Category> list) {
        for (Category top : categories) {
            if (top.getFid() != 0) {
                top.setName(prefix + top.getName());
            }
            list.add(top);
            try {
                List<Category> category = categoryService.getCategoriesByFid(top.getId());
                walkCategoryTree(category, prefix, list);
            } catch (Exception e) {
            }
        }
    }

    @PostMapping(value = "update")
    public String updateCategory(@Valid Category category) {
        categoryService.updateT(category.getId(), category.getName(), Constants.Status.ENABLE);
        return "redirect:/category";
    }

    @PostMapping(value = "create")
    public String createCategory(@Valid Category category) {
        categoryService.insertT(category.getName(), category.getFid(), Constants.Status.ENABLE);
        return "redirect:/category/";
    }

    @GetMapping("forbid")
    public String forbidCategory(ServletRequest request) {
        int categoryId = Integer.valueOf(request.getParameter("id"));
        Category category = categoryService.getCategory(categoryId);
        if (category.getStatus() == Constants.Status.DISABLE) {
            categoryService.forbid(category.getId(), Constants.Status.ENABLE);
        }
        else {
            if (category.getFid() == 0) try {
                List<Category> categorys = categoryService.getCategoriesByFid(categoryId);
                for (Category top : categorys) {
                    int rankId = top.getId();
                    try {
                        List<Competition> competitions = competitionService.getCompetitionByRank(top);
                        for (Competition temp : competitions)
                            try {
                                competitionService.deleteById(temp.getPkId());
                                try{
                                    ResourceStore resourceStore=storeService.getResourceStoreByStore(temp.getPkId());
                                    storeService.delete(resourceStore.getPkID());
                                }catch (Exception e1){
                                }
                            } catch (Exception e) {
                            }
                    } catch (Exception e) {
                    }
                    try {
                        categoryService.deleteById(rankId);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e) {
            }
            else try {
                List<Competition> competitions = competitionService.getCompetitionByRank(category);
                for (Competition temp : competitions)
                    try {
                        competitionService.deleteById(temp.getPkId());
                        try{
                            ResourceStore resourceStore=storeService.getResourceStoreByStore(temp.getPkId());
                            storeService.delete(resourceStore.getPkID());
                        }catch (Exception e1){
                        }
                    } catch (Exception e) {
                    }
            } catch (Exception e) {
            }
            categoryService.forbid(category.getId(), Constants.Status.DISABLE);
        }
        return "redirect:/category";
    }

    @RequestMapping(value = "delete")
    public String delete(ServletRequest request) {
        int categoryId = Integer.valueOf(request.getParameter("id"));
        Category category = categoryService.getCategory(categoryId);
        if (category.getFid() == 0) try {
            List<Category> categorys = categoryService.getCategoriesByFid(categoryId);
            for (Category top : categorys) {
                int rankId = top.getId();
                try {
                    List<Competition> competitions = competitionService.getCompetitionByRank(top);
                    for (Competition temp : competitions)
                        try {
                            competitionService.deleteById(temp.getPkId());
                            try{
                                ResourceStore resourceStore=storeService.getResourceStoreByStore(temp.getPkId());
                                storeService.delete(resourceStore.getPkID());
                            }catch (Exception e1){
                            }
                        } catch (Exception e) {
                        }
                } catch (Exception e) {
                }
                try {
                    categoryService.deleteById(rankId);
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
        else try {
            List<Competition> competitions = competitionService.getCompetitionByRank(category);
            for (Competition temp : competitions){
                try {
                    competitionService.deleteById(temp.getPkId());
                    try{
                        ResourceStore resourceStore=storeService.getResourceStoreByStore(temp.getPkId());
                        storeService.delete(resourceStore.getPkID());
                    }catch (Exception e1){
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
        try {
            categoryService.deleteById(categoryId);
        } catch (Exception e) {
        }
        return "redirect:/category/";
    }
}
