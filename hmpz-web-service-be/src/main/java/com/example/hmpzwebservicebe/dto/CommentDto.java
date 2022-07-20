package com.example.hmpzwebservicebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CommentDto implements Serializable {
    private final Long id;
    private final String text;
    private final PostDtoId post;
    private final Instant createdDate;
    private final UserDtoId user;
    private Integer voteCount;

}
