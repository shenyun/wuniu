package cn.shenyun.wuniu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yong.luo on 2016/8/27.
 */
@Controller
public class FileController {
    @RequestMapping("upload")
    @ResponseBody
    public String upload(){
        return "ok";
    }
    @RequestMapping("download")
    public void download(){

    }
}
