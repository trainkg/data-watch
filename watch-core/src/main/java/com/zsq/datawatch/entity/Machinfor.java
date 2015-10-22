package com.zsq.datawatch.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 机器信息
 * 
 * @author peculiar.1@163.com
 * @version $ID: Machinfor.java, V1.0.0 2015年10月1日 下午1:35:10 $
 */
public class Machinfor {
	private Integer id;

	private Machine machine;
	/**
	 * 机器主版本号
	 */
	private String machnum;

	/**
	 * 副版本号
	 */
	private String minorVer;
	
	/**
	 * 机器模式/设备类型
	 */
	private String machmode;

	/**
	 * 消息类型
	 */
	private String msgType;
	
	/**
	 * 消息长度
	 */
	private String contentLength;

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
	 * COM1通讯状态ON/OFF
	 */
	private Integer com1statue;

	/**
	 * COM2通讯状态ON/OFF
	 */
	private Integer com2statue;
	
	/**
	 * AUST伺服器通讯状态ON/OFF
	 */
	private Integer auststatue;

	/**
	 * 马达状态ON/OFF
	 */
	private String machmotorstatue;

	/**
	 * 电热状态ON/OFF
	 */
	private String machheartstatue;
	    
	/**
	 * 料温一段选用状态
	 */
	private String temper1statue;

	/**
	 * 料温二段选用状态
	 */
	private String temper2statue;

	/**
	 * 料温三段选用状态
	 */
	private String temper3statue;

	/**
	 * 料温四段选用状态
	 */
	private String temper4statue;

	/**
	 * 料温五段选用状态
	 */
	private String temper5statue;

	/**
	 * 料温六段选用状态
	 */
	private String temper6statue;

	/**
	 * 料温七段选用状态
	 */
	private String temper7statue;

	/**
	 * 料温八段选用状态
	 */
	private String temper8statue;

	/**
	 * 料温九段选用状态
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
	 * 第一根电子尺值（射出电子尺）
	 */
	private Integer ruler1value;

	/**
	 * 第二根电子尺值（注模电子尺）
	 */
	private Integer ruler2value;

	/**
	 * 第三根电子尺值（吹模电子尺）
	 */
	private Integer ruler3value;

	/**
	 * 第四根电子尺值（脱模电子尺）
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
	/**
	 * 料温状态1
	 */
	private Integer oper1value;
	/**
	 * 料温状态2
	 */
	private Integer oper2value;
	/**
	 * 料温状态3
	 */
	private Integer oper3value;
	/**
	 * 料温状态4
	 */
	private Integer oper4value;
	/**
	 * 料温状态5
	 */
	private Integer oper5value;
	/**
	 * 料温状态6
	 */
	private Integer oper6value;
	/**
	 * 料温状态7
	 */
	private Integer oper7value;
	/**
	 * 料温状态8
	 */
	private Integer oper8value;
	/**
	 * 料温状态8
	 */
	private Integer oper9value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 机台编号
	 */
	public String getMachnum() {
		return machnum;
	}

	public void setMachnum(String machnum) {
		this.machnum = machnum;
	}

	/**
	 * 机器MAC地址
	 */
	public String getMachmac() {
		return machmac;
	}

	public void setMachmac(String machmac) {
		this.machmac = machmac;
	}

	/**
	 * 机器IP
	 */
	public String getMachip() {
		return machip;
	}

	public void setMachip(String machip) {
		this.machip = machip;
	}

	/**
	 * 机器通讯端口
	 */
	public Integer getMachport() {
		return machport;
	}

	public void setMachport(Integer machport) {
		this.machport = machport;
	}

	/**
	 * 机器状态（手动、半自动、时间自动）
	 */
	public String getMachmode() {
		return machmode;
	}

	public void setMachmode(String machmode) {
		this.machmode = machmode;
	}

	/**
	 * 机器马达状态（ON/OFF）
	 */
	public String getMachmotorstatue() {
		return machmotorstatue;
	}

	public void setMachmotorstatue(String machmotorstatue) {
		this.machmotorstatue = machmotorstatue;
	}

	/**
	 * 机器电热状态（ON/OFF）
	 */
	public String getMachheartstatue() {
		return machheartstatue;
	}

	public void setMachheartstatue(String machheartstatue) {
		this.machheartstatue = machheartstatue;
	}

	/**
	 * 机器COM1通讯状态（RS232 ON/OFF）
	 */
	public Integer getCom1statue() {
		return com1statue;
	}

	public void setCom1statue(Integer com1statue) {
		this.com1statue = com1statue;
	}

	/**
	 * 机器COM2通讯状态（RS232 ON/OFF）
	 */
	public Integer getCom2statue() {
		return com2statue;
	}

	public void setCom2statue(Integer com2statue) {
		this.com2statue = com2statue;
	}

	/**
	 * 机器AUST伺服驱动器通讯状态（ON/OFF）
	 */
	public Integer getAuststatue() {
		return auststatue;
	}

	public void setAuststatue(Integer auststatue) {
		this.auststatue = auststatue;
	}

	/**
	 * 机器电热1状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper1statue() {
		return temper1statue;
	}

	public void setTemper1statue(String temper1statue) {
		this.temper1statue = temper1statue;
	}

	/**
	 * 机器电热2状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper2statue() {
		return temper2statue;
	}

	public void setTemper2statue(String temper2statue) {
		this.temper2statue = temper2statue;
	}

	/**
	 * 机器电热3状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper3statue() {
		return temper3statue;
	}

	public void setTemper3statue(String temper3statue) {
		this.temper3statue = temper3statue;
	}

	/**
	 * 机器电热4状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper4statue() {
		return temper4statue;
	}

	public void setTemper4statue(String temper4statue) {
		this.temper4statue = temper4statue;
	}

	/**
	 * 机器电热5状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper5statue() {
		return temper5statue;
	}

	public void setTemper5statue(String temper5statue) {
		this.temper5statue = temper5statue;
	}

	/**
	 * 机器电热6状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper6statue() {
		return temper6statue;
	}

	public void setTemper6statue(String temper6statue) {
		this.temper6statue = temper6statue;
	}

	/**
	 * 机器电热7状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper7statue() {
		return temper7statue;
	}

	public void setTemper7statue(String temper7statue) {
		this.temper7statue = temper7statue;
	}

	/**
	 * 机器电热8状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper8statue() {
		return temper8statue;
	}

	public void setTemper8statue(String temper8statue) {
		this.temper8statue = temper8statue;
	}

	/**
	 * 机器电热9状态（温度实际值为777、888、999、970、990、988，或者温度状态为2，显示红色；温度状态为1、3，显示黄色；
	 * 其余情况显示绿色）
	 */
	public String getTemper9statue() {
		return temper9statue;
	}

	public void setTemper9statue(String temper9statue) {
		this.temper9statue = temper9statue;
	}

	/**
	 * 机器电热1温度值
	 */
	public Integer getTemper1value() {
		return temper1value;
	}

	public void setTemper1value(Integer temper1value) {
		this.temper1value = temper1value;
	}

	/**
	 * 机器电热2温度值
	 */
	public Integer getTemper2value() {
		return temper2value;
	}

	public void setTemper2value(Integer temper2value) {
		this.temper2value = temper2value;
	}

	/**
	 * 机器电热3温度值
	 */
	public Integer getTemper3value() {
		return temper3value;
	}

	public void setTemper3value(Integer temper3value) {
		this.temper3value = temper3value;
	}

	/**
	 * 机器电热4温度值
	 */
	public Integer getTemper4value() {
		return temper4value;
	}

	public void setTemper4value(Integer temper4value) {
		this.temper4value = temper4value;
	}

	/**
	 * 机器电热5温度值
	 */
	public Integer getTemper5value() {
		return temper5value;
	}

	public void setTemper5value(Integer temper5value) {
		this.temper5value = temper5value;
	}

	/**
	 * 机器电热6温度值
	 */
	public Integer getTemper6value() {
		return temper6value;
	}

	public void setTemper6value(Integer temper6value) {
		this.temper6value = temper6value;
	}

	/**
	 * 机器电热7温度值
	 */
	public Integer getTemper7value() {
		return temper7value;
	}

	public void setTemper7value(Integer temper7value) {
		this.temper7value = temper7value;
	}

	/**
	 * 机器电热8温度值
	 */
	public Integer getTemper8value() {
		return temper8value;
	}

	public void setTemper8value(Integer temper8value) {
		this.temper8value = temper8value;
	}

	/**
	 * 机器电热9温度值
	 */
	public Integer getTemper9value() {
		return temper9value;
	}

	public void setTemper9value(Integer temper9value) {
		this.temper9value = temper9value;
	}

	/**
	 * 机器油温温度值
	 */
	public Integer getOiltempervalue() {
		return oiltempervalue;
	}

	public void setOiltempervalue(Integer oiltempervalue) {
		this.oiltempervalue = oiltempervalue;
	}

	/**
	 * 机器电子尺1数值
	 */
	public Integer getRuler1value() {
		return ruler1value;
	}

	public void setRuler1value(Integer ruler1value) {
		this.ruler1value = ruler1value;
	}

	/**
	 * 机器电子尺2数值
	 */
	public Integer getRuler2value() {
		return ruler2value;
	}

	public void setRuler2value(Integer ruler2value) {
		this.ruler2value = ruler2value;
	}

	/**
	 * 机器电子尺3数值
	 */
	public Integer getRuler3value() {
		return ruler3value;
	}

	public void setRuler3value(Integer ruler3value) {
		this.ruler3value = ruler3value;
	}

	/**
	 * 机器电子尺4数值
	 */
	public Integer getRuler4value() {
		return ruler4value;
	}

	public void setRuler4value(Integer ruler4value) {
		this.ruler4value = ruler4value;
	}

	/**
	 * 机器电子尺5数值
	 */
	public Integer getRuler5value() {
		return ruler5value;
	}

	public void setRuler5value(Integer ruler5value) {
		this.ruler5value = ruler5value;
	}

	/**
	 * 机器电子尺6数值
	 */
	public Integer getRuler6value() {
		return ruler6value;
	}

	public void setRuler6value(Integer ruler6value) {
		this.ruler6value = ruler6value;
	}

	/**
	 * 机器电子尺7数值
	 */
	public Integer getRuler7value() {
		return ruler7value;
	}

	public void setRuler7value(Integer ruler7value) {
		this.ruler7value = ruler7value;
	}

	/**
	 * 机器电子尺8数值
	 */
	public Integer getRuler8value() {
		return ruler8value;
	}

	public void setRuler8value(Integer ruler8value) {
		this.ruler8value = ruler8value;
	}

	/**
	 * 机器状态1数值
	 */
	public Integer getOper1value() {
		return oper1value;
	}

	public void setOper1value(Integer oper1value) {
		this.oper1value = oper1value;
	}

	/**
	 * 机器状态2数值
	 */
	public Integer getOper2value() {
		return oper2value;
	}

	public void setOper2value(Integer oper2value) {
		this.oper2value = oper2value;
	}

	/**
	 * 机器状态3数值
	 */
	public Integer getOper3value() {
		return oper3value;
	}

	public void setOper3value(Integer oper3value) {
		this.oper3value = oper3value;
	}

	/**
	 * 机器状态4数值
	 */
	public Integer getOper4value() {
		return oper4value;
	}

	public void setOper4value(Integer oper4value) {
		this.oper4value = oper4value;
	}

	/**
	 * 机器状态5数值
	 */
	public Integer getOper5value() {
		return oper5value;
	}

	public void setOper5value(Integer oper5value) {
		this.oper5value = oper5value;
	}

	/**
	 * 机器状态6数值
	 */
	public Integer getOper6value() {
		return oper6value;
	}

	public void setOper6value(Integer oper6value) {
		this.oper6value = oper6value;
	}

	/**
	 * 机器状态7数值
	 */
	public Integer getOper7value() {
		return oper7value;
	}

	public void setOper7value(Integer oper7value) {
		this.oper7value = oper7value;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public String getMinorVer() {
		return minorVer;
	}

	public void setMinorVer(String minorVer) {
		this.minorVer = minorVer;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
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

	@Override
	public String toString() {
		return getMachip() + "-" + getMachmac();
	}
}