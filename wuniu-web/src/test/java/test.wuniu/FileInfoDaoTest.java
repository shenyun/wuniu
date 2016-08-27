package test.wuniu;

/**
 * Created by yong.luo on 2016/8/27.
 */

import cn.shenyun.wuniu.dao.wuniu.mapper.FileInfoMapper;
import cn.shenyun.wuniu.entity.wuniu.FileInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext_test.xml"
})
public class FileInfoDaoTest {
    @Resource
    private FileInfoMapper fileInfoMapper;
    @Test
    public void select1() {
        FileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(1);
        System.out.println(fileInfo);
    }
}
