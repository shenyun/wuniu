package cn.shenyun.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by luoyong on 2015/9/24.
 */
public class GsonFactory {
    public Gson create(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
    }
}
