package com.myblogg.controller;

import com.myblogg.payload.PostDto;
import com.myblogg.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }
    //http://localhost:8080/api/posts?pageNo=0&pageSize=3
//    @GetMapping
//    public List<PostDto> getAllPosts(
//            @RequestParam(name="pageNo",required = false, defaultValue = "0") int pageNo,
//            @RequestParam(name="pageSize",required = false, defaultValue = "3") int pageSize
//    ){
//        List<PostDto> postDtos= postService.getAllPosts(pageNo,pageSize);
//        return  postDtos;
//
//    }
    //http://localhost:8080/api/posts?pageNo=0&pageSize=3&sortBy=title
    @GetMapping
    public List<PostDto> getAllPosts(
            @RequestParam(name="pageNo",required = false, defaultValue = "0") int pageNo,
            @RequestParam(name="pageSize",required = false, defaultValue = "3") int pageSize,
            @RequestParam(name="sort",required = false, defaultValue = "id") String sortBy,
            @RequestParam(name="sortDir",required = false, defaultValue = "id") String sortDir
    ){
        List<PostDto> postDtos= postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
        return  postDtos;

    }


}
