package com.articlesapp.stubs;

import com.articlesapp.entities.UserEntity;
import com.articlesapp.models.User;

import java.time.LocalDateTime;

public class UserStub {

    public final static User VALID_USER = User.builder()
            .id(1L)
            .username("reda_lh")
            .email("reda@admin.com")
            .password("password")
            .createdAt(LocalDateTime.now())
            .build();

    public final static UserEntity VALID_USER_ENTITY = new UserEntity(
            VALID_USER.getId(),
            VALID_USER.getUsername(),
            VALID_USER.getEmail(),
            VALID_USER.getPassword(),
            VALID_USER.getCreatedAt()
    );

}
