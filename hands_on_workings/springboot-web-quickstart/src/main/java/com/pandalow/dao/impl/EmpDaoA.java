package com.pandalow.dao.impl;

import com.pandalow.Util.XmlParserUtils;
import com.pandalow.com.pandalow.pojo.Emp;
import com.pandalow.dao.EmpDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
        //加载解析xml文件
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
