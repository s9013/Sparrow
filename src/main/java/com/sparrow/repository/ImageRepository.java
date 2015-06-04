package com.sparrow.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sparrow.entity.mongo.Image;

/**
 * Image repository
 * @author 		Jay
 * @time		2015-6-4
 */
public interface ImageRepository extends PagingAndSortingRepository<Image, String>{

}

