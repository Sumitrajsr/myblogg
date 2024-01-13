package com.myblogg.service.impl;

import com.myblogg.entity.Post;
import com.myblogg.payload.PostDto;
import com.myblogg.repository.PostRepository;
import com.myblogg.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post posts=new Post();
        posts.setTitle(postDto.getTitle());
        posts.setDescription(postDto.getDescription());
        posts.setContent(postDto.getContent());
        Post savePost = postRepository.save(posts);
        PostDto dto=new PostDto();
        dto.setTitle(savePost.getTitle());
        dto.setDescription(savePost.getDescription());
        dto.setContent(savePost.getContent());
        return dto;
    }
}
