package cn.work.controller;


import cn.work.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Controller
public class ArticleController {
    @Autowired
    CompetitionService competitionService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String indexfirst(){
        return "index";
    }
    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
     public String index(){
        return "index";
    }
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public String categories(Model map){
        map.addAttribute("itemList",competitionService.getAllCompetitions());
        return "categoriesPage";
    }

}
