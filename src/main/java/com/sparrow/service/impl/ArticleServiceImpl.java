package com.sparrow.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sparrow.entity.mongo.Article;
import com.sparrow.repository.ArticleRepository;
import com.sparrow.service.iface.IArticleService;
import com.sparrow.vo.ArticleVo;
import com.sparrow.vo.PaginationVo;

/**
 * Created by Jay on 2015/5/26.
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    ArticleRepository articleRepository;
    
    @Autowired
    MongoTemplate mongoTemplate; 

    @Override
    public ArticleVo findArticleByArticleId(String articleId) {
        Article article = articleRepository.findOne(articleId);
        ArticleVo articleVo = new ArticleVo();
        if(null != article){
        	 articleVo.setArticleId(article.getArticleId());
             articleVo.setTitle(article.getTitle());
             articleVo.setContent(article.getContent());
             articleVo.setDate(article.getDate());
        }
        return articleVo;
    }

    @Override
    public List<ArticleVo> findAritcleBySortWithDate(Date date) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC,"date"));
        List<Article> list = mongoTemplate.find(query, Article.class);
        List<ArticleVo> articleVoList = new ArrayList<ArticleVo>();
        for(Article article : list){
        	ArticleVo articleVo = new ArticleVo(article.getArticleId(), article.getTitle(),article.getSummary(), article.getContent(), article.getDate());
        	articleVoList.add(articleVo);
        }
        return articleVoList;
    }

    @Override
    public PaginationVo findAritcleByPagination(Integer pageNumber, Integer pageSize) {
    	Query query = new Query();
    	query.skip((pageNumber-1)*pageSize);
		query.limit(pageSize);
    	List<Article> list = mongoTemplate.find(query, Article.class);
        List<ArticleVo> articleVoList = new ArrayList<ArticleVo>();
        for(Article article : list){
        	ArticleVo articleVo = new ArticleVo(article.getArticleId(), article.getTitle(), article.getSummary(),article.getContent(), article.getDate());
        	articleVoList.add(articleVo);
        }
        
        PaginationVo paginationVo = new PaginationVo();
        paginationVo.setTotalItems(mongoTemplate.find(null, Article.class).size());
        paginationVo.setData(articleVoList);;
        
        return paginationVo;
    }

	@Override
	public void saveArticle(ArticleVo articleVo) {
		Article article = new Article( articleVo.getTitle(), articleVo.getContent().substring(0, 200).concat("..."),articleVo.getContent(), new Date());
		articleRepository.save(article);
	}

	@Override
	public void deleteArticleByArticleId(String articleId) {
		articleRepository.delete(new Article(articleId));
	}
}
