package com.articlesapp.services;

import com.articlesapp.mapping.UserMapper;
import com.articlesapp.models.User;
import com.articlesapp.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public User createUser(User user){
        return mapper.toUser(userRepository.save(mapper.toUserEntity(user)));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toUser)
                .toList();
    }

    public User getUserById(Long id) {
        return mapper.toUser(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
