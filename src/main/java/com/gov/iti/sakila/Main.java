package com.gov.iti.sakila;

import com.gov.iti.sakila.dto.ActorDto;
import com.gov.iti.sakila.persistence.dao.ActorDao;
import com.gov.iti.sakila.persistence.dao.FilmDao;
import com.gov.iti.sakila.persistence.entities.Actor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FilmDao filmDao = new FilmDao();
        System.out.println(filmDao.getFilmById(3).toString());
    }
}
