package com.mongosearch.service.impl;

import com.mongosearch.domain.entity.Doc;
import com.mongosearch.domain.repository.DocRepository;
import com.mongosearch.service.IDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocServiceImpl implements IDocService {

    @Autowired
    private DocRepository docRepository;

    @Override
    public List<Doc> fullTextSearch(String fieldValue) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(fieldValue);
        List<Doc> docs = docRepository.findAllBy(textCriteria);
        if(docs != null && docs.size() > 0)
            return docs;
        return null;
    }

    @Override
    public List<Doc> findAll() {
        List<Doc> docs = docRepository.findAll();
        if(docs != null && docs.size() > 0)
            return docs;
        return null;
    }

    @Override
    public void saveDoc(Doc doc) {
        docRepository.save(doc);
    }
}
