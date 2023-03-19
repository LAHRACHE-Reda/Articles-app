package com.articlesapp.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class Article {

    private String title;
    private String content;
    private User author;
    private LocalDateTime createdAt;
    private List<Tag> tags;

}
