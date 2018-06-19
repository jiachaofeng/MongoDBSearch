package com.mongosearch.domain.repository;

import com.mongosearch.domain.entity.Doc;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("doctRepository")
public interface DocRepository extends PagingAndSortingRepository<Doc,Long> {
    public List<Doc> findAllBy(TextCriteria criteria);
    public List<Doc> findAll();
}
