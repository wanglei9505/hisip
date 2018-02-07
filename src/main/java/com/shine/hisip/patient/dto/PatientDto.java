package com.shine.hisip.patient.dto;

import com.shine.hisip.common.domain.PatientInfo;

/**
 * @Author: a
 * @DATE: Created in 2018/1/22
 **/
public class PatientDto extends PatientInfo{
   // 标签名称
    private String tagName;
    // 就诊卡名称
//    private String cardName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

//    public String getCardName() {
//        return cardName;
//    }

//    public void setCardName(String cardName) {
//        this.cardName = cardName;
//    }

}
