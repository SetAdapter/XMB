package com.fy.baselibrary.retrofit;

import java.io.Serializable;

/**
 * 网络请求 返回数据 格式化对象
 * Created by fangs on 2017/11/6.
 */
public class BeanModule<T> implements Serializable{

    /**
     * msg : 操作成功！
     * code : 0
     * rows : {}
     */

    private String msg = "";
    private int code;
    private T rows;

    /**
     * code 如果 不等于零 则认为错误，此时errorMsg会包含错误信息
     * 反之 则成功
     * @return
     */
    public boolean isSuccess(){
        return code == 0;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "BeanModule{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", rows=" + rows +
                '}';
    }
}
