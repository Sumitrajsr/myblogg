package com.myblogg.service;

import com.myblogg.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    void deleteComment(long id);
}
