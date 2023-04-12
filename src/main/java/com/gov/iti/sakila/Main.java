package com.gov.iti.sakila;

import com.gov.iti.sakila.Services.FilmServices;
import com.gov.iti.sakila.Services.LanguageServices;
import com.gov.iti.sakila.dto.ActorDto;
import com.gov.iti.sakila.dto.FilmDto;
import com.gov.iti.sakila.dto.LanguageDto;
import com.gov.iti.sakila.mappers.FilmMapper;
import com.gov.iti.sakila.persistence.dao.ActorDao;
import com.gov.iti.sakila.persistence.dao.FilmDao;
import com.gov.iti.sakila.persistence.dao.LanguageDao;
import com.gov.iti.sakila.persistence.entities.Actor;
import com.gov.iti.sakila.persistence.entities.Film;
import com.gov.iti.sakila.persistence.entities.Language;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Language language = new Language("g",new Date(System.currentTimeMillis()));
        // Create a new Language object// Set the language ID
        FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
        FilmDto film = new FilmDto();
        film.setLanguageByLanguageId(language);
        film.setTitle("Dummy Film");
        film.setDescription("This is a dummy film.");
        film.setReleaseYear(2023);
        film.setRentalDuration((byte) 7);
        film.setRentalRate(BigDecimal.valueOf(2.99));
        film.setLength((short) 120);
        film.setReplacementCost(BigDecimal.valueOf(19.99));
        film.setRating("PG");
        film.setSpecialFeatures("Deleted Scenes");
        film.setLastUpdate(new Date());

        FilmServices filmServices = new FilmServices();
        filmServices.save(filmMapper.filmDtoToFilm(film));
    }
}
