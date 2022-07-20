package com.example.hmpzwebservicebe.repository;

import com.example.hmpzwebservicebe.model.Comment;
import com.example.hmpzwebservicebe.model.Post;
import com.example.hmpzwebservicebe.model.Role;
import com.example.hmpzwebservicebe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByPost(Post post);
    boolean existsCommentByPost_PostId(Long postId);
    @Transactional
    List<Comment> removeCommentsByPost_PostId(Long postId);
}