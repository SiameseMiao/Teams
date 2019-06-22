package cn.work.controller;

import cn.work.entity.ResourceStore;
import cn.work.service.StoreService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/resourceStore")
public class UploadController {
    @Autowired
    private StoreService storeService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String list(Model model){
        List<ResourceStore> resourceStores=storeService.getResourceStore();
        model.addAttribute("resourceStores", resourceStores);
        //System.out.println(resourceStores);
        return "admin/resourceStore";
    }

    @PostMapping(value = "update")
    public String updateResourceStore(@Valid ResourceStore resourceStore) {
        System.out.println(resourceStore.getPkID()+" "+resourceStore.getName()+" "+resourceStore.getStore()+" "+resourceStore.getDesStore());
        storeService.update(resourceStore.getPkID(), resourceStore.getName(), resourceStore.getStore(), resourceStore.getDesStore(), 0);
        return "redirect:/resourceStore/";
    }
    @RequestMapping(value = "delete")
    public String delete(ServletRequest request) {
        int resourceStoreId = Integer.valueOf(request.getParameter("id"));
        try {
            storeService.delete(resourceStoreId);
        }catch (Exception e){
        }
        return "redirect:/resourceStore/";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path=request.getParameter("path");
        path = new String(path.getBytes("ISO-8859-1"), "UTF-8");
        File file = new File(path);
        InputStream in = new FileInputStream(file);
        OutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"));
        response.addHeader("Content-Length", file.length() + "");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        int data = 0;
        while ((data = in.read()) != -1) os.write(data);
        os.close();
        in.close();
        return;
    }
}
