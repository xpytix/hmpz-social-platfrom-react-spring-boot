package com.example.hmpzwebservicebe.mapper;


import com.example.hmpzwebservicebe.dto.CommentDto;
import com.example.hmpzwebservicebe.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CommentMapper {

    public Comment commentToCommentDto(CommentDto commentDto);
    public CommentDto commentDtoToComment(Comment comment);
    public List<CommentDto> commentDtoToComment(List<Comment> comments);
}
