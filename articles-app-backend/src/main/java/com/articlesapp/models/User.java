package com.articlesapp.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;

}
