package cn.work.controller;

import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.entity.ResourceStore;
import cn.work.service.CategoryService;
import cn.work.service.CompetitionService;
import cn.work.service.StoreService;
import cn.work.util.Constants;
import cn.work.util.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/search",method= RequestMethod.GET)
    public String search(Model map, @RequestParam String search){
        search="%"+search+"%";
        List<Competition> competitions=competitionService.vagueSearch(search,search);
        map.addAttribute("itemList",competitions);
        return "searchPage";
    }
    @RequestMapping(value = "/search2",method= RequestMethod.GET)
    public String search2(Model map, @RequestParam String search,@RequestParam int type){
        search="%"+search+"%";
        Category category = categoryService.getCategory(type);
        List<Category> ranks = categoryService.findCategoriesByFidAndStatus(type, Constants.Status.ENABLE);
        List<Competition> list = new ArrayList<Competition>();
        for (Category top : ranks) {
            try {
                List<Competition> Competition = competitionService.getAllCompetitionsByRankAndName(top,search);
                for (Competition temp : Competition) {
                    list.add(temp);
                }
            } catch (Exception e) {
            }
        }
        map.addAttribute("type",category);
        map.addAttribute("itemList",list);
        map.addAttribute("rankItem",ranks);
        return "categoriesPage";
    }
    @RequestMapping(value = "/container",method = RequestMethod.GET)
    public String container(Model model, ServletRequest request){
        int id = Integer.valueOf(request.getParameter("itemId"));
        Competition competition = competitionService.getCompetition(id);
        ResourceStore resourceStore=storeService.getResourceStoreByStore(id);
        model.addAttribute("compe",competition);
        model.addAttribute("res",resourceStore);
        return "mainContainer";
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,Model model, ServletRequest request) {
        Map<String, Object> searchParams = HttpServlet.getParametersStartingWith(request, "s_");
        if(!searchParams.values().isEmpty()){
            try {
                int rankId=Integer.valueOf(searchParams.get("EQ_rank").toString());
                Category rank = categoryService.getCategory(rankId);
                Category type = categoryService.getCategory(rank.getFid());
                model.addAttribute("rank",rank.getName());
                model.addAttribute("type",type);
            }catch (Exception e){}
        }
        Page<Competition> competitions  = competitionService.getEntityPage(searchParams,pageNumber, PAGE_SIZE);
        model.addAttribute("competitions", competitions);
        model.addAttribute("totalPage", competitions.getTotalPages());
        model.addAttribute("totalE", competitions.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("searchParams", HttpServlet.encodeParameterStringWithPrefix(searchParams, "s_"));
        return "competitionPage";
    }
}
