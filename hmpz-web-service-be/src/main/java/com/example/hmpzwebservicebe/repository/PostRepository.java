package com.example.hmpzwebservicebe.repository;

import com.example.hmpzwebservicebe.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByUser(String username, Pageable pageable);
    Page<Post> findByNameContaining(String title, Pageable pageable);
    List<Post> findTop10ByOrderByVoteCountDesc();

}