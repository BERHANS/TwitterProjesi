package com.berhan.controller;

import com.berhan.repository.TwitRepository;
import com.berhan.repository.entity.Twit;
import com.berhan.service.TwitService;
import com.berhan.utility.Constants;
import jdk.jshell.SourceCodeAnalysis;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TwitController {
    TwitService twitService;


    public TwitController(){
        this.twitService = new TwitService();
    }

    public Twit save(Twit twit){
        return twitService.save(twit);
    }

    public List<Twit> findAll(){
        return twitService.findAll();
    }

    public Optional<Twit> findById(Long id){
        return twitService.findById(id);
    }

    public Iterable<Twit> saveAll(Iterable<Twit> entities){
        return twitService.saveAll(entities);
    }
    public void delete(Twit entity) {
        twitService.delete(entity);
    }
    public void deleteById(Long id) {
        twitService.deleteById(id);
    }
    public boolean existById(Long id) {
        return twitService.existById(id);
    }
    public List<Twit> findByEntity(Twit entity) {
        return twitService.findByEntity(entity);
    }
    public List<Twit> findByColumnNameAndValue(String columnName, String value) {
        return twitService.findByColumnNameAndValue(columnName,value);
    }

    public void tweetAt(Long id){
        System.out.print("Tweet At..");
        String text = new Scanner(System.in).nextLine();
        Twit twit = Twit.builder()
                .baseEntity(Constants.getBaseEntity())
                .date(System.currentTimeMillis())
                .userId(id)
                .text(text)
                .build();
        save(twit);

    }


}
