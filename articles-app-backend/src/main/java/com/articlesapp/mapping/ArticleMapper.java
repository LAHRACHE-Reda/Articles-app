package com.articlesapp.mapping;

import com.articlesapp.entities.ArticleEntity;
import com.articlesapp.models.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    Article toArticle(ArticleEntity articleEntity);

    List<Article> toArticles(List<ArticleEntity> articleEntities);

    ArticleEntity toArticleEntity(Article article);

}
