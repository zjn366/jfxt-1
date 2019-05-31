package com.thinkgem.jeesite.modules.app.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018-05-2814:52
 */
public class AppResult {

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
}
