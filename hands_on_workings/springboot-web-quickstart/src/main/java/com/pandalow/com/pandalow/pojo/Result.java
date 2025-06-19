package com.pandalow.com.pandalow.pojo;

public class Result {
    private Integer code;
    private Object data;
    private String msg;

    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Result success(Object data) {
        return new Result(1, data, "success");
    }

    public static Result error(Object data) {
        return new Result(1, null, "success");
    }

    public static Result success() {
        return new Result(1, null, "success");
    }

    public static Result error(String msg) {
        return new Result(0, null, msg);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
