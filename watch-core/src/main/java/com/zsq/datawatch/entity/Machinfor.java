package com.zsq.datawatch.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Machinfor {
    private Integer id;

    private String machnum;

    private String machmac;

    private String machip;

    private Integer machport;

    private String machmode;

    private String machmotorstatue;

    private String machheartstatue;

    private Integer com1statue;

    private Integer com2statue;

    private Integer auststatue;

    private String temper1statue;

    private String temper2statue;

    private String temper3statue;

    private String temper4statue;

    private String temper5statue;

    private String temper6statue;

    private String temper7statue;

    private String temper8statue;

    private String temper9statue;

    private Integer temper1value;

    private Integer temper2value;

    private Integer temper3value;

    private Integer temper4value;

    private Integer temper5value;

    private Integer temper6value;

    private Integer temper7value;

    private Integer temper8value;

    private Integer temper9value;

    private Integer oiltempervalue;

    private Integer ruler1value;

    private Integer ruler2value;

    private Integer ruler3value;

    private Integer ruler4value;

    private Integer ruler5value;

    private Integer ruler6value;

    private Integer ruler7value;

    private Integer ruler8value;

    private Integer oper1value;

    private Integer oper2value;

    private Integer oper3value;

    private Integer oper4value;

    private Integer oper5value;

    private Integer oper6value;

    private Integer oper7value;

    private String minorver;

    private String msgtype;

    private String contentlength;

    private Integer oper8value;

    private Integer oper9value;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    private Date reciverdate;

    private Integer werrdata1;

    private Integer werrdata2;

    private Integer werrdata3;

    private Integer werrdata4;

    private Integer werrdata5;

    private Integer werrdata6;

    private Integer werrdata7;

    private Integer werrdata8;

    private Integer werrdata9;

    private Integer werrdata10;

    private Integer werrdata11;

    private Integer werrdata12;

    private Integer werrdata13;

    private Integer werrdata14;

    private Integer werrdata15;

    private Integer werrdata16;

    private Integer wopermode;

    private Integer woperstep1;

    private Integer woperstep2;

    private Integer wopersubstep1;

    private Integer wopersubstep2;

    private Integer woperstep3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachnum() {
        return machnum;
    }

    public void setMachnum(String machnum) {
        this.machnum = machnum;
    }

    public String getMachmac() {
        return machmac;
    }

    public void setMachmac(String machmac) {
        this.machmac = machmac;
    }

    public String getMachip() {
        return machip;
    }

    public void setMachip(String machip) {
        this.machip = machip;
    }

    public Integer getMachport() {
        return machport;
    }

    public void setMachport(Integer machport) {
        this.machport = machport;
    }

    public String getMachmode() {
        return machmode;
    }

    public void setMachmode(String machmode) {
        this.machmode = machmode;
    }

    public String getMachmotorstatue() {
        return machmotorstatue;
    }

    public void setMachmotorstatue(String machmotorstatue) {
        this.machmotorstatue = machmotorstatue;
    }

    public String getMachheartstatue() {
        return machheartstatue;
    }

    public void setMachheartstatue(String machheartstatue) {
        this.machheartstatue = machheartstatue;
    }

    public Integer getCom1statue() {
        return com1statue;
    }

    public void setCom1statue(Integer com1statue) {
        this.com1statue = com1statue;
    }

    public Integer getCom2statue() {
        return com2statue;
    }

    public void setCom2statue(Integer com2statue) {
        this.com2statue = com2statue;
    }

    public Integer getAuststatue() {
        return auststatue;
    }

    public void setAuststatue(Integer auststatue) {
        this.auststatue = auststatue;
    }

    public String getTemper1statue() {
        return temper1statue;
    }

    public void setTemper1statue(String temper1statue) {
        this.temper1statue = temper1statue;
    }

    public String getTemper2statue() {
        return temper2statue;
    }

    public void setTemper2statue(String temper2statue) {
        this.temper2statue = temper2statue;
    }

    public String getTemper3statue() {
        return temper3statue;
    }

    public void setTemper3statue(String temper3statue) {
        this.temper3statue = temper3statue;
    }

    public String getTemper4statue() {
        return temper4statue;
    }

    public void setTemper4statue(String temper4statue) {
        this.temper4statue = temper4statue;
    }

    public String getTemper5statue() {
        return temper5statue;
    }

    public void setTemper5statue(String temper5statue) {
        this.temper5statue = temper5statue;
    }

    public String getTemper6statue() {
        return temper6statue;
    }

    public void setTemper6statue(String temper6statue) {
        this.temper6statue = temper6statue;
    }

    public String getTemper7statue() {
        return temper7statue;
    }

    public void setTemper7statue(String temper7statue) {
        this.temper7statue = temper7statue;
    }

    public String getTemper8statue() {
        return temper8statue;
    }

    public void setTemper8statue(String temper8statue) {
        this.temper8statue = temper8statue;
    }

    public String getTemper9statue() {
        return temper9statue;
    }

    public void setTemper9statue(String temper9statue) {
        this.temper9statue = temper9statue;
    }

    public Integer getTemper1value() {
        return temper1value;
    }

    public void setTemper1value(Integer temper1value) {
        this.temper1value = temper1value;
    }

    public Integer getTemper2value() {
        return temper2value;
    }

    public void setTemper2value(Integer temper2value) {
        this.temper2value = temper2value;
    }

    public Integer getTemper3value() {
        return temper3value;
    }

    public void setTemper3value(Integer temper3value) {
        this.temper3value = temper3value;
    }

    public Integer getTemper4value() {
        return temper4value;
    }

    public void setTemper4value(Integer temper4value) {
        this.temper4value = temper4value;
    }

    public Integer getTemper5value() {
        return temper5value;
    }

    public void setTemper5value(Integer temper5value) {
        this.temper5value = temper5value;
    }

    public Integer getTemper6value() {
        return temper6value;
    }

    public void setTemper6value(Integer temper6value) {
        this.temper6value = temper6value;
    }

    public Integer getTemper7value() {
        return temper7value;
    }

    public void setTemper7value(Integer temper7value) {
        this.temper7value = temper7value;
    }

    public Integer getTemper8value() {
        return temper8value;
    }

    public void setTemper8value(Integer temper8value) {
        this.temper8value = temper8value;
    }

    public Integer getTemper9value() {
        return temper9value;
    }

    public void setTemper9value(Integer temper9value) {
        this.temper9value = temper9value;
    }

    public Integer getOiltempervalue() {
        return oiltempervalue;
    }

    public void setOiltempervalue(Integer oiltempervalue) {
        this.oiltempervalue = oiltempervalue;
    }

    public Integer getRuler1value() {
        return ruler1value;
    }

    public void setRuler1value(Integer ruler1value) {
        this.ruler1value = ruler1value;
    }

    public Integer getRuler2value() {
        return ruler2value;
    }

    public void setRuler2value(Integer ruler2value) {
        this.ruler2value = ruler2value;
    }

    public Integer getRuler3value() {
        return ruler3value;
    }

    public void setRuler3value(Integer ruler3value) {
        this.ruler3value = ruler3value;
    }

    public Integer getRuler4value() {
        return ruler4value;
    }

    public void setRuler4value(Integer ruler4value) {
        this.ruler4value = ruler4value;
    }

    public Integer getRuler5value() {
        return ruler5value;
    }

    public void setRuler5value(Integer ruler5value) {
        this.ruler5value = ruler5value;
    }

    public Integer getRuler6value() {
        return ruler6value;
    }

    public void setRuler6value(Integer ruler6value) {
        this.ruler6value = ruler6value;
    }

    public Integer getRuler7value() {
        return ruler7value;
    }

    public void setRuler7value(Integer ruler7value) {
        this.ruler7value = ruler7value;
    }

    public Integer getRuler8value() {
        return ruler8value;
    }

    public void setRuler8value(Integer ruler8value) {
        this.ruler8value = ruler8value;
    }

    public Integer getOper1value() {
        return oper1value;
    }

    public void setOper1value(Integer oper1value) {
        this.oper1value = oper1value;
    }

    public Integer getOper2value() {
        return oper2value;
    }

    public void setOper2value(Integer oper2value) {
        this.oper2value = oper2value;
    }

    public Integer getOper3value() {
        return oper3value;
    }

    public void setOper3value(Integer oper3value) {
        this.oper3value = oper3value;
    }

    public Integer getOper4value() {
        return oper4value;
    }

    public void setOper4value(Integer oper4value) {
        this.oper4value = oper4value;
    }

    public Integer getOper5value() {
        return oper5value;
    }

    public void setOper5value(Integer oper5value) {
        this.oper5value = oper5value;
    }

    public Integer getOper6value() {
        return oper6value;
    }

    public void setOper6value(Integer oper6value) {
        this.oper6value = oper6value;
    }

    public Integer getOper7value() {
        return oper7value;
    }

    public void setOper7value(Integer oper7value) {
        this.oper7value = oper7value;
    }

    public String getMinorver() {
        return minorver;
    }

    public void setMinorver(String minorver) {
        this.minorver = minorver;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getContentlength() {
        return contentlength;
    }

    public void setContentlength(String contentlength) {
        this.contentlength = contentlength;
    }

    public Integer getOper8value() {
        return oper8value;
    }

    public void setOper8value(Integer oper8value) {
        this.oper8value = oper8value;
    }

    public Integer getOper9value() {
        return oper9value;
    }

    public void setOper9value(Integer oper9value) {
        this.oper9value = oper9value;
    }

    public Date getReciverdate() {
        return reciverdate;
    }

    public void setReciverdate(Date reciverdate) {
        this.reciverdate = reciverdate;
    }

    public Integer getWerrdata1() {
        return werrdata1;
    }

    public void setWerrdata1(Integer werrdata1) {
        this.werrdata1 = werrdata1;
    }

    public Integer getWerrdata2() {
        return werrdata2;
    }

    public void setWerrdata2(Integer werrdata2) {
        this.werrdata2 = werrdata2;
    }

    public Integer getWerrdata3() {
        return werrdata3;
    }

    public void setWerrdata3(Integer werrdata3) {
        this.werrdata3 = werrdata3;
    }

    public Integer getWerrdata4() {
        return werrdata4;
    }

    public void setWerrdata4(Integer werrdata4) {
        this.werrdata4 = werrdata4;
    }

    public Integer getWerrdata5() {
        return werrdata5;
    }

    public void setWerrdata5(Integer werrdata5) {
        this.werrdata5 = werrdata5;
    }

    public Integer getWerrdata6() {
        return werrdata6;
    }

    public void setWerrdata6(Integer werrdata6) {
        this.werrdata6 = werrdata6;
    }

    public Integer getWerrdata7() {
        return werrdata7;
    }

    public void setWerrdata7(Integer werrdata7) {
        this.werrdata7 = werrdata7;
    }

    public Integer getWerrdata8() {
        return werrdata8;
    }

    public void setWerrdata8(Integer werrdata8) {
        this.werrdata8 = werrdata8;
    }

    public Integer getWerrdata9() {
        return werrdata9;
    }

    public void setWerrdata9(Integer werrdata9) {
        this.werrdata9 = werrdata9;
    }

    public Integer getWerrdata10() {
        return werrdata10;
    }

    public void setWerrdata10(Integer werrdata10) {
        this.werrdata10 = werrdata10;
    }

    public Integer getWerrdata11() {
        return werrdata11;
    }

    public void setWerrdata11(Integer werrdata11) {
        this.werrdata11 = werrdata11;
    }

    public Integer getWerrdata12() {
        return werrdata12;
    }

    public void setWerrdata12(Integer werrdata12) {
        this.werrdata12 = werrdata12;
    }

    public Integer getWerrdata13() {
        return werrdata13;
    }

    public void setWerrdata13(Integer werrdata13) {
        this.werrdata13 = werrdata13;
    }

    public Integer getWerrdata14() {
        return werrdata14;
    }

    public void setWerrdata14(Integer werrdata14) {
        this.werrdata14 = werrdata14;
    }

    public Integer getWerrdata15() {
        return werrdata15;
    }

    public void setWerrdata15(Integer werrdata15) {
        this.werrdata15 = werrdata15;
    }

    public Integer getWerrdata16() {
        return werrdata16;
    }

    public void setWerrdata16(Integer werrdata16) {
        this.werrdata16 = werrdata16;
    }

    public Integer getWopermode() {
        return wopermode;
    }

    public void setWopermode(Integer wopermode) {
        this.wopermode = wopermode;
    }

    public Integer getWoperstep1() {
        return woperstep1;
    }

    public void setWoperstep1(Integer woperstep1) {
        this.woperstep1 = woperstep1;
    }

    public Integer getWoperstep2() {
        return woperstep2;
    }

    public void setWoperstep2(Integer woperstep2) {
        this.woperstep2 = woperstep2;
    }

    public Integer getWopersubstep1() {
        return wopersubstep1;
    }

    public void setWopersubstep1(Integer wopersubstep1) {
        this.wopersubstep1 = wopersubstep1;
    }

    public Integer getWopersubstep2() {
        return wopersubstep2;
    }

    public void setWopersubstep2(Integer wopersubstep2) {
        this.wopersubstep2 = wopersubstep2;
    }

    public Integer getWoperstep3() {
        return woperstep3;
    }

    public void setWoperstep3(Integer woperstep3) {
        this.woperstep3 = woperstep3;
    }
}