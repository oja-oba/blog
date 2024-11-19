package com.ojaoba.blog.Blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/blog")
public class BlogController {

     private final BlogService blogService;


@Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping("/")
    public List<Blog> getBlogPost(){
        return blogService.getBlogPost();

    }

    @PostMapping("/add")
    public void addBlogPost(@RequestBody Blog blog){
        blogService.addBlogPost(blog);

    }

    @PutMapping(path = "{id}")
    public void updateBlogPost(@PathVariable Integer id,
                                @RequestParam(required = false) String tittle,
                               @RequestParam(required = false) String post){
    blogService.updateBlogPost(id,tittle,post);


    }

    @DeleteMapping(path="{id}")
    public void deleteBlogPost(@PathVariable Integer id){

        blogService.deleteBlogPost(id);
    }

    @GetMapping(path ="{author}")
    public List<Blog> getBlogByAuthor(@PathVariable String author){
       return blogService.getBlogByAuthor(author);


    }

}
