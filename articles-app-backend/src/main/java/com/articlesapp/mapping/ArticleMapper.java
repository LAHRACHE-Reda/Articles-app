package com.articlesapp.mapping;

import com.articlesapp.entities.ArticleEntity;
import com.articlesapp.models.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    Article toArticle(ArticleEntity articleEntity);

    List<Article> toArticles(List<ArticleEntity> articleEntities);

    @Mapping(target = "id", ignore = true)
    ArticleEntity toArticleEntity(Article article);

}
