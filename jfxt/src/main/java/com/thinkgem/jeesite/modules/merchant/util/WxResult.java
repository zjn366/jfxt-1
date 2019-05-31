package com.thinkgem.jeesite.modules.merchant.util;

import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.merchant.entity.*;
import com.thinkgem.jeesite.modules.merchant.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
@RequestMapping(value = "/wxrest")
public class WxResult extends BaseController {

    @Autowired
    JfXjggService jfXjggService;

    @Autowired
    JfXjgcService jfXjgcService;

    @Autowired
    JfZgService jfZgService;

    @Autowired
    JfCfService jfCfService;

    @Autowired
    JfXxService jfXxService;

    @Autowired
    JfGlbzService jfGlbzService;

    public static final int RESULT_STATUS_SUCCESS = 1;    //成功
    public static final int RESULT_STATUS_FAILURE = 0;    //失败

    /***自定义返回成功**/
    public static Map<String, Object> writeResultRep(Object object, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", RESULT_STATUS_SUCCESS);
        map.put("msg", msg);
        map.put("data", object);
        return map;
    }

    /***自定义失败返回成功**/
    public static Map<String, Object> writeResultFailure(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", RESULT_STATUS_FAILURE);
        map.put("msg", msg);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ShowCfImg",method = RequestMethod.POST)
    public Object ShowCfImg(HttpServletRequest request, HttpServletResponse response, String id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            JfCf jfCf= jfCfService.get(id);
            String imgs=jfCf.getCfxczp();
            if (imgs!=null||!imgs.equals(" ")){
                String[] img_arr=imgs.split("\\|");
                List<String> imgList=new ArrayList<String>();
                for (int i=0;i<img_arr.length;i++){
                        StringBuffer img=new StringBuffer(img_arr[i]);
                        img.insert(0,"/jfxt");
                        imgList.add(img.toString());
                }
                return writeResultRep(imgList,"查询图片成功");
            }else{
                return writeResultFailure("图片加载失败");
            }
        }catch (Exception e){
            return writeResultFailure("请求图片失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/ShowZgImg",method = RequestMethod.POST)
    public Object ShowZgImg(HttpServletRequest request, HttpServletResponse response, String id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            JfZg jfZg= jfZgService.get(id);
            String imgs=jfZg.getCfxczp();
            if (imgs!=null||!imgs.equals(" ")){
                String[] img_arr=imgs.split("\\|");
                List<String> imgList=new ArrayList<String>();
                for (int i=0;i<img_arr.length;i++){
                    if(StringUtils.isNotBlank(img_arr[i])){
                        StringBuffer img=new StringBuffer(img_arr[i]);
                        img.insert(0,"/jfxt");
                        imgList.add(img.toString());
                    }
                }
                return writeResultRep(imgList,"查询图片成功");
            }else{
                return writeResultFailure("图片加载失败");
            }
        }catch (Exception e){
            return writeResultFailure("请求图片失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/ShowJfImg",method = RequestMethod.POST)
    public Object ShowJfImg(HttpServletRequest request, HttpServletResponse response, String id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
//            return writeResultRep();
            JfXx jfXx= jfXxService.get(id);
            String imgs=jfXx.getJfxctp();
            if (imgs!=null||!imgs.equals(" ")){
                String[] img_arr=imgs.split("\\|");
                List<String> imgList=new ArrayList<String>();
              for (int i=1;i<img_arr.length;i++){
                  imgList.add(img_arr[i]);
              }
                return writeResultRep(imgList,"图片添加成功");
            }else{
                return writeResultFailure("请添加图片");
            }
        }catch (Exception e){
            return writeResultFailure("请求图片失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/ggGlShow", method = RequestMethod.POST)
    public Object ggGlShow(HttpServletRequest request, HttpServletResponse response, String id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            JfXjgg aa = jfXjggService.get(id);
            return writeResultRep(aa, "请求产品详情成功");
        } catch (Exception e) {
            return writeResultFailure("请求产品详情失败");
        }

    }

    @ResponseBody
    @RequestMapping(value = "/ShowXjGcImg", method = RequestMethod.POST)
    public Object ShowXjGcImg(HttpServletRequest request, HttpServletResponse response, String id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            JfXjgc jfXjgc = jfXjgcService.get(id);
            String imgs = jfXjgc.getXczp();
            if (imgs != null || !imgs.equals(" ")) {
                String[] img_arr = imgs.split("\\|");
                List<String> imgList = new ArrayList<String>();
                for (int i=0;i<img_arr.length;i++){
                    if(StringUtils.isNotBlank(img_arr[i])){
                        StringBuffer img=new StringBuffer(img_arr[i]);
                        img.insert(0,"/jfxt");
                        imgList.add(img.toString());
                    }
                }
                return writeResultRep(imgList, "图片加载成功");
            }else{
                return writeResultFailure("图片加载失败");
            }
        }catch (Exception e){
             return writeResultFailure("图片加载失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/jfbzShow", method = RequestMethod.POST)
    public Object jfbzShow(HttpServletRequest request, HttpServletResponse response, String id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            JfGlbz aa = jfGlbzService.get(id);

            return writeResultRep(aa, "请求产品详情成功");
        } catch (Exception e) {
            return writeResultFailure("请求产品详情失败");
        }

    }
}




