package com.shine.hisip.common;

import com.shine.hisip.common.response.ResponseCom;
import com.shine.hisip.common.response.enumeration.ResponseStatus;
import org.apache.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * Created by Hyun on 2017/6/29.
 *
 */
public class BaseController {

    Logger logger = Logger.getLogger(BaseController.class);

    /**
     * 大异常总类
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseCom exception(Exception e) {
        logger.debug(e,e);
        ResponseCom responseCom = ResponseCom.newInstance();
        responseCom.setResultCode(ResponseStatus.OPRERATE_FAILED.getCode());
        responseCom.setResultInfo(e.getMessage());
        return responseCom;
    }

    /**
     * 日期转换
     * @param binder
     */
    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                setValue(new Date(Long.valueOf(value)));
            }
        });

    }*/
}
