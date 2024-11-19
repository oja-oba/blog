package com.ojaoba.blog.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getBlogPost() {
        return blogRepository.findAll();


    }

    public void addBlogPost(Blog blog) {
        blogRepository.save(blog);
    }


    @Transactional
    public void updateBlogPost(Integer id, String tittle, String post) {
      Blog blog =blogRepository.findById(id).orElseThrow(() -> new IllegalStateException("no blog with te id exists"));
      if (tittle !=null && !tittle.isEmpty() && !Objects.equals(blog.getTittle(),tittle)){
          blog.setTittle(tittle);
      }

      if(post!=null &&!post.isEmpty() && !Objects.equals(blog.getPost(),post)){
          blog.setPost(post);
      }
    }

    public void deleteBlogPost(Integer id) {
        boolean exists = blogRepository.existsById(id);

        if(!exists){

            throw new IllegalStateException("The id does not exist");
        }

           blogRepository.deleteById(id);
    }

    public List<Blog> getBlogByAuthor(String author) {
       return ( blogRepository.findBlogByAuthor(author));
    }
}
