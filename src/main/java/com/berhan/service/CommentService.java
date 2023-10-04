package com.berhan.service;

import com.berhan.repository.CommentRepository;
import com.berhan.repository.entity.Comment;

import java.util.List;
import java.util.Optional;

public class CommentService {
   CommentRepository commentRepository;


    public CommentService(){
        this.commentRepository = new CommentRepository();
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Optional<Comment> findById(Long id){
        return commentRepository.findById(id);
    }

    public Iterable<Comment> saveAll(Iterable<Comment> entities){
        return commentRepository.saveAll(entities);
    }
    public void delete(Comment entity) {
        commentRepository.delete(entity);
    }
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
    public boolean existById(Long id) {
        return commentRepository.existById(id);
    }
    public List<Comment> findByEntity(Comment entity) {
        return commentRepository.findByEntity(entity);
    }
    public List<Comment> findByColumnNameAndValue(String columnName, String value) {
        return commentRepository.findByColumnNameAndValue(columnName,value);
    }
}
