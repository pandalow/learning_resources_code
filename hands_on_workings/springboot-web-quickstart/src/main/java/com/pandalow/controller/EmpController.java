package com.pandalow.controller;

import com.pandalow.com.pandalow.pojo.Emp;
import com.pandalow.com.pandalow.pojo.Result;
import com.pandalow.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {
        List<Emp> empList = empService.listEmp();
        return Result.success(empList);

    }
}
