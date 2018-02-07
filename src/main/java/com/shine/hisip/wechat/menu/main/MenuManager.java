package com.shine.hisip.wechat.menu.main;

import com.alibaba.fastjson.JSONObject;
import com.shine.hisip.common.Constants;
import com.shine.hisip.common.domain.Token;
import com.shine.hisip.wechat.menu.domain.Button;
import com.shine.hisip.wechat.menu.domain.CommonButton;
import com.shine.hisip.wechat.menu.domain.ComplexButton;
import com.shine.hisip.wechat.menu.domain.Menu;
import com.shine.hisip.utils.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: a
 * @DATE: Created in 2018/2/6
 * 菜单管理器类
 **/
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);


    public static void main(String[] args) {
        // 调用接口获取access_token
//        TokenManager tokenManager=new TokenManager();

        Token token= TokenManager.getToken(Constants.APPID,Constants.APPSECRET);
        System.out.println(token.getAccessToken());
        System.out.println(JSONObject.toJSONString(getMenu()));
        /*if (null != at) {
            // 调用接口创建菜单
            int result = WeiHttpsUtils.createMenu(getMenu(), at.getAccessToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }*/
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("预约挂号");
        btn11.setType("view");
        btn11.setKey("11");
        btn11.setUrl("https://www.baidu.com");

        CommonButton btn12 = new CommonButton();
        btn12.setName("专家门诊");
        btn12.setType("view");
        btn12.setKey("12");
        btn12.setUrl("https://www.baidu.com");

        CommonButton btn13 = new CommonButton();
        btn13.setName("对症预约");
        btn13.setType("view");
        btn13.setKey("13");
        btn13.setUrl("https://www.baidu.com");


        CommonButton btn21 = new CommonButton();
        btn21.setName("新闻公告");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName("科室介绍");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn23 = new CommonButton();
        btn23.setName("人才招聘");
        btn23.setType("click");
        btn23.setKey("23");


        /*CommonButton btn25 = new CommonButton();
        btn25.setName("聊天唠嗑");
        btn25.setType("click");
        btn25.setKey("25");

        CommonButton btn31 = new CommonButton();
        btn31.setName("Q友圈");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("电影排行榜");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("幽默笑话");
        btn33.setType("click");
        btn33.setKey("33");*/


        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("就医服务");
        //一级下有4个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13 });


        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("医院信息");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23 });


        CommonButton mainBtn3 = new CommonButton();
        mainBtn3.setName("个人中心");
        mainBtn3.setType("click");
        mainBtn3.setKey("33");
//        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });


        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}
