package me.freelee.commonutil.vo;

import me.freelee.commonutil.enums.ResultEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Date:2018/11/22
 *
 * @author:Lee
 */
public final class ResultVO implements Serializable {

    private static final long serialVersionUID = 1725159680599612404L;


    public final static  Map<String, Object> failure(int code, String message,Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", data);
        map.put("success",false);
        return map;
    }

    public final static  Map<String, Object> failure(int code, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", null);
        map.put("success",false);
        return map;
    }

    public final static  Map<String, Object> failure(ResultEnum respCode, Object data, Boolean success) {
        return getStringObjectMap(respCode, data,success);
    }

    public final static  Map<String, Object> failure(ResultEnum respCode, Boolean success) {
        return getStringObjectMap(respCode,success);
    }

    /*
     * 成功返回特定的状态码和信息
     * */
    public final static  Map<String, Object> result(ResultEnum respCode, Object data, Boolean success) {
        return getStringObjectMap(respCode, data,success);
    }

    private static  Map<String, Object> getStringObjectMap(ResultEnum respCode, Object data, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", data);
        map.put("success",success);
        return map;
    }

    /*
     * 成功返回特定的状态码和信息
     * */
    public final static  Map<String, Object> result(ResultEnum respCode, Boolean success) {
        return getStringObjectMap(respCode,success);
    }

    private static Map<String, Object> getStringObjectMap(ResultEnum respCode, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }


}

