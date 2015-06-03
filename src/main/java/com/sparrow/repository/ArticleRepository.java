package com.sparrow.repository;

import com.sparrow.entity.mongo.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Jay on 2015/5/26.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, String> {

}
