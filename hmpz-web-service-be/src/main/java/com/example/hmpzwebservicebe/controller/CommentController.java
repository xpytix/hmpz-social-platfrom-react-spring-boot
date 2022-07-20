package com.example.hmpzwebservicebe.controller;

import com.example.hmpzwebservicebe.dto.CommentDto;
import com.example.hmpzwebservicebe.dto.PostDto;
import com.example.hmpzwebservicebe.dto.PostDtoId;
import com.example.hmpzwebservicebe.model.Post;
import com.example.hmpzwebservicebe.service.CommentService;
import com.example.hmpzwebservicebe.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public CommentController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComment() {
        return ResponseEntity.ok(commentService.getComment());
    }


    @GetMapping(path = "{postId}")
    public ResponseEntity<List<CommentDto>> getCommentByPostId(@PathVariable("postId") Long postId) {
        return ResponseEntity.ok(commentService.getCommentByPostId(postId));
    }
    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto){
        commentService.addComment(commentDto);
        return ResponseEntity.status(HttpStatus.CREATED).header("Info", "Comment has been created!").build();

    }

    @DeleteMapping(path = "{commentId}")
    public ResponseEntity deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.status(HttpStatus.OK).header("Info", "Post has been deleted!").build();
    }







//
//
//
//    @PostMapping
//    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
//        postService.createPost(postDto);
//        return ResponseEntity.status(HttpStatus.CREATED).header("Info", "Post has been created!").build();
//    }
//
//    @PostMapping(path = "{userId}")
//    public ResponseEntity<PostDto> userCreatePost(@PathVariable("userId") Long userId, @RequestBody PostDto postDto) {
//        postService.userCreatePost(userId, postDto);
//        return ResponseEntity.status(HttpStatus.CREATED).header("Info", "Post has been created!").build();
//    }
//
//    @DeleteMapping(path = "{postId}")
//    public ResponseEntity deletePost(@PathVariable("postId") Long postId) {
//        postService.deletePost(postId);
//        return ResponseEntity.status(HttpStatus.OK).header("Info", "Post has been deleted!").build();
//    }
//    @PutMapping
//    public ResponseEntity updatePost(@RequestBody PostDto postDto) {
//        postService.updatePost(postDto);
//        return ResponseEntity.status(HttpStatus.OK).header("Info", "Post has been updated!").build();
//    }
//    @GetMapping(path = "/like")
//    public ResponseEntity like(@RequestBody PostDtoId postDtoId) {
//        return ResponseEntity.ok(postService.likePost(postDtoId));
//    }
//    @GetMapping(path = "/dislike")
//    public ResponseEntity dislike(@RequestBody PostDtoId postDtoId) {
//        return ResponseEntity.ok(postService.likePost(postDtoId));
//    }
}