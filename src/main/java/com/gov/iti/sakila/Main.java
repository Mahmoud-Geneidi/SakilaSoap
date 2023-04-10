package com.gov.iti.sakila;

import com.gov.iti.sakila.dto.ActorDto;
import com.gov.iti.sakila.dto.FilmDto;
import com.gov.iti.sakila.persistence.dao.ActorDao;
import com.gov.iti.sakila.persistence.dao.FilmDao;
import com.gov.iti.sakila.persistence.dao.LanguageDao;
import com.gov.iti.sakila.persistence.entities.Actor;
import com.gov.iti.sakila.persistence.entities.Film;
import com.gov.iti.sakila.persistence.entities.Language;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Language language= new Language("Arabic",new Date(System.currentTimeMillis()));

        LanguageDao languageDao = new LanguageDao();
        System.out.println(languageDao.getAll());


    }
}
