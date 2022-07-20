package com.example.hmpzwebservicebe.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
public class PostDto implements Serializable{
    private final Long postId;
    private final String name;
    private final String url;
    private final String description;
    private final Integer voteCount;
    private final UserDtoId user;
}
