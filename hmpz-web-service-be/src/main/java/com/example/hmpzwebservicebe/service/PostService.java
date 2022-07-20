package com.example.hmpzwebservicebe.service;

import com.example.hmpzwebservicebe.dto.PostDto;
import com.example.hmpzwebservicebe.dto.PostDtoId;
import com.example.hmpzwebservicebe.mapper.PostMapper;
import com.example.hmpzwebservicebe.mapper.UserMapper;
import com.example.hmpzwebservicebe.model.Comment;
import com.example.hmpzwebservicebe.model.Post;
import com.example.hmpzwebservicebe.model.User;
import com.example.hmpzwebservicebe.repository.CommentRepository;
import com.example.hmpzwebservicebe.repository.PostRepository;
import com.example.hmpzwebservicebe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserMapper userMapper;
    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, PostMapper postMapper, UserMapper userMapper, CommentRepository commentRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.userMapper = userMapper;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public List<PostDto> getPosts() {
        return postMapper.postToPostDto(postRepository.findAll());
    }

    public List<PostDto> getTrendPosts() {
        return postMapper.postToPostDto(postRepository.findTop10ByOrderByVoteCountDesc());
    }

    public void createPost(PostDto postDto) {
        Post post = postMapper.postDtoToPost(postDto);
        post.setUser(userMapper.userDtoToUser(postDto.getUser()));
        postRepository.save(post);
    }

    public void deletePost(Long postId) {
        Optional<Post> existPost = postRepository.findById(postId);
        Post postToDelete = existPost
                .orElseThrow(() -> new IllegalStateException("post with id " + postId + "does not exist"));
        boolean exist = commentRepository.existsCommentByPost_PostId(postId);
        if (!exist)
            postRepository.deleteById(postId);
        else
            commentRepository.removeCommentsByPost_PostId(postId);
    }

    public void updatePost(PostDto postDto) {
        System.out.println(postDto);
        Optional<Post> existPost = postRepository.findById(postDto.getPostId());
        Post postToUpdate = existPost
                .orElseThrow(() -> new IllegalStateException("post with id " + postDto.getPostId() + "does not exist"));
        postToUpdate.setPostId(postDto.getPostId());
        postToUpdate.setName(postDto.getName());
        postToUpdate.setUrl(postDto.getUrl());
        postToUpdate.setVoteCount(postDto.getVoteCount());
        postToUpdate.setDescription(postDto.getDescription());
        postRepository.save(postToUpdate);
    }

    public void userCreatePost(Long userId, PostDto postDto) {
        Optional<User> existUser = userRepository.findById(userId);
        User user = existUser
                .orElseThrow(() -> new IllegalStateException("user with id " +userId+ "does not exist"));
        Post postToAdd = postMapper.postDtoToPost(postDto);
        postToAdd.setUser(user);
        postRepository.save(postToAdd);
    }

    public Integer likePost(PostDtoId postDtoId) {
        Optional<Post> existPost = postRepository.findById(postDtoId.getPostId());

        Post postToLike = existPost
                .orElseThrow(() -> new IllegalStateException("post with id " + postDtoId.getPostId() + "does not exist"));

        postToLike.setVoteCount(postToLike.getVoteCount()+1);
        postRepository.save(postToLike);
        return postToLike.getVoteCount();
    }
    public Integer removeLikePost(PostDtoId postDtoId) {
        Optional<Post> existPost = postRepository.findById(postDtoId.getPostId());

        Post postToLike = existPost
                .orElseThrow(() -> new IllegalStateException("post with id " + postDtoId.getPostId() + "does not exist"));

        postToLike.setVoteCount(postToLike.getVoteCount()-1);
        postRepository.save(postToLike);
        return postToLike.getVoteCount();
    }

}
