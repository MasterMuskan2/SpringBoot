package com.example.blogsite.repository;

import com.example.blogsite.model.BlogSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogSiteRepository extends JpaRepository<BlogSite,Long>{
}
