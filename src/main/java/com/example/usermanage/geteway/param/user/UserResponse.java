package com.example.usermanage.geteway.param.user;

/**
 * Author wangjinshuai
 * Date 2022/9/2 22:28
 **/
public class UserResponse {

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


    public static final class UserResponseBuilder {
        private Long id;
        private String name;
        private String email;
        private Integer userStatus;

        private UserResponseBuilder() {
        }

        public static UserResponseBuilder anUserResponse() {
            return new UserResponseBuilder();
        }

        public UserResponseBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserResponseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserResponseBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserResponseBuilder withUserStatus(Integer userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public UserResponse build() {
            UserResponse userResponse = new UserResponse();
            userResponse.userStatus = this.userStatus;
            userResponse.id = this.id;
            userResponse.email = this.email;
            userResponse.name = this.name;
            return userResponse;
        }
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
