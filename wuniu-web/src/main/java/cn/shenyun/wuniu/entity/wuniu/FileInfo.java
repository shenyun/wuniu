package cn.shenyun.wuniu.entity.wuniu;

import java.io.Serializable;
import java.util.Date;

public class FileInfo implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 业务方编码
     */
    private String bizCode;

    /**
     * 文件路径的hash值
     */
    private Integer urlHash;

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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode == null ? null : bizCode.trim();
    }

    public Integer getUrlHash() {
        return urlHash;
    }

    public void setUrlHash(Integer urlHash) {
        this.urlHash = urlHash;
    }

    public String getFastdfsGroup() {
        return fastdfsGroup;
    }

    public void setFastdfsGroup(String fastdfsGroup) {
        this.fastdfsGroup = fastdfsGroup == null ? null : fastdfsGroup.trim();
    }

    public String getFastdfsName() {
        return fastdfsName;
    }

    public void setFastdfsName(String fastdfsName) {
        this.fastdfsName = fastdfsName == null ? null : fastdfsName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
        this.scaleStrategy = scaleStrategy == null ? null : scaleStrategy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bizCode=").append(bizCode);
        sb.append(", urlHash=").append(urlHash);
        sb.append(", fastdfsGroup=").append(fastdfsGroup);
        sb.append(", fastdfsName=").append(fastdfsName);
        sb.append(", type=").append(type);
        sb.append(", size=").append(size);
        sb.append(", scaleStrategy=").append(scaleStrategy);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}