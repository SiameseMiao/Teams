package cn.work.controller;

import cn.work.entity.Competition;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        List<Competition> competitions = competitionService.getAllCompetitions();
        model.addAttribute("competitions", competitions);
        return "admin/articleManage";
    }

    @PostMapping(value = "search")
    public String list(Model model, @RequestParam int rankId) {
        List<Competition> competitions = competitionService.getCompetitionByRank(rankId);
        model.addAttribute("competitions", competitions);
        return "admin/articleManage";
    }

    @GetMapping(value = "list")
    public String list(ServletRequest request, Model model) {
        int rankId = Integer.valueOf(request.getParameter("rankId"));
        List<Competition> competitions = competitionService.getCompetitionByRank(rankId);
        model.addAttribute("competitions", competitions);
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
        model.addAttribute("action", "update");
        return "admin/articleNew";
    }

    @PostMapping(value = "action")
    public String updateCom(@Valid String op, @Valid Competition competition) {
        if (op == "create" || op.equals("create")) {
            competitionService.insertT(competition.getName(), competition.getContent(),Constants.Status.UNDERWAY,competition.getRank(), LocalDateTime.now(), LocalDateTime.now());
        } else if (op == "update" || op.equals("update"))
            competitionService.updateT(competition.getPkId(), competition.getName(), competition.getContent(), LocalDateTime.now());
        return "redirect:/competition/";
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
