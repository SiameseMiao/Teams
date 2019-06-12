package cn.work.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class ResourceController extends HttpServlet {


    String savePath = this.getServletContext().getRealPath("D:\SSH-FILE");
    File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
        System.out.println(savePath+"目录不存在，需要创建");
        //创建目录
        file.mkdir();
    }
    String message = "";
        try{
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        if(!ServletFileUpload.isMultipartContent(request)){
            return;
        }
        List<FileItem> list = upload.parseRequest(request);
        for(FileItem item : list){
            if(item.isFormField()){
                String name = item.getFieldName();
                String value = item.getString("UTF-8");
                System.out.println(name + "=" + value);
            }else{
                String filename = item.getName();
                System.out.println(filename);
                if(filename==null || filename.trim().equals("")){
                    continue;
                }
                filename = filename.substring(filename.lastIndexOf("\\")+1);
                InputStream in = item.getInputStream();
                FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                byte buffer[] = new byte[1024];

                int len = 0;

                while((len=in.read(buffer))>0){
                    //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
                item.delete();
                message = "文件上传成功！";
            }
        }
    }catch (Exception e) {
        message= "文件上传失败！";
        e.printStackTrace();
    }



}
