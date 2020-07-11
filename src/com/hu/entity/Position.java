package com.hu.entity;

import java.io.Serializable;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 8:10
 * @decription 岗位
 **/
public class Position implements Serializable {
    private int posId;
    private String posName;
    private String desc;

    public Position() {
        super();
    }

    public Position(int posId, String posName) {
        super();
        this.posId = posId;
        this.posName = posName;
    }
    public Position(int posId, String posName, String desc) {
        super();
        this.posId = posId;
        this.posName = posName;
        this.desc = desc;
    }
    public int getPosId() {
        return posId;
    }
    public void setPosId(int posId) {
        this.posId = posId;
    }
    public String getPosName() {
        return posName;
    }
    public void setPosName(String posName) {
        this.posName = posName;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        return "Position [posId=" + posId + ", posName=" + posName + ", desc="
                + desc + "]";
    }
}
