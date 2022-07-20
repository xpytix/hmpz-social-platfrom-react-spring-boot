package com.example.hmpzwebservicebe.controller;

import com.example.hmpzwebservicebe.dto.PostDto;
import com.example.hmpzwebservicebe.dto.PostDtoId;
import com.example.hmpzwebservicebe.model.Post;
import com.example.hmpzwebservicebe.repository.PostRepository;
import com.example.hmpzwebservicebe.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @Autowired
    public PostController(PostService postService, PostRepository postRepository) {
        this.postService = postService;
        this.postRepository = postRepository;
    }


    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
   }

    @GetMapping(path = "/trend")
    public ResponseEntity<List<PostDto>> getTrendPosts() {
        return ResponseEntity.ok(postService.getTrendPosts());
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<Map<String, Object>> getAllPosts(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        try {
            List<Post> posts = new ArrayList<Post>();
            Pageable paging = PageRequest.of(page, size);

            Page<Post> pageTuts;
            if (name == null)
                pageTuts = postRepository.findAll(paging);
            else
                pageTuts = postRepository.findByNameContaining(name, paging);
            posts = pageTuts.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("posts", posts);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).header("Info", "Post has been created!").build();
    }

    @PostMapping(path = "{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<PostDto> userCreatePost(@PathVariable("userId") Long userId, @RequestBody PostDto postDto) {
        postService.userCreatePost(userId, postDto);
        return ResponseEntity.status(HttpStatus.CREATED).header("Info", "Post has been created!").build();
    }

    @DeleteMapping(path = "{postId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(HttpStatus.OK).header("Info", "Post has been deleted!").build();
    }
    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity updatePost(@RequestBody PostDto postDto) {
        postService.updatePost(postDto);
        return ResponseEntity.status(HttpStatus.OK).header("Info", "Post has been updated!").build();
    }
    @PutMapping(path = "/like")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity like(@RequestBody PostDtoId postDtoId) {
        return ResponseEntity.ok(postService.likePost(postDtoId));
    }
    @PutMapping(path = "/dislike")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity dislike(@RequestBody PostDtoId postDtoId) {
        return ResponseEntity.ok(postService.removeLikePost(postDtoId));
    }
}
