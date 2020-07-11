package com.hu.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-13 7:54
 * @decription 报销图片类
 **/
public class ExpImage implements Serializable {

    public int imgId;
    /**
     * 报销单号的ID
     */
    public int expId;
    public String realName;
    public String fileName;
    public String fileType;

    public ExpImage() {
    }

    public ExpImage(int imgId, int expId, String realName, String fileName, String fileType) {
        this.imgId = imgId;
        this.expId = expId;
        this.realName = realName;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public ExpImage(int expId, String realName, String fileName, String fileType) {
        this.expId = expId;
        this.realName = realName;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public ExpImage(String realName, String fileName, String fileType) {

        this.realName = realName;
        this.fileName = fileName;
        this.fileType = fileType;
    }


    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "ExpImage{" +
                "imgId=" + imgId +
                ", expId=" + expId +
                ", realName='" + realName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        //自反性
        if (this == o) {
            return true;
        }
        //任何对象不等于null，比较是否为同一类型
        if (!(o instanceof ExpImage)) {
            return false;
        }
        //强制类型转换
        ExpImage expImage = (ExpImage) o;
        return getImgId() == expImage.getImgId() &&
                getExpId() == expImage.getExpId() &&
                getRealName().equals(expImage.getRealName()) &&
                getFileName().equals(expImage.getFileName()) &&
                getFileType().equals(expImage.getFileType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImgId(), getExpId(), getRealName(), getFileName(), getFileType());
    }
}
