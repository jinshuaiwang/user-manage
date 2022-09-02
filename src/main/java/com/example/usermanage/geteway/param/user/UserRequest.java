package com.example.usermanage.geteway.param.user;

/**
 * Author wangjinshuai
 * Date 2022/9/2 22:28
 **/
public class UserRequest {

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

    public static final class UserRequestBuilder {
        private Long id;
        private String name;
        private String email;
        private Integer userStatus;

        private UserRequestBuilder() {
        }

        public static UserRequestBuilder anUserRequest() {
            return new UserRequestBuilder();
        }

        public UserRequestBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserRequestBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserRequestBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserRequestBuilder withUserStatus(Integer userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public UserRequest build() {
            UserRequest userRequest = new UserRequest();
            userRequest.name = this.name;
            userRequest.id = this.id;
            userRequest.userStatus = this.userStatus;
            userRequest.email = this.email;
            return userRequest;
        }
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
