package cn.shenyun.wuniu.web;

import cn.shenyun.utils.HostUtils;
import cn.shenyun.wuniu.model.UserModel;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.ObjectName;
import javax.servlet.http.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yong.luo on 2016/8/27.
 */
@Controller
public class FileController {
    private static Logger logger= LoggerFactory.getLogger(FileController.class);
    @RequestMapping("upload")
    @ResponseBody
    public String upload(){
        return "ok";
    }
    @RequestMapping("download")
    public void download(String path){

    }
    @RequestMapping("session")
    @ResponseBody
    public Map session(String userId,String userName,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> res=new HashMap<>();
        if(userId==null||userId.equals("")){
            res.put("msg","must set userId");
            return res;
        }
        UserModel userModel=new UserModel(userId,userName);
        request.getSession().setAttribute("user",userModel);
        request.getSession().setAttribute("userId",userId);
        res.put("msg","userId set ok");
        res.put("ip", HostUtils.getHostAddress());
        res.put("port", HostUtils.getPort());
        logger.info("----------------"+JSON.toJSONString(res));
        return res;
    }
    @RequestMapping("getsession")
    @ResponseBody
    public Map getsession(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> res=new HashMap<>();
        HttpSession httpSession=request.getSession();
        UserModel userModel=null;
        if(httpSession.getAttribute("user")!=null){
            userModel=(UserModel)httpSession.getAttribute("user");
        }
        res.put("user",userModel);
        res.put("ip", HostUtils.getHostAddress());
        res.put("port", HostUtils.getPort());
        res.put("cookieList", getCookies(request));
        res.put("cookies", request.getCookies());
        logger.info("----------------"+JSON.toJSONString(res));
        return res;
    }
    @RequestMapping("cookie")
    @ResponseBody
    public Map cookie(String userId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> res=new HashMap<>();
        Cookie cookie = new Cookie("cookiename",userId);
        response.addCookie(cookie);
        res.put("msg","userId set ok");
        res.put("ip", HostUtils.getHostAddress());
        res.put("port", HostUtils.getPort());
        res.put("cookieList", getCookies(request));
        res.put("cookies", request.getCookies());
        return res;
    }
    @RequestMapping("getcookie")
    @ResponseBody
    public Map getCookie(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> res=new HashMap<>();
        res.put("ip", HostUtils.getHostAddress());
        res.put("port", HostUtils.getPort());
        res.put("cookieList", getCookies(request));
        res.put("cookies", request.getCookies());
        return res;
    }
    private Map<String,String> getCookies(HttpServletRequest request){
        Map<String,String> cookieMap=new HashMap<>();
        Cookie[] cookies=request.getCookies();
        if(cookies!=null&&cookies.length>0){
            for (int i = 0; i <cookies.length ; i++) {
                cookieMap.put(cookies[i].getName(),cookies[i].getValue());
            }
        }
        return cookieMap;
    }
    private String getCookie(HttpServletRequest request,String cookieName){
        Cookie[] cookies=request.getCookies();
        if(cookies!=null&&cookies.length>0){
            for (int i = 0; i <cookies.length ; i++) {
                if(cookies[i].getName().equals("cookieName")){
                    return cookies[i].getValue();
                }
            }
        }
        return "";
    }

}
