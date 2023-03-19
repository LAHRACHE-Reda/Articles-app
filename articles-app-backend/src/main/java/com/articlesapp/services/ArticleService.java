package com.articlesapp.services;

import com.articlesapp.mapping.ArticleMapper;
import com.articlesapp.models.Article;
import com.articlesapp.repositories.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper mapper;

    public Article createArticle(Article article) {
        return mapper.toArticle(articleRepository.save(mapper.toArticleEntity(article)));
    }

    public List<Article> getAllArticles() {
        return mapper.toArticles(articleRepository.findAll());
    }

    public Article getArticleById(Long id) {
        return mapper.toArticle(articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found")));
    }

    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);
    }

}
