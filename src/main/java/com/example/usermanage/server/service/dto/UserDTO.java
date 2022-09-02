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


    public static final class UserDTOBuilder {
        private Long id;
        private String name;
        private String email;

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

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.name = this.name;
            userDTO.id = this.id;
            userDTO.email = this.email;
            return userDTO;
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
