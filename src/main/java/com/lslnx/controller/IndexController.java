package com.lslnx.controller;

import com.lslnx.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by lslnx0307 on 2018/5/4.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Value("${age}")
    private int age;

    @Value("${say}")
    private String say;


    @RequestMapping("/aa")
    public String index(){
        return "hello spring booot";
    }

    @RequestMapping("/get")
    public HashMap<String,Object> get(@RequestParam String name){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("title","hello spring boot");
        map.put("name",name);
        map.put("age",age);
        map.put("say",say);
        return map;
    }

    @RequestMapping("/getUser/{name}/{id}")
    public User getUser(@PathVariable String name,@PathVariable int id ){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

}
