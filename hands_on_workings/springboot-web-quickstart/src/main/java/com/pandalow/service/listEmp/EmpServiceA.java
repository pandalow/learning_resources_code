package com.pandalow.service.listEmp;

import com.pandalow.com.pandalow.pojo.Emp;
import com.pandalow.dao.EmpDao;
import com.pandalow.dao.impl.EmpDaoA;
import com.pandalow.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if (gender.equals("1")) {
                emp.setGender("Male");
            } else if (gender.equals("2")) {
                emp.setGender("Female");
            }
            String job = emp.getJob();
            if (job.equals("1")) {
                emp.setJob("Teacher");
            } else if (job.equals("2")) {
                emp.setJob("Lecturer");
            } else if (job.equals("3")) {
                emp.setJob("Career Adviser");
            }
        });
        return empList;
    }
}
