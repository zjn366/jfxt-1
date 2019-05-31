package com.thinkgem.jeesite.common.filemanage;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 文件下载
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018-05-2610:33
 */
@Controller
@RequestMapping(value = "${adminPath}/fileDown")
public class FileDownController extends BaseController {

    /**
     * 文件单个下载
     * @param request
     * @param response
     */
    @RequestMapping(value="/download")
    public void download(HttpServletRequest request, HttpServletResponse response){

        String path=request.getParameter("path");
        try {
            //解决获取路径中文乱码问题
            // path = new String(request.getParameter("path").getBytes("iso-8859-1"), "utf-8");
            //String temp = request.getSession().getServletContext().getRealPath("/");
            path = path.replaceAll("/crossfire","");//将路径中的项目名称去掉
            path = Global.getUserfilesBaseDir()+path;
        }catch (Exception e){
            e.printStackTrace();
        }

        String strpath = "";
        if(StringUtils.isNotEmpty(path)){
            strpath = path;
            File file = new File(strpath);
            InputStream inputStream = null;
            OutputStream outputStream = null;
            byte[] b= new byte[1024];
            int len = 0;
            try {
                inputStream = new FileInputStream(file);
                outputStream = response.getOutputStream();

                response.setContentType("application/force-download");
                String filename = file.getName();
                response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
                response.setContentLength( (int) file.length( ) );

                while((len = inputStream.read(b)) != -1){
                    outputStream.write(b, 0, len);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(outputStream != null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    /**
     * 批量下载文件并压缩 new
     * @param request
     * @param response
     */
    @RequestMapping("/downloadAll")
    public void downloadAll(HttpServletRequest request, HttpServletResponse response){


        try {
            response.reset();
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Content-Disposition", "attachment; filename=html580.zip");
            response.setContentType("application/x-zip-compressed");
            response.setContentType("application/octet-stream;charset=ISO-8859-1");

            //String temp = request.getSession().getServletContext().getRealPath("/");//获取项目根路径
            String temp = Global.getUserfilesBaseDir();
            String path=request.getParameter("path");
            String paths[]=path.split(",");
            // path = temp+path;

            ServletOutputStream fileOut = response.getOutputStream();
            ZipOutputStream out = new ZipOutputStream(fileOut);

            //File inputFolder = new File("这里是需要压缩的文件");
            // File[] files= inputFolder.listFiles();     //返回某个目录下所有文件和目录的绝对路径，返回的是File数组(就是文件夹下面的所有文件)
            for (int i = 0; i < paths.length; i++) {
                String filePaht =temp+paths[i].replaceAll("/crossfire","");//将路径中的项目名称去掉
                File file = new File(filePaht) ;//这里根据已有的文件路径得到对应的某一个文件
                if(file.exists()){
                    ZipEntry ze = new ZipEntry(file.getName());
                    ze.setSize(file.length());
                    ze.setTime(file.lastModified());
                    out.putNextEntry(ze);
                    InputStream stream = new FileInputStream(file);
                    int bytesRead = 0;
                    byte[] buffer = new byte[8192];
                    while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
                        out.write(buffer, 0,bytesRead);
                    }
                    stream.close();
                }
            }
            out.close();
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
