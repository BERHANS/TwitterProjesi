package com.berhan.repository;

import com.berhan.repository.entity.Comment;
import com.berhan.utility.MyFactoryRepository;

public class CommentRepository extends MyFactoryRepository<Comment,Long> {
    public CommentRepository() {
        super(new Comment());
    }
}
