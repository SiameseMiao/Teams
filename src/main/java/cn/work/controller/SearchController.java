package cn.work.controller;

import cn.work.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SearchController Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-05-24 22:49
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    ArticleService articleService;
    @RequestMapping(value = "/search",method= RequestMethod.GET)
    public String search(Model map, @RequestParam String search){
        map.addAttribute("itemList",articleService.searchByName(search));
        System.out.println(articleService.searchByName(search));
        return "searchPage";
    }
}
