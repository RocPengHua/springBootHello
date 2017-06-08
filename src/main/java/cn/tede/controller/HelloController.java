package cn.tede.controller;

import cn.tede.pojo.User;
import cn.tede.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LYJ on 2017/6/1.
 */
@Controller
@ResponseBody  //全部的方法都能实现转化
public class HelloController {
    @Autowired
    private UserService userService;

   // @Value("${id}")
    private Integer id;

    //@Value("${name}")
    private String name;

   /* @Autowired
    private User user;

    @RequestMapping("/hello")
    @ResponseBody  //能够返回字符串和JSON串
    public String hello(){
        return "HELLO SPRINGBOOT";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("tomCat");
        user.setAge(19);
        user.setSex("男");
        return user;
    }

    @RequestMapping("/getMsg")
    public String getMsg(){
        return id+":"+name;
    }

    @RequestMapping("/getUserMsg")
    public String getUserMsg(){
        return user.toString();
    }

    @RequestMapping("/rest/{name}/{age}")
    public String restFul(@PathVariable String name, @PathVariable String age){

        return "获取name属性:"+name+":年龄"+age;
    }
*/
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/saveUser")
    public String saveUser(@Validated User user, BindingResult bindingResult){
        //如果用户输入的值满足要求才能进行插入操作.
        if(bindingResult.hasErrors()){
            //证明不满足校验规则
            return bindingResult.getFieldError().getDefaultMessage(); //获取校验信息
        }

        userService.saveUser(user);

        return  "新增成功";
    }

    @RequestMapping("/updateUser")
    public String updaetUser(User user){
        userService.updateUser(user);

        return  "修改成功";
    }

    //根据年龄查询数据库
    @RequestMapping("/findUserByAge")
    public List<User> findUserByAge(Integer age){
        return userService.findUserByAge(age);
    }
}
