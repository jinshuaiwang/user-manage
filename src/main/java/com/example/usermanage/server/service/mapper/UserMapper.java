package com.example.usermanage.server.service.mapper;

import com.example.usermanage.server.service.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Author wangjinshuai
 * Date 2022/9/1 22:52
 **/
@Mapper
public interface UserMapper {

    @Select("select a.id, a.`name`, a.email from common_user a where a.id = #{userId}")
    User getUserById(@Param("userId") Long userId);
}
