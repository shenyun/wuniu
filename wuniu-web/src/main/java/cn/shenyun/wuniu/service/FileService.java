package cn.shenyun.wuniu.service;

import cn.shenyun.wuniu.dao.wuniu.mapext.FileInfoMapext;
import cn.shenyun.wuniu.dao.wuniu.mapper.FileInfoMapper;
import cn.shenyun.wuniu.entity.wuniu.FileInfo;
import cn.shenyun.wuniu.model.FileModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by yong.luo on 2016/10/8.
 */
@Service
public class FileService {
    @Resource
    private FileInfoMapper fileInfoMapper;
    @Resource
    private FileInfoMapext fileInfoMapext;
    private int getFileHash(String fastdfsGroup,String fastdfsName){
        return (fastdfsGroup+"/"+fastdfsName).hashCode();
    }
    public FileInfo get(String fastdfsGroup,String fastdfsName){
        int urlHash=getFileHash(fastdfsGroup,fastdfsName);
        return fileInfoMapext.getFileInfoByUrlHash(urlHash,fastdfsGroup,fastdfsName);
    }

    public void save(FileModel fileModel){
        FileInfo fileInfo=new FileInfo();
        fileInfo.setBizCode(fileModel.getBizCode());
        int urlHash=getFileHash(fileModel.getFastdfsGroup(), fileModel.getFastdfsName());
        fileInfo.setUrlHash(urlHash);
        fileInfo.setFastdfsGroup(fileModel.getFastdfsGroup());
        fileInfo.setFastdfsName(fileModel.getFastdfsName());
        fileInfo.setType(fileModel.getType());
        fileInfo.setSize(fileModel.getSize());
        fileInfo.setDelFlag((byte)0);
        if(fileModel.getCreateTime()==null) {
            fileModel.setCreateTime(new Date());
        }
        fileInfo.setCreateTime(fileModel.getCreateTime());
        fileInfoMapper.insertSelective(fileInfo);
    }
}
