package com.ncu.TrafficInformationSystem.Mapper;

import com.ncu.TrafficInformationSystem.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    User find(User record);

    User selectUserByUsername(User record);

    User selectUserByUserId(User record);

    void insertUser(User record);
}
