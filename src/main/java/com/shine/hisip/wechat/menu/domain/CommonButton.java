package com.shine.hisip.wechat.menu.domain;

/**
 * @Author: a
 * @DATE: Created in 2018/2/6
 * 描述: 子菜单项 :没有子菜单的菜单项，有可能是二级菜单项，也有可能是不含二级菜单的一级菜单。
 **/
public class CommonButton extends Button {
    private String type;
    private String key;
    private String url;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
