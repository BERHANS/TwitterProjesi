package com.berhan.repository;

import com.berhan.repository.entity.Comment;
import com.berhan.repository.entity.Twit;
import com.berhan.utility.MyFactoryRepository;

public class TwitRepository extends MyFactoryRepository<Twit,Long> {
    public TwitRepository() {
        super(new Twit());
    }
}
