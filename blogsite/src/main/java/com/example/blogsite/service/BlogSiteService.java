package com.example.blogsite.service;

import com.example.blogsite.model.BlogSite;
import com.example.blogsite.repository.BlogSiteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service

public class BlogSiteService {
    private final BlogSiteRepository repo;

    public BlogSiteService(BlogSiteRepository repo){
        this.repo=repo;
    }

    //services of the app

    public BlogSite save(BlogSite blogSite){
        return repo.save(blogSite);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public List<BlogSite> getAll(){
        return repo.findAll();
    }

    public BlogSite update(Long id, BlogSite value){
        Optional<BlogSite> cur=repo.findById(id);
        if(cur.isPresent()){
            BlogSite val=cur.get();
            val.setTitle(value.getTitle());
            val.setContent(value.getContent());
            return repo.save(val);
        }
        else return null;
    }

    public boolean existsById(Long id) {
        return repo.existsById(id);
    }
}