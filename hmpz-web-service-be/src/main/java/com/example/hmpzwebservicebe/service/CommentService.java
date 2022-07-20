package com.example.hmpzwebservicebe.service;

import com.example.hmpzwebservicebe.dto.CommentDto;
import com.example.hmpzwebservicebe.dto.PostDto;
import com.example.hmpzwebservicebe.dto.PostDtoId;
import com.example.hmpzwebservicebe.mapper.CommentMapper;
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

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostMapper postMapper;
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(PostRepository postRepository, CommentRepository commentRepository, PostMapper postMapper, CommentMapper commentMapper, UserMapper userMapper, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.postMapper = postMapper;
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<CommentDto> getComment() {
        return commentMapper.commentDtoToComment(commentRepository.findAll());
    }
    public List<CommentDto> getCommentByPostId(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        Post postToUse = post
                .orElseThrow(() -> new IllegalStateException("post with id " + postId+ "does not exist"));

        return commentMapper.commentDtoToComment(commentRepository.findCommentsByPost(postToUse));
    }
    public void deleteComment(Long commentId) {
        boolean exist = commentRepository.existsById(commentId);
        if (!exist) {
            throw new IllegalStateException("comment with id " + commentId + "does not exist");
        }
        commentRepository.deleteById(commentId);
    }

    public void addComment(CommentDto commentDto) {

        Optional<Post> existPost = postRepository.findById(commentDto.getPost().getPostId());
        Post postToUse = existPost
                .orElseThrow(() -> new IllegalStateException("post with id " + commentDto.getPost().getPostId()+ "does not exist"));

        Optional<User> existUser = userRepository.findById(commentDto.getUser().getUserId());
        User userToUse = existUser
                .orElseThrow(() -> new IllegalStateException("user with id " + commentDto.getPost().getPostId()+ "does not exist"));

        commentRepository.save(commentMapper.commentToCommentDto(commentDto));
    }
//
//    public void addComment(PostDto postDto) {
//        Post post = postMapper.postDtoToPost(postDto);
//        post.setUser(userMapper.userDtoToUser(postDto.getUser()));
//        postRepository.save(post);
//    }
//
//    public void deletePost(Long postId) {
//        boolean exist = postRepository.existsById(postId);
//        if (!exist) {
//            throw new IllegalStateException("post with id " + postId + "does not exist");
//        }
//        postRepository.deleteById(postId);
//    }
//
//    public void updatePost(PostDto postDto) {
//        System.out.println(postDto);
//        Optional<Post> existPost = postRepository.findById(postDto.getPostId());
//
//        Post postToUpdate = existPost
//                .orElseThrow(() -> new IllegalStateException("post with id " + postDto.getPostId() + "does not exist"));
//
//        postToUpdate.setPostId(postDto.getPostId());
//        postToUpdate.setName(postDto.getName());
//        postToUpdate.setUrl(postDto.getUrl());
//        postToUpdate.setVoteCount(postDto.getVoteCount());
//        postToUpdate.setDescription(postDto.getDescription());
//        postRepository.save(postToUpdate);
//    }
//
//    public void userCreatePost(Long userId, PostDto postDto) {
//        Optional<User> existUser = userRepository.findById(userId);
//        User user = existUser
//                .orElseThrow(() -> new IllegalStateException("user with id " +userId+ "does not exist"));
//
//        Post postToAdd = postMapper.postDtoToPost(postDto);
//
//        postToAdd.setUser(user);
//        postRepository.save(postToAdd);
//
//    }
//
//    public Integer likePost(PostDtoId postDtoId) {
//        Optional<Post> existPost = postRepository.findById(postDtoId.getPostId());
//
//        Post postToLike = existPost
//                .orElseThrow(() -> new IllegalStateException("post with id " + postDtoId.getPostId() + "does not exist"));
//
//        postToLike.setVoteCount(postToLike.getVoteCount()+1);
//        postRepository.save(postToLike);
//        return postToLike.getVoteCount();
//    }
//    public Integer removeLikePost(PostDtoId postDtoId) {
//        Optional<Post> existPost = postRepository.findById(postDtoId.getPostId());
//
//        Post postToLike = existPost
//                .orElseThrow(() -> new IllegalStateException("post with id " + postDtoId.getPostId() + "does not exist"));
//
//        postToLike.setVoteCount(postToLike.getVoteCount()-1);
//        postRepository.save(postToLike);
//        return postToLike.getVoteCount();
//    }


}
