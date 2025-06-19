package com.pandalow;

import com.pandalow.mapper.EmpMapper;
import com.pandalow.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TraningMybatisApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void delete(){
        int delete = empMapper.delete(17);
        System.out.println(delete);
    }


}
