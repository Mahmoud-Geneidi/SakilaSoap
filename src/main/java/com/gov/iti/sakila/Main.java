package com.gov.iti.sakila;

import com.gov.iti.sakila.dto.ActorDto;
import com.gov.iti.sakila.persistence.dao.ActorDao;
import com.gov.iti.sakila.persistence.entities.Actor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ActorDao actorDao = new ActorDao();
        List<ActorDto> actors = actorDao.getAllActors();
        for(int i =0; i<10; i++){
            System.out.println(actors.get(i).toString());
        }
    }
}
