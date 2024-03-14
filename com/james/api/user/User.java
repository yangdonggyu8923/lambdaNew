package com.james.api.user;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class User {

    private Long   id;
    private String username;
    private String password;
    private String checkPassword;
    private String name;
    private String phone;
    private Long addressId;
    private String job;
    private Double weight;
    private Double height;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password, String checkPassword,
                String name, String phone,String job, Double weight, Double height) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.checkPassword = checkPassword;
        this.name = name;
        this.phone = phone;
        this.job = job;
        this.weight = weight;
        this.height = height;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

