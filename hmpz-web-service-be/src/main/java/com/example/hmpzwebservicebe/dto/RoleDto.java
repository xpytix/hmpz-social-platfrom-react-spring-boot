package com.example.hmpzwebservicebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class RoleDto implements Serializable {
    private final Long id;
    private final String name;
}
