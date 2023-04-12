package com.gov.iti.sakila.Services;

import com.gov.iti.sakila.dto.FilmDto;
import com.gov.iti.sakila.persistence.dao.FilmDao;
import com.gov.iti.sakila.persistence.entities.Film;

import java.util.List;
import java.util.Optional;

public class FilmServices {

    private final FilmDao filmDao;

    public FilmServices() {
        this.filmDao = new FilmDao();
    }

    public Optional<FilmDto> getFilmById(int id) {
        return filmDao.getFilmById(id);
    }

    public void save(Film film) {
        filmDao.save(film);
    }

    public void update(Film film) {
        filmDao.update(film);
    }

    public void delete(FilmDto film) {
        filmDao.delete(film);
    }

    public List<FilmDto> getAllFilms() {
        return filmDao.getAllFilms();
    }

    public List<FilmDto> getAllFilmsByLimit(int start, int limit) {
        return filmDao.getAllFilmsByLimit(start, limit);
    }

    public void deleteById(int id) {
        filmDao.deleteById(id);
    }

}
