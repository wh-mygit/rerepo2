package com.qs.dao;

import com.qs.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    //查询全部信息
    @Select("select * from users")
    List<User> getAllUser();

    //删除信息
    @Delete("delete from users where id between 1 and 3")
    void deleteUser();
}
