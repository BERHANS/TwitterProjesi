package com.berhan.controller;

import com.berhan.repository.CommentRepository;
import com.berhan.repository.entity.Comment;
import com.berhan.service.CommentService;
import com.berhan.utility.Constants;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommentController {

    CommentService commentService;


    public CommentController(){
        this.commentService = new CommentService();
    }

    public Comment save(Comment comment){
        return commentService.save(comment);
    }

    public List<Comment> findAll(){
        return commentService.findAll();
    }

    public Optional<Comment> findById(Long id){
        return commentService.findById(id);
    }

    public Iterable<Comment> saveAll(Iterable<Comment> entities){
        return commentService.saveAll(entities);
    }
    public void delete(Comment entity) {
        commentService.delete(entity);
    }
    public void deleteById(Long id) {
        commentService.deleteById(id);
    }
    public boolean existById(Long id) {
        return commentService.existById(id);
    }
    public List<Comment> findByEntity(Comment entity) {
        return commentService.findByEntity(entity);
    }
    public List<Comment> findByColumnNameAndValue(String columnName, String value) {
        return commentService.findByColumnNameAndValue(columnName,value);
    }
    public void commentYap(Long twitId,Long userId){
        System.out.print("Yorum Yapınız: ");
        String text = new Scanner(System.in).nextLine();
        Comment comment = Comment.builder()
                .date(System.currentTimeMillis())
                .twitId(twitId)
                .userId(userId)
                .text(text)
                .baseEntity(Constants.getBaseEntity())
                .build();
        save(comment);
    }
}
