package com.pandalow.controller;

import com.pandalow.com.pandalow.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
//ResponseBody + Controller
public class RequestController {
    //    @RequestMapping("/simpleParam")
//    public String simplePara(HttpServletRequest request) {
//
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        Integer.parseInt(age);
//
//        return age + name;
//
//    }
//    @RequestMapping("/simpleParam")
//    public String simplePara(String name,int age) {
//
//        return age + name;
//
//    }
    @RequestMapping("/simpleParam")
    public String simplePara(@RequestParam(name = "name") String username, int age) {

        return age + username;

    }

    @RequestMapping("/simpleEntity")
    public String simpleEntity(User user) {

        return user.getName() + user.getAge();
    }

    @RequestMapping("/complexEntity")
    public String complexEntity(User user) {
        return user.getAddress().getAddress() + user.getAddress().getProvince();
    }

    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(hobby.toString());
        return "Ok";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby.toString());
        return "OK";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user.toString());
        return "OK";
    }

    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id) {
        System.out.println(id);
        return "ok";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + name);
        return "ok";
    }

}
