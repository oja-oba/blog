package com.ojaoba.blog.Blog;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Blog {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String tittle;
    private String post;

}
