package com.example.hmpzwebservicebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
public class UserDtoId implements Serializable {
    private final Long userId;
    private final String name;


}
