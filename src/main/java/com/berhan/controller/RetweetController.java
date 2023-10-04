package com.berhan.controller;

import com.berhan.repository.RetweetRepository;
import com.berhan.repository.entity.Retweet;
import com.berhan.service.RetweetService;
import com.berhan.utility.Constants;

import java.util.List;
import java.util.Optional;

public class RetweetController {
    RetweetService retweetService;

    public RetweetController(){
        this.retweetService = new RetweetService();
    }

    public Retweet save(Retweet entity) {
        return  retweetService.save(entity);
    }


    public Iterable<Retweet> saveAll(Iterable<Retweet> entites) {
        return  retweetService.saveAll(entites);
    }


    public void delete(Retweet entity) {
        retweetService.delete(entity);

    }

    public void deleteById(Long id) {
        retweetService.deleteById(id);
    }


    public Optional<Retweet> findById(Long id) {
        return  retweetService.findById(id);
    }


    public boolean existById(Long id) {
        return retweetService.existById(id);
    }


    public List<Retweet> findALL() {
        return retweetService.findALL();
    }


    public List<Retweet> findByColumnNameAndValue(String columnName, String value) {
        return retweetService.findByColumnNameAndValue(columnName,value);
    }


    public List<Retweet> findByEntity(Retweet entity) {
        return retweetService.findByEntity(entity);
    }
    public void reTweetYap(Long id,Long userId){
    Retweet retweet = Retweet.builder()
            .baseEntity(Constants.getBaseEntity())
            .twitId(id)
            .userId(userId)
            .build();
    save(retweet);


    }
}
