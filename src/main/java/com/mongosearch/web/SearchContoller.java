package com.mongosearch.web;

import com.mongosearch.domain.entity.Doc;
import com.mongosearch.service.IDocService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SearchContoller {

    @Autowired
    private IDocService iDocService;

    @RequestMapping(value={"/", "/search"})
    public ModelAndView homePage(){
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "/searchService", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object search(@RequestBody Map<String,String> params){
        String searchVal =  params.get("searchVal");
        logger.error("searchVal: " + searchVal);
        List<Doc> docs = null;
        int total = 0;
        if(searchVal != null && !searchVal.isEmpty()){
            docs = iDocService.fullTextSearch(searchVal);
            if(docs != null && docs.size() > 0) total = docs.size();
        }
//        List<Doc> docs = iDocService.findAll();
        HashMap<String,Object> respJson = new HashMap<String,Object>();
        respJson.put("draw",1);
        respJson.put("recordsTotal",total);
        respJson.put("recordsFiltered",total);
        respJson.put("data",docs);
        return respJson;
    }

    private final Logger logger = LoggerFactory.getLogger(SearchContoller.class);
}
