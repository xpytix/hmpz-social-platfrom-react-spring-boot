package com.example.hmpzwebservicebe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private String image;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private Instant created;
    private boolean enabled;
    public User() {
    }
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
