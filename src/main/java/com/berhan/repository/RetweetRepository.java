package com.berhan.repository;

import com.berhan.repository.entity.Comment;
import com.berhan.repository.entity.Retweet;
import com.berhan.utility.MyFactoryRepository;

public class RetweetRepository extends MyFactoryRepository<Retweet,Long> {
    public RetweetRepository() {
        super(new Retweet());
    }
}
