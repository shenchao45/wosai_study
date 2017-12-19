package com.shenchao.test;
import net.logstash.logback.marker.Markers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenchao on 17/12/13.
 */
public class LogBackDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogBackDemo.class);
    public static void main(String[] args) {
        User user = new User();
        user.setPassword("dasdsds");
//        LOGGER.trace(Markers.appendFields(user),"用户测试");
//        LOGGER.trace(Markers.append("我的测试",user),"用户测试");
        Map<String, Object> map = new HashMap();
        map.put("sc", "沈超");
        map.put("你好啊", 1);
        map.put("aaa", true);
        map.put("user", user);
        LOGGER.trace(Markers.appendFields(map),"hello world");
    }
}

class User{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
