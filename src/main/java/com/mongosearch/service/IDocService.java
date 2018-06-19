package com.mongosearch.service;

import com.mongosearch.domain.entity.Doc;

import java.util.List;

public interface IDocService {
    List<Doc> fullTextSearch(String fieldValue);
    List<Doc> findAll();
    void saveDoc(Doc doc);
}
