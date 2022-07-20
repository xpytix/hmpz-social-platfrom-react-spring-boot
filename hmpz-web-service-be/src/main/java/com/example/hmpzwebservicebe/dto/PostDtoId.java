package com.example.hmpzwebservicebe.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
public class PostDtoId implements Serializable {
    private final Long postId;
}
