package com.example.blogsite.controller;

import com.example.blogsite.model.BlogSite;
import com.example.blogsite.service.BlogSiteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.*;

@RestController
@RequestMapping("/api/blogs")

public class BlogSiteController {
    private final BlogSiteService service;

    public BlogSiteController(BlogSiteService service){
        this.service=service;
    }

    @GetMapping
    public List<BlogSite> getAll(){
        return service.getAll();
    }

    @PostMapping
    public BlogSite create(@RequestBody BlogSite blogSite){
        return service.save(blogSite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BlogSite blogSite){
        BlogSite updated=service.update(id,blogSite);
        if(updated!=null){
            return ResponseEntity.ok(updated);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BlogSite with ID " + id + " not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(service.existsById(id)){
            service.delete(id);
            return ResponseEntity.ok("ToDo with ID " + id + " has been deleted.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BlogSite with ID " + id + " not found.");
        }
    }
}