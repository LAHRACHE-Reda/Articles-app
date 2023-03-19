package com.articlesapp.config;

import com.articlesapp.models.Article;
import com.articlesapp.models.User;
import com.articlesapp.services.ArticleService;
import com.articlesapp.services.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class StarterDataset {

    private final UserService userService;
    private final ArticleService articleService;
    private User adminUser;

    @PostConstruct
    public void init(){
        createAdminUser();
    }

    private void createAdminUser() {
        adminUser = User.builder()
                .id(1L)
                .username("admin")
                .email("admin@articlesapp.com")
                .password("admin$reda")
                .createdAt(LocalDateTime.now())
                .build();
        userService.createUser(adminUser);

        // Refresh the adminUser instance to get the latest state from the database
        adminUser = userService.getUserById(adminUser.getId());

        // Create default articles according to the admin
        createDefaultArticles();
    }

    private void createDefaultArticles() {
        List<Article> articles = List.of(
                Article.builder()
                        .title("Welcome")
                        .content("Hello, This is a platform for sharing knowledge")
                        .author(adminUser)
                        .createdAt(LocalDateTime.now())
                        .build(),
                Article.builder()
                        .title("Domains")
                        .content("Hello, This is primarily for spring & java tricks ...")
                        .author(adminUser)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        for(Article article: articles) {
            articleService.createArticle(article);
        }
    }

}
