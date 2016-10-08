package cn.shenyun.wuniu.dao.wuniu.mapext;

import cn.shenyun.wuniu.entity.wuniu.FileInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yong.luo on 2016/10/8.
 */
public interface FileInfoMapext {
    /**
     * 获取文件
     * @param urlHash
     * @param fastdfsGroup
     * @param fastdfsName
     * @return
     */
    public FileInfo getFileInfoByUrlHash(@Param("urlHash")Integer urlHash
            ,@Param("fastdfsGroup")String fastdfsGroup
            ,@Param("fastdfsName")String fastdfsName);

}
