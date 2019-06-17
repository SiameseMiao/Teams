package cn.work.controller;

import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.service.CategoryService;
import cn.work.service.CompetitionService;
import cn.work.util.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * SearchController Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-05-24 22:49
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    private static final int PAGE_SIZE = 3;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CompetitionService competitionService;
    @RequestMapping(value = "/search",method= RequestMethod.GET)
    public String search(Model map, @RequestParam String search){
        map.addAttribute("itemList",competitionService.getAllCompetitionsByName(search));
        System.out.println(competitionService.getAllCompetitionsByName(search));
        return "searchPage";
    }
    @RequestMapping(value = "/container",method = RequestMethod.GET)
    public String container(Model model, ServletRequest request){
        int id = Integer.valueOf(request.getParameter("itemId"));
        Competition competition = competitionService.getCompetition(id);
        model.addAttribute("compe",competition);
        return "mainContainer";
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,Model model, ServletRequest request) {
        Map<String, Object> searchParams = HttpServlet.getParametersStartingWith(request, "s_");
        Page<Competition> competitions  = competitionService.getEntityPage(searchParams,pageNumber, PAGE_SIZE);
        if(!searchParams.values().isEmpty()){
            try {
                int rankId=Integer.valueOf(searchParams.get("EQ_rank").toString());
                Category rank = categoryService.getCategory(rankId);
                Category type = categoryService.getCategory(rank.getFid());
                model.addAttribute("rank",rank.getName());
                model.addAttribute("type",type.getName());
            }catch (Exception e){}
        }
        model.addAttribute("competitions", competitions);
        model.addAttribute("totalPage", competitions.getTotalPages());
        model.addAttribute("totalE", competitions.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("searchParams", HttpServlet.encodeParameterStringWithPrefix(searchParams, "s_"));
        return "competitionPage";
    }
}
