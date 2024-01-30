package com.myblogg.service;

import com.myblogg.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,long postId);

    void deleteComment(long id);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);

    List<CommentDto> getAllComments();

//    void updateComment(long id, CommentDto commentDto);
}
