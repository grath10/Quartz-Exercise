package com.dell.october.mapper;

import com.dell.october.entity.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    @Select("select username, password from user where username like #{username}")
    Person findByUsername(String username);
}
