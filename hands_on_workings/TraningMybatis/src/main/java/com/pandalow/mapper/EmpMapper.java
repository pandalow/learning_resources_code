package com.pandalow.mapper;

import com.pandalow.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id = #{id}")
    public int delete(int id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username,name,gender,image,job,entrydate,dept_id,create_time,update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime}")
    public void insert(Emp emp);

//    @Update("update emp set username  = #{username}, name = #{name}, gender = #{gender},image =#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, create_Time = #{createTime}, update_time = #{updateTime} where id = #{id}")
//    public void update(Emp emp);
    /**
     * 直接把表名字封装好对应
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id}")
      public Emp getById(int id);
     */

    /**
     * 第二种方式, 用Result处理封装需要字段
    @Results({
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    @Select("select * from emp where id=#{id}")
    public Emp getById(int id);
    */

    /**
     * 在application中打开驼峰命名开关
     * mybatis.configuration.map-underscore-to-camel-case=true
     * a_Column -> aColumn
     */
    @Select("select * from emp where id=#{id}")
    public Emp getById(int id);

    /**
     * 中间name部分会被sql注入
     */
//    @Select("select * from emp where name like '%${name}%' and gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 用concat来防止sql注入,可以拼接字符串;
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
//    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);



    public void update(Emp emp);
    public void delete(List<Integer> idx);
}
