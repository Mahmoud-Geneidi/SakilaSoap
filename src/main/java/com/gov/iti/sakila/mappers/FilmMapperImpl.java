//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.dto.FilmDto;
import com.gov.iti.sakila.persistence.entities.Film;

public class FilmMapperImpl implements FilmMapper {

    @Override
    public FilmDto filmToFilmDto(Film film) {
        if (film == null) {
            return null;
        } else {
            FilmDto filmDto = new FilmDto();
            filmDto.setFilmId(film.getFilmId());
            filmDto.setTitle(film.getTitle());
            filmDto.setDescription(film.getDescription());
            filmDto.setReleaseYear(film.getReleaseYear());
            filmDto.setRentalDuration(film.getRentalDuration());
            filmDto.setRentalRate(film.getRentalRate());
            filmDto.setLength(film.getLength());
            filmDto.setReplacementCost(film.getReplacementCost());
            filmDto.setRating(film.getRating());
            filmDto.setSpecialFeatures(film.getSpecialFeatures());
            filmDto.setLastUpdate(film.getLastUpdate());
            return filmDto;
        }
    }
}
