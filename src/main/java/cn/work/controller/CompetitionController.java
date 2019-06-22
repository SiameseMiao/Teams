package cn.work.controller;

import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.entity.ResourceStore;
import cn.work.service.CategoryService;
import cn.work.service.CompetitionService;
import cn.work.service.StoreService;
import cn.work.util.Constants;
import cn.work.util.HttpServlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * CompetitionController Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-12 18:55
 */
@Controller
@RequestMapping("/competition")
public class CompetitionController {
    private static final int PAGE_SIZE = 2;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,Model model, ServletRequest request) {
        Map<String, Object> searchParams = HttpServlet.getParametersStartingWith(request, "s_");
        Page<Competition> competitions  = competitionService.getEntityPage(searchParams,pageNumber, PAGE_SIZE);
        model.addAttribute("competitions", competitions);
        model.addAttribute("totalPage", competitions.getTotalPages());
        model.addAttribute("totalE", competitions.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("searchParams", HttpServlet.encodeParameterStringWithPrefix(searchParams, "s_"));
        return "admin/articleManage";
    }

    @GetMapping(value = "create")
    public String createCom(ServletRequest request,Model model) {
        int rankId = Integer.valueOf(request.getParameter("rankId"));
        model.addAttribute("competition", new Competition());
        model.addAttribute("res", new ResourceStore());
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
    public String updateCom(HttpServletRequest request) {
        String op="create";
        int rankId=1;
        String name="";
        String content="";
        int pkID=1;
        int pkId=1;
        String savePath = "D:/SSH-FILE";
        File file = new File(savePath);
        String filename="";
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");/*创建目录*/
            file.mkdir();
        }
        String message = "";
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list)
                if (item.isFormField()) {
                    if(item.getFieldName()=="op"||item.getFieldName().equals("op"))
                        op=item.getString("UTF-8");
                    else if(item.getFieldName()=="rankId"||item.getFieldName().equals("rankId"))
                        rankId=Integer.valueOf(item.getString("UTF-8"));
                    else if(item.getFieldName()=="pkID"||item.getFieldName().equals("pkID"))
                        pkID=Integer.valueOf(item.getString("UTF-8"));
                    else if(item.getFieldName()=="pkId"||item.getFieldName().equals("pkId"))
                        pkId=Integer.valueOf(item.getString("UTF-8"));
                    else if(item.getFieldName()=="name"||item.getFieldName().equals("name"))
                        name=item.getString("UTF-8");
                    else if(item.getFieldName()=="content"||item.getFieldName().equals("content"))
                        content=item.getString("UTF-8");
                } else {
                    filename = item.getName();
                    System.out.println(filename);
                    if (filename == null || filename.trim().equals("")) continue;
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {/*使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中*/
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    message = "文件上传成功！";
                }
        } catch (Exception e) {
            message = "文件上传失败！";
            e.printStackTrace();
        }
        if (op == "create" || op.equals("create")) {
            try {
                Category rank = categoryService.getCategory(rankId);
                competitionService.insertT(name, content,Constants.Status.UNDERWAY,rank, LocalDateTime.now().toString().replace("T"," "), LocalDateTime.now().toString().replace("T"," "));
                Competition c=competitionService.getLastest();
                storeService.insert(filename,c.getPkId(),savePath + "\\" + filename,0);
            }catch (Exception e){
            }
        } else if (op == "update" || op.equals("update")) {
            competitionService.updateT(pkId, name, content, LocalDateTime.now().toString().replace("T", " "));
            storeService.update(pkID,filename,pkId,savePath + "\\" + filename,0);
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
            try{
                ResourceStore resourceStore=storeService.getResourceStoreByStore(competitionId);
                storeService.delete(resourceStore.getPkID());
            }catch (Exception e1){}
        } catch (Exception e) {
        }
        return "redirect:/competition/";
    }
}
