package com.example.usermanage.server.service.dto;

/**
 * Author wangjinshuai
 * Date 2022/9/2 17:58
 **/
public class UserDTO {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * @see com.example.usermanage.server.service.enums.UserStatusEnum
     * 用户状态
     */
    private Integer userStatus;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public static final class UserDTOBuilder {
        private Long id;
        private String name;
        private String email;
        private Integer userStatus;

        private UserDTOBuilder() {
        }

        public static UserDTOBuilder anUserDTO() {
            return new UserDTOBuilder();
        }

        public UserDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserDTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder withUserStatus(Integer userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.userStatus = this.userStatus;
            userDTO.id = this.id;
            userDTO.name = this.name;
            userDTO.email = this.email;
            return userDTO;
        }
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }


}
