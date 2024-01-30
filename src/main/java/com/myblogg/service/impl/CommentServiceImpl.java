package com.myblogg.service.impl;

import com.myblogg.entity.Comment;
import com.myblogg.entity.Post;
import com.myblogg.exception.ResourceNotFoundException;
import com.myblogg.payload.CommentDto;
import com.myblogg.repository.CommentRepository;
import com.myblogg.repository.PostRepository;
import com.myblogg.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;

    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post Not found with id" + postId));
        Comment comment =new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto=new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());
        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

//    @Override
//    public CommentDto updateComment(long id, CommentDto commentDto) {
//        Comment comment = commentRepository.findById(id).orElseThrow(
//               () -> new ResourceNotFoundException("Comment Not Found for id :" + id)
//       );
//         modelMapper.map(commentDto, comment);
////        Object map1 = modelMapper.map(map, commentDto.class);
//        return null;
//    }

//    @Override
//    public CommentDto updateComment(long id, CommentDto commentDto) {
//        Comment comment = commentRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Comment Not Found for id: " + id)
//        );
//
//        // Update the comment's properties with values from commentDto
//        modelMapper.map(commentDto, comment);
//
//        // Save the updated comment back to the repository
//        Comment updatedComment = commentRepository.save(comment);
//
//        // Map the updated comment back to CommentDto and return it
//        return modelMapper.map(updatedComment, CommentDto.class);
//    }
@Override
public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
    Post post = postRepository.findById(postId).orElseThrow(
            () -> new ResourceNotFoundException("Post Not Found for id: " + id)
    );
    Comment comment = commentRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Comment Not Found for id: " + id)
    );

    // Manually update the comment's properties with values from commentDto
//    comment.setEmail(commentDto.getEmail());
//    comment.setText(commentDto.getText());
//
//    // Save the updated comment back to the repository
//    Comment updatedComment = commentRepository.save(comment);
//
//    // Map the updated comment back to CommentDto and return it
//    return modelMapper.map(updatedComment, CommentDto.class);
    Comment c = mapToEntity(commentDto);
    c.setId(comment.getId());
    c.setPost(post);
    Comment savedComment = commentRepository.save(c);


    return mapToDto(savedComment);
}

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }
    
    CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }
    Comment mapToEntity(CommentDto commentDto){
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }


}
