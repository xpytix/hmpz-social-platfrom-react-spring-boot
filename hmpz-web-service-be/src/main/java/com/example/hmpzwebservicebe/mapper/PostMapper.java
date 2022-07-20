package com.example.hmpzwebservicebe.mapper;

import com.example.hmpzwebservicebe.dto.PostDto;
import com.example.hmpzwebservicebe.dto.PostDtoId;
import com.example.hmpzwebservicebe.model.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    public PostDto postToPostDto(Post post);
    public Post postDtoToPost(PostDto postDto);

    public List<PostDto> postToPostDto(List<Post> posts);

    public PostDtoId postToPostDtoId(Post post);
    public Post postDtoIdToPostDto(PostDtoId post);
}
