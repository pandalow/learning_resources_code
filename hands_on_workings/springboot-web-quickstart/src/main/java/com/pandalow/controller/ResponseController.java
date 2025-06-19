package com.pandalow.controller;

import com.pandalow.com.pandalow.pojo.Address;
import com.pandalow.com.pandalow.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {

    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("hello world");
        return Result.success("Hello World");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address address = new Address();
        address.setAddress("cool");
        address.setProvince("Beijing");
        return Result.success(address);
    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("hell","Shandong"));
        addresses.add(new Address("heaven","Liaoning"));
        return Result.success(addresses);
    }

}
