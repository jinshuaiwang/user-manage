package com.example.usermanage.server.service.mapper;

import com.example.usermanage.server.service.dto.UserDTO;
import com.example.usermanage.server.service.entity.User;
import org.apache.ibatis.annotations.Insert;
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

    @Select({"<script>",
            "select a.id, a.`name`, a.email from common_user a " ,
            "<where> " ,
            "<if test='userDTO.name != null'>a.`name`=#{userDTO.name}</if> " ,
            "<if test='userDTO.id != null'>a.id=#{userDTO.id}</if> " ,
            "<if test='userDTO.email != null'>a.email=#{userDTO.email}</if> " ,
            "</where> " ,
            "</script>"})
    User getUserByDTO(@Param("userDTO")UserDTO userDTO);

    @Insert("insert into common_user (name, email) VALUES (#{user.name}, #{user.email})")
    Long saveUser(@Param("user") User user);
}
