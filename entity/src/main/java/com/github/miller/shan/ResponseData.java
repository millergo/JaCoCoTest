package com.github.miller.shan;

import lombok.Data;

import java.util.Map;

/**
 * @Project: common
 * @Author: Miller
 * @Time: 2020-5-20 14:42:00
 * @Email: miller.shan.dd@gmail.com;miller.shan@aliyun.com
 * @Description: 统一返回格式
 **/
@Data
public class ResponseData {
    /**
     * 是否存在错误。成功返回false, 失败返回true
     */
    private boolean error;
    /**
     * 返回错误状态码。默认成功0， 失败-1
     */
    private Integer code;
    /**
     * 消息内容
     */
    private String message;
    /**
     * 返回的对象
     */
    private Object data;
    /**
     * 业务自己定义的返回信息
     */
//    private Map<String, Object> businessData;


    private ResponseData() {
    }

    public static ResponseData success() {
        return success(0, "success", null, null);
    }

    public static ResponseData success(String message) {
        return success(0, message, null, null);
    }

    public static ResponseData success(Object data) {
        return success(0, "success", data, null);
    }

    public static ResponseData success(Map<String, Object> businessStatus) {
        return success(0, "success", null, businessStatus);
    }

    public static ResponseData success(String message, Object data) {
        return success(0, message, data, null);
    }

    public static ResponseData success(String message, Object data, Map<String, Object> businessStatus) {
        return success(0, message, data, businessStatus);
    }

    public static ResponseData failed() {
        return failed(-1, "failed", null, null);
    }

    public static ResponseData failed(String message) {
        return failed(-1, message, null, null);
    }

    public static ResponseData failed(Object data) {
        return failed(-1, "failed", data, null);
    }

    public static ResponseData failed(Map<String, Object> businessStatus) {
        return failed(-1, "failed", null, businessStatus);
    }

    public static ResponseData failed(String message, Object data) {
        return failed(-1, message, data, null);
    }

    public static ResponseData failed(String message, Object data, Map<String, Object> businessStatus) {
        return failed(-1, message, data, businessStatus);
    }

    public static ResponseData success(Integer code, String message, Object data, Map<String, Object> businessStatus) {
        ResponseData responseData = new ResponseData();
        responseData.setError(false);
        responseData.setCode(code);
        responseData.setMessage(message);
        responseData.setData(data);
//        responseData.setBusinessData(businessStatus);
        return responseData;
    }

    public static ResponseData failed(Integer code, String message, Object data, Map<String, Object> businessStatus) {
        ResponseData responseData = new ResponseData();
        responseData.setError(true);
        responseData.setCode(code);
        responseData.setMessage(message);
        responseData.setData(data);
//        responseData.setBusinessData(businessStatus);
        return responseData;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

//    public void setBusinessData(Map<String, Object> businessData) {
//        this.businessData = businessData;
//    }

    public boolean isError() {
        return error;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

//    public Map<String, Object> getBusinessData() {
//        return businessData;
//    }
}
