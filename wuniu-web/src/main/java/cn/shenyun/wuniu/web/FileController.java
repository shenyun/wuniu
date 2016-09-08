package cn.shenyun.wuniu.web;

import cn.shenyun.utils.HostUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.ObjectName;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping("session")
    @ResponseBody
    public Map session(String userId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> res=new HashMap<>();
        if(userId==null||userId.equals("")){
            res.put("msg","must set userId");
            return res;
        }
        request.getSession().setAttribute("userId",userId);
        res.put("msg","userId set ok");
        return res;
    }
    @RequestMapping("getsession")
    @ResponseBody
    public Map getsession(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> res=new HashMap<>();
        HttpSession httpSession=request.getSession();
        String userId="";
        if(httpSession.getAttribute("userId")!=null){
            userId=httpSession.getAttribute("userId").toString();
        }
        res.put("msg","userId="+userId);
        res.put("ip", HostUtils.getHostAddress());
        res.put("port", HostUtils.getPort());
        return res;
    }

}
