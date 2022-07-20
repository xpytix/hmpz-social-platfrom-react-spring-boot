package com.example.hmpzwebservicebe.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    private String name;

    private String url;
    private String description;
    private Integer voteCount = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Category category;
}
