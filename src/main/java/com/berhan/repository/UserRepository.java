package com.berhan.repository;

import com.berhan.repository.entity.Comment;
import com.berhan.repository.entity.User;
import com.berhan.utility.MyFactoryRepository;

public class UserRepository extends MyFactoryRepository<User,Long> {
    public UserRepository() {
        super(new User());
    }
}
