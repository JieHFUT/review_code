package com.example.demo.common;

import java.util.HashMap;

/**
 * 自定义的统一返回对象
 */
public class AjaxResult {
    /**
     * 业务执行成功时进行返回的方法
     *
     * @param data
     * @return
     */
    public static HashMap<String, Object> success(Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "");
        result.put("data", data);
        return result;
    }

    /**
     * 业务执行成功时进行返回的方法
     *
     * @param data
     * @return
     */
    public static HashMap<String, Object> success(String msg, Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    /**
     * 业务执行失败返回的数据格式
     *
     * @param code
     * @param msg
     * @return
     */
    public static HashMap<String, Object> fail(int code, String msg) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", "");
        return result;
    }

    /**
     * 业务执行失败返回的数据格式
     *
     * @param code
     * @param msg
     * @return
     */
    public static HashMap<String, Object> fail(int code, String msg, Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}
