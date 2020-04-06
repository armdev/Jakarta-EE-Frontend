/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.javafrontend;

import io.project.app.javafrontend.redis.RedisRepository;
import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author armena
 */
@Named(value = "redisBean")
@ViewScoped
public class RedisBean implements Serializable {

    @Inject
    private RedisRepository redisRepository;

    private String message;

    private String message2;

    private String token;

    private String token2;

    public RedisBean() {
    }
    
    

    public void saveMessage() {
        try{
            token = UUID.randomUUID().toString().replace("-", "");
        
        redisRepository.set(token, message);
        
        System.out.println("token after save " + token);
        }catch(Exception e){
            e.printStackTrace();
        }
        

    }

    public void findMessage() {
        Optional<String> get = redisRepository.get(token2);
        
        if (get.isPresent()) {
            System.out.println("Present");
            message2 = get.get();
        }

        if (!get.isPresent()) {
            System.out.println("!!!Present");
            message2 = "Your message removed from database";
        }

    }

    public String getToken2() {
        return token2;
    }

    public void setToken2(String token2) {
        this.token2 = token2;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
