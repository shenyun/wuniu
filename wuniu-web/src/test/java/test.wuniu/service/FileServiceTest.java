package test.wuniu.service;

import cn.shenyun.wuniu.entity.wuniu.FileInfo;
import cn.shenyun.wuniu.model.FileModel;
import cn.shenyun.wuniu.service.FileService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by yong.luo on 2016/10/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext_test.xml"
})
public class FileServiceTest {
    @Resource
    private FileService service;
    @Test
    public void save(){
        FileModel fileModel=new FileModel();
        fileModel.setFastdfsGroup("MS01");
        fileModel.setFastdfsName("M00/02/25/ChAeV1ehaAWAQSiCAAKvbEEe1Jg770.jpg");
        fileModel.setType("jpg");
        fileModel.setBizCode("100001");
        fileModel.setSize(12011);
        service.save(fileModel);
    }
    @Test
    public void get(){

        String fastdfsGroup="MS01";
        String fastdfsName="M00/02/25/ChAeV1ehaAWAQSiCAAKvbEEe1Jg770.jpg";
        FileInfo fileInfo=service.get(fastdfsGroup,fastdfsName);
        System.out.println(JSON.toJSONString(fileInfo));
    }
}
