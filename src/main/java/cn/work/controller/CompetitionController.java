package cn.work.controller;

import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.service.CategoryService;
import cn.work.service.CompetitionService;
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
import java.time.LocalDateTime;
import java.util.List;

/**
 * CompetitionController Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-12 18:55
 */
@Controller
@RequestMapping("/competition")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        List<Competition> competitions = competitionService.getAllCompetitions();
        model.addAttribute("competitions", competitions);
        return "admin/articleManage";
    }

    @PostMapping(value = "search")
    public String list(Model model, @RequestParam int rankId) {
        try {
            Category rank = categoryService.getCategory(rankId);
            List<Competition> competitions = competitionService.getCompetitionByRank(rank);
            model.addAttribute("competitions", competitions);
        }catch (Exception e){
        }
        return "admin/articleManage";
    }

    @GetMapping(value = "create")
    public String createCom(ServletRequest request,Model model) {
        int rankId = Integer.valueOf(request.getParameter("rankId"));
        model.addAttribute("competition", new Competition());
        model.addAttribute("rankId", rankId);
        model.addAttribute("action", "create");
        return "admin/articleNew";
    }

    @GetMapping("update")
    public String updateCom(ServletRequest request, Model model) {
        int comId = Integer.valueOf(request.getParameter("id"));
        Competition competition = competitionService.getCompetition(comId);
        model.addAttribute("competition", competition);
        model.addAttribute("rankId", 0);
        model.addAttribute("action", "update");
        return "admin/articleNew";
    }

    @PostMapping(value = "action")
    public String updateCom(@RequestParam String op,@RequestParam int rankId, @Valid Competition competition,Model model) {
        if (op == "create" || op.equals("create")) {
            try {
                Category rank = categoryService.getCategory(rankId);
                competitionService.insertT(competition.getName(), competition.getContent(),Constants.Status.UNDERWAY,rank, LocalDateTime.now().toString().replace("T"," "), LocalDateTime.now().toString().replace("T"," "));
            }catch (Exception e){
            }
        } else if (op == "update" || op.equals("update")) {
            competitionService.updateT(competition.getPkId(), competition.getName(), competition.getContent(), LocalDateTime.now().toString().replace("T", " "));
        }
        return "redirect:/competition";
    }

    @GetMapping("stop")
    public String stopCompetition(ServletRequest request) {
        int competitionId = Integer.valueOf(request.getParameter("id"));
        Competition competition = competitionService.getCompetition(competitionId);
        if (competition.getStatus() == Constants.Status.OVER)
            competitionService.forbid(competitionId, Constants.Status.UNDERWAY);
        else {
            competitionService.forbid(competitionId, Constants.Status.OVER);
        }
        return "redirect:/competition/";
    }

    @RequestMapping(value = "delete")
    public String delete(ServletRequest request) {
        int competitionId = Integer.valueOf(request.getParameter("id"));
        try {
            competitionService.deleteById(competitionId);
        } catch (Exception e) {
        }
        return "redirect:/competition/";
    }
}
