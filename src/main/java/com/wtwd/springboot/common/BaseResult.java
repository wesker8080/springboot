package com.wtwd.springboot.common;

/**
 * @author MR.ZHANG
 * @create 2018-07-24 15:54
 */
public class BaseResult {
    // 状态码：1成功，其他为失败
    public int resultCode;

    // 成功为success，其他为失败原因
    public String message;

    // 数据结果集
    public Object data;

    public BaseResult(int resultCode, String message, Object data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }


    public static BaseResult build(Integer resultCode, String message, Object data) {
        return new BaseResult(resultCode, message, data);
    }

    public static BaseResult ok(Object data) {
        return new BaseResult(data);
    }

    public static BaseResult ok() {
        return new BaseResult(null);
    }

    public BaseResult() {

    }

    public static BaseResult build(Integer resultCode, String message) {
        return new BaseResult(resultCode, message, null);
    }



    public BaseResult(Object data) {
        this.resultCode = 1;
        this.message = "OK";
        this.data = data;
    }

    public int getresultCode() {
        return resultCode;
    }

    public void setresultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
