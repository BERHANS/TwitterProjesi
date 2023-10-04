package com.berhan.service;

import com.berhan.repository.TwitRepository;
import com.berhan.repository.entity.Twit;

import java.util.List;
import java.util.Optional;

public class TwitService {
    TwitRepository twitRepository;


    public TwitService(){
        this.twitRepository = new TwitRepository();
    }

    public Twit save(Twit twit){
        return twitRepository.save(twit);
    }

    public List<Twit> findAll(){
        return twitRepository.findAll();
    }

    public Optional<Twit> findById(Long id){
        return twitRepository.findById(id);
    }

    public Iterable<Twit> saveAll(Iterable<Twit> entities){
        return twitRepository.saveAll(entities);
    }
    public void delete(Twit entity) {
        twitRepository.delete(entity);
    }
    public void deleteById(Long id) {
        twitRepository.deleteById(id);
    }
    public boolean existById(Long id) {
        return twitRepository.existById(id);
    }
    public List<Twit> findByEntity(Twit entity) {
        return twitRepository.findByEntity(entity);
    }
    public List<Twit> findByColumnNameAndValue(String columnName, String value) {
        return twitRepository.findByColumnNameAndValue(columnName,value);
    }
}
