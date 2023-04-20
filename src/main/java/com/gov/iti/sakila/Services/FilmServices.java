package com.gov.iti.sakila.Services;

import com.gov.iti.sakila.dto.FilmDto;
import com.gov.iti.sakila.persistence.JPAUtil;
import com.gov.iti.sakila.persistence.dao.CityDao;
import com.gov.iti.sakila.persistence.dao.FilmDao;
import com.gov.iti.sakila.persistence.entities.Film;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class FilmServices {

    private final FilmDao filmDao;
    private EntityManager entityManager;


    public FilmServices() {
        this.filmDao = new FilmDao();
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Optional<FilmDto> getFilmById(int id) {
        return filmDao.getFilmById(id,entityManager);
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
        filmDao.deleteById(id,entityManager);
    }

}
