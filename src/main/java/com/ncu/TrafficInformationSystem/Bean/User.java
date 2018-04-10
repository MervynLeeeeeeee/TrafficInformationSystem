package com.ncu.TrafficInformationSystem.Bean;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    private String userId;

    private String userName;

    private String userNickname;

    private String userPassword;

    private Integer userLevel;

    private Integer registerTime;

}