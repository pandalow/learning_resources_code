package com.mybia;

import com.mybia.mapper.UserMapper;
import com.mybia.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybiatisTrainingApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void listUser() {
        List<User> list = userMapper.list();
        list.stream().forEach(System.out::println);
    }

}
