package cn.work.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@Controller
@RequestMapping("/download")
public class DownloadController
{
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path=request.getParameter("D:\\SSH-FILE\\word.txt");
   path=new String(path.getBytes("ISO-8859-1"),"GBK");
   File file=new File(path);
    InputStream in=new FileInputStream(file);
      OutputStream os=response.getOutputStream();
       response.addHeader("Content-Disposition","attachment;filename="+new String(file.getName().getBytes("GBK"),"ISO-8859-1"));
      response.addHeader("Content-Length",file.length()+"");
      response.setCharacterEncoding("GBK");
      response.setContentType("application/octet-stream");
      int data=0;
      while((data = in.read())!=-1  ){
         os.write(data);
      }
      os.close();
      in.close();
    }

}
