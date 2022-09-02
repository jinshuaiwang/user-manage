package com.example.usermanage.geteway.convert;

import com.example.usermanage.geteway.param.user.UserRequest;
import com.example.usermanage.server.service.dto.UserDTO;

import java.util.function.Function;

/**
 * Author wangjinshuai
 * Date 2022/9/2 22:51
 **/
public class UserWebConvert {

    public static Function<UserRequest, UserDTO> toUserDTO = request -> {

        if (null == request) {
            return null;
        }

        return UserDTO.UserDTOBuilder.anUserDTO()
                .withId(request.getId())
                .withEmail(request.getEmail())
                .withName(request.getName())
                .withUserStatus(request.getUserStatus())
                .build();
    };
}
