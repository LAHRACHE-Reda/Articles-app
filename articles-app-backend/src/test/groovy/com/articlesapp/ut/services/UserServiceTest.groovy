package com.articlesapp.ut.services

import com.articlesapp.mapping.UserMapper
import com.articlesapp.repositories.UserRepository
import com.articlesapp.services.UserService
import com.articlesapp.stubs.UserStub
import spock.lang.Specification
import spock.lang.Subject

class UserServiceTest extends Specification {

    @Subject
    private UserService userService

    private UserRepository userRepository = Mock(UserRepository)
    private UserMapper userMapper = Mock(UserMapper)

    def setup() {
        userService = new UserService(userRepository, userMapper)
    }

    def "createUser should save and return the User"() {
        given:
        def user = UserStub.VALID_USER
        def userEntity = UserStub.VALID_USER_ENTITY

        userRepository.save(userEntity) >> userEntity
        userMapper.toUserEntity(user) >> userEntity
        userMapper.toUser(userEntity) >> user

        when:
        def result = userService.createUser(user)

        then:
        result == user
    }

}
