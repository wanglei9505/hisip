package com.shine.hisip.common.response;

import com.google.common.collect.Lists;
import com.shine.hisip.common.response.enumeration.ResponseStatus;

import java.util.List;

/**
 * Created by Hyun on 2017.3.10.
 * 公共返回信息
 */
public class ResponseCom<T> {

    public static <T> ResponseCom<T> newInstance() {
        return new ResponseCom<>();
    }
    
    private String resultCode = ResponseStatus.SUCCESS.getCode();//返回码
    private String resultInfo = ResponseStatus.SUCCESS.getNote();//如果出错，返回错误信息
    private T obj;//明确返回单条记录时有值
    private List<T> list = Lists.newArrayList();//返回多个对象不需要分页时有值
    private Page<T> page = new Page<T>();//获取分页数据时有值

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list.addAll(list);
    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }
}
