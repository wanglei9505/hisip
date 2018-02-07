package com.shine.hisip.wechat.menu.domain;

/**
 * @Author: a
 * @DATE: Created in 2018/2/6
 * 菜单项的基类
 **/
public class Button {
    //所有一级菜单、二级菜单都共有一个相同的属性，那就是name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
