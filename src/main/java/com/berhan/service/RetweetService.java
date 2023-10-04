package com.berhan.service;

import com.berhan.repository.RetweetRepository;
import com.berhan.repository.entity.Retweet;

import java.util.List;
import java.util.Optional;

public class RetweetService {
    RetweetRepository retweetRepository ;

    public RetweetService(){
        this.retweetRepository = new RetweetRepository();
    }

    public Retweet save(Retweet entity) {
        return  retweetRepository.save(entity);
    }


    public Iterable<Retweet> saveAll(Iterable<Retweet> entites) {
        return  retweetRepository.saveAll(entites);
    }


    public void delete(Retweet entity) {
        retweetRepository.delete(entity);

    }

    public void deleteById(Long id) {
        retweetRepository.deleteById(id);
    }


    public Optional<Retweet> findById(Long id) {
        return  retweetRepository.findById(id);
    }


    public boolean existById(Long id) {
        return retweetRepository.existById(id);
    }


    public List<Retweet> findALL() {
        return retweetRepository.findAll();
    }


    public List<Retweet> findByColumnNameAndValue(String columnName, String value) {
        return retweetRepository.findByColumnNameAndValue(columnName,value);
    }


    public List<Retweet> findByEntity(Retweet entity) {
        return retweetRepository.findByEntity(entity);
    }
}
