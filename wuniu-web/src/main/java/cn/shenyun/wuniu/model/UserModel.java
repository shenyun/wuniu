package cn.shenyun.wuniu.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yong.luo on 2016/12/7.
 */
public class UserModel {
    private String userId;
    private String userName;
    private String time;
    private List<GroupModel> groupModels;

    public UserModel() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time=simpleDateFormat.format(new Date());
        groupModels=new ArrayList<>();
    }

    public UserModel(String userId, String userName) {
        this();
        this.userId = userId;
        this.userName = userName;
        groupModels.add(new GroupModel("griup1","组1"));
        groupModels.add(new GroupModel("griup2","组2"));
    }

    public List<GroupModel> getGroupModels() {
        return groupModels;
    }

    public void setGroupModels(List<GroupModel> groupModels) {
        this.groupModels = groupModels;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
