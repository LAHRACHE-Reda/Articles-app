package com.articlesapp.mapping;

import com.articlesapp.entities.UserEntity;
import com.articlesapp.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm:ss")
    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

}
