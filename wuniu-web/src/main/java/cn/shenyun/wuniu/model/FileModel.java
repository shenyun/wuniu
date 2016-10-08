package cn.shenyun.wuniu.model;

import java.util.Date;

/**
 * Created by yong.luo on 2016/10/8.
 */
public class FileModel {

    /**
     * 业务方编码
     */
    private String bizCode;

    /**
     * fastdfs的组名
     */
    private String fastdfsGroup;

    /**
     * fastdfs的文件名
     */
    private String fastdfsName;

    /**
     * 文件类型，后缀名
     */
    private String type;

    /**
     * 文件大小kb
     */
    private Integer size;

    /**
     * 缩放策略
     */
    private String scaleStrategy;

    /**
     * 创建时间
     */
    private Date createTime;


    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getFastdfsGroup() {
        return fastdfsGroup;
    }

    public void setFastdfsGroup(String fastdfsGroup) {
        this.fastdfsGroup = fastdfsGroup;
    }

    public String getFastdfsName() {
        return fastdfsName;
    }

    public void setFastdfsName(String fastdfsName) {
        this.fastdfsName = fastdfsName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getScaleStrategy() {
        return scaleStrategy;
    }

    public void setScaleStrategy(String scaleStrategy) {
        this.scaleStrategy = scaleStrategy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
