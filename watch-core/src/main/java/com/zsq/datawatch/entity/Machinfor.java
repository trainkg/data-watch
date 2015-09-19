package com.zsq.datawatch.entity;

public class Machinfor {
    private Integer id;

    /**
     * 机器版本号
     */
    private String machnum;

    /**
     * 机器MAC地址
     */
    private String machmac;

    /**
     * 机器ID
     */
    private String machip;

    /**
     * 机器端口
     */
    private Integer machport;

    /**
     * 机器模式
     */
    private String machmode;

    /**
     * 马达状态ON/OFF
     */
    private String machmotorstatue;
    
    private String machheartstatue;
    
    /**
     * COM1通讯状态ON/OFF
     */
    private Integer com1statue;

    /**
     * COM2通讯状态ON/OFF
     */
    private Integer com2statue;

    /**
     * AUST通讯状态ON/OFF
     */
    private Integer auststatue;
    
    /**
     * 料温一段状态
     */
    private String temper1statue;
    
    /**
     * 料温二段状态
     */
    private String temper2statue;
    
    /**
     * 料温三段状态
     */
    private String temper3statue;
    
    /**
     * 料温四段状态
     */
    private String temper4statue;
    
    /**
     * 料温五段状态
     */
    private String temper5statue;
    
    /**
     * 料温六段状态
     */
    private String temper6statue;
    
    /**
     * 料温七段状态
     */
    private String temper7statue;
    
    /**
     * 料温八段状态
     */
    private String temper8statue;
    
    /**
     * 料温九段状态
     */
    private String temper9statue;
    
    /**
     * 料温一段
     */
    private Integer temper1value;
    
    /**
     * 料温二段
     */
    private Integer temper2value;
    
    /**
     * 料温三段
     */
    private Integer temper3value;

    /**
     * 料温四段
     */
    private Integer temper4value;

    /**
     * 料温五段
     */
    private Integer temper5value;

    /**
     * 料温六段
     */
    private Integer temper6value;

    /**
     * 料温七段
     */
    private Integer temper7value;
    
    /**
     * 料温八段
     */
    private Integer temper8value;
    
    /**
     * 料温九段
     */
    private Integer temper9value;

    /**
     * 油温
     */
    private Integer oiltempervalue;
    
    /**
     * 第一根电子尺值
     */
    private Integer ruler1value;

    /**
     * 第二根电子尺值
     */
    private Integer ruler2value;
    
    /**
     * 第三根电子尺值
     */
    private Integer ruler3value;
    
    /**
     * 第四根电子尺值
     */
    private Integer ruler4value;

    /**
     * 第五根电子尺值
     */
    private Integer ruler5value;

    /**
     * 第六根电子尺值
     */
    private Integer ruler6value;
    
    /**
     * 第七根电子尺值
     */
    private Integer ruler7value;
    
    /**
     * 第八根电子尺值
     */
    private Integer ruler8value;

    private Integer oper1value;

    private Integer oper2value;

    private Integer oper3value;

    private Integer oper4value;

    private Integer oper5value;

    private Integer oper6value;

    private Integer oper7value;

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
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return getMachip()+"-"+getMachmac();
    }
}