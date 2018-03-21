package com.itheima.springbootProject.controller;

import com.itheima.springbootProject.pojo.MailProperties;
import com.itheima.springbootProject.pojo.User;
import com.itheima.springbootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bear
 * @version 1.0
 * @description com.itheima.springbootProject.controller
 * @date 2018/3/20
 */
//@RestController
@Controller
public class UserController
{
    @Autowired
    private UserService userService;
   // @Resource
   // private Environment environment;
    @Value("${url}")
    private  String url;
    @RequestMapping("getProperties")
    @ResponseBody
    public  String getString(){
       // String url = environment.getProperty("url");
        return  url;
    }
    @Autowired
    private MailProperties mailProperties;
    @RequestMapping("mail")
    @ResponseBody
    public  String mail(){
        return  mailProperties.getHost()+"<br>"+mailProperties.getPort()+"<br>"+mailProperties.getUsername()+"<br>"+mailProperties.getPassword();
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return  "test6669999";
    }
    @RequestMapping("freemarker")
    public String freemarker(Model model){
        model.addAttribute("freemarker","freemarker");
        return "test";
    }
    @GetMapping("/selectAll")
    @ResponseBody
    public List<User> selectUerAll(){
        List<User> users = userService.selectUserAll();
        System.out.println(users);
        return userService.selectUserAll();
    }
    @GetMapping("/jsp")
    public String showIndex(Model model){
        model.addAttribute("message","hello555");
        return "index";
    }


}
