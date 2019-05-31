package com.thinkgem.jeesite.common.filemanage;

import com.thinkgem.jeesite.common.config.Global;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018-05-3015:23
 */
public class FileUpload {
    //  文件上传
    public static String upload(HttpServletRequest request, String filePath, MultipartFile file) throws IOException {

        //String path = request.getSession().getServletContext().getRealPath(filePath);
        String gcName = request.getContextPath();
        String path= Global.getUserfilesBaseDir()+ filePath;
        File dirFile = new File(path);
        if (!dirFile.exists()) {    //创建文件夹
            dirFile.mkdirs();
        }
        SimpleDateFormat fomate = new SimpleDateFormat("yyyyMMddhhmmss");
        //判断文件是否为空
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();

            String dateTimePx = fomate.format(new Date());
            path = path+"/"+dateTimePx+fileName;
            File uploadFile = new File(path);
            file.transferTo(uploadFile);    //上传
            //filePath=filePath+"/"+dateTimePx+fileName; //返回页面路径
            filePath = gcName+filePath+"/"+dateTimePx + fileName;  //返回相对路径
        }
        return filePath;
    }
}
