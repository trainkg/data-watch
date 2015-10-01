package com.zsq.datawatch.entity;

/**
 * 机器信息
 * 
 * @author peculiar.1@163.com
 * @version $ID: Machine.java, V1.0.0 2015年10月1日 下午1:48:11 $
 */
public class Machine {
    private Integer id;

    private String machnum;

    private String machmac;

    private String machip;

    private Integer machport;

    private String machmode;

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
}