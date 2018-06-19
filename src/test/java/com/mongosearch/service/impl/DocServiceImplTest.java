package com.mongosearch.service.impl;

import com.mongosearch.MainApp;
import com.mongosearch.domain.entity.Doc;
import com.mongosearch.domain.entity.DocDtl;
import com.mongosearch.service.IDocService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApp.class)
public class DocServiceImplTest {

    @Autowired
    private IDocService iDocService;

    @Test
    public void saveDoc() {
        DocDtl docDtl = new DocDtl("URL","IP address",
                "http://172.19.140.13:9080/apex/apex.jnlp","DEV N4 Srv1 Node1");
        Doc doc = new Doc("MTL","DEV","N4T","SRV1-NODE1",docDtl);
        iDocService.saveDoc(doc);
        System.out.println(doc.toString());

        docDtl  = new DocDtl("URL","IP address",
                "http://172.19.140.13:10080/apex/apex.jnlp","DEV N4 Srv1 Node2");
        doc = new Doc("MTL","DEV","N4T","SRV1-NODE2",docDtl);
        iDocService.saveDoc(doc);
        System.out.println(doc.toString());

        docDtl  = new DocDtl("URL","IP address",
                "http://172.19.140.17:11080/billing/billing.jnlp","DEV N4 Billing server 1");
        doc = new Doc("MTL","DEV","N4B","SRV1",docDtl);
        iDocService.saveDoc(doc);
        System.out.println(doc.toString());
    }

    @Test
    public void fullTextSearch() {
        String searchValue = "N4T";
        List<Doc> docs = iDocService.fullTextSearch(searchValue);
        for(Doc doc: docs){
            System.out.println(doc.toString());
        }
    }

    @Test
    public void findAll() {
        List<Doc> docs = iDocService.findAll();
        for(Doc doc: docs){
            System.out.println(doc.toString());
        }
    }
}