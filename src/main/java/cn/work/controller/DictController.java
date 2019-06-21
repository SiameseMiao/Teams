package cn.work.controller;

import cn.work.entity.Dict;
import cn.work.service.DictService;
import cn.work.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * DictController Class
 *
 * @author <b>Zhengchunyu2016012011</b>, Copyright &#169; 2018
 * @version 1.0, 2019-05-24 23:58
 */
@Controller
@RequestMapping("/dict")
public class DictController {
    @Autowired
    private DictService dictService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String list(Model model){
        List<Dict> dicts=dictService.getDict();
        model.addAttribute("dicts", dicts);
        //System.out.println(dicts);
        return "admin/dict";
    }
    @PostMapping(value = "search")
    public String list(Model model, @RequestParam String type){
        List<Dict> dicts=dictService.getDictByType(type);
        model.addAttribute("dicts", dicts);
        return "admin/dict";
    }
    @GetMapping(value = "list")
    public String list(ServletRequest request,Model model){
        String type=request.getParameter("type");
        List<Dict> dicts=dictService.getDictByType(type);
        model.addAttribute("dicts", dicts);
        return "admin/dict";
    }
    @PostMapping(value = "update")
    public String updateDict(@Valid Dict dict, Model model) {
        model.addAttribute("type", dict.getType());
        dictService.update(dict.getDictId(), dict.getType(), dict.getCode(), dict.getName(), dict.getSort(), Constants.Status.ENABLE);
        return "redirect:/dict/list";
    }
    @PostMapping(value = "create")
    public String createDict(@Valid Dict dict) {
        float sort = dictService.getMaxSort(dict.getType());
        dictService.insert(dict.getType(), dict.getCode(), dict.getName(),sort+1,Constants.Status.ENABLE);
        return "redirect:/dict/";
    }
    @GetMapping("forbid")
    public String forbidDict(ServletRequest request) {
        int dictId = Integer.valueOf(request.getParameter("id"));
        Dict dict =  dictService.getDictById(dictId);
        if(dict.getStatus()==Constants.Status.DISABLE){
            dictService.forbid(dictId,Constants.Status.ENABLE);}
        else{
            dictService.forbid(dictId,Constants.Status.DISABLE);}
        return "redirect:/dict/";
    }
    @RequestMapping(value = "delete")
    public String delete(ServletRequest request, RedirectAttributes redirectAttributes) {
        int dictId = Integer.valueOf(request.getParameter("id"));
        try {
            dictService.delete(dictId);
        }catch (Exception e){
        }
        return "redirect:/dict/";
    }
    @GetMapping(value = "new")
    public String newArticle(Model model) {
        List<Dict> dict1=dictService.getDictByTypeAndStatus("类别",Constants.Status.ENABLE);
        List<Dict> dict2=dictService.getDictByTypeAndStatus("级别",Constants.Status.ENABLE);
        model.addAttribute("type", dict1);
        model.addAttribute("grade", dict2);
        return "admin/articleNew";
    }
}
