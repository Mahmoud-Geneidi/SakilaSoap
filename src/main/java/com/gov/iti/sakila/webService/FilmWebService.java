package com.gov.iti.sakila.webService;

import com.gov.iti.sakila.dto.FilmDto;
import com.gov.iti.sakila.persistence.dao.FilmDao;
import com.gov.iti.sakila.persistence.entities.Film;
import com.gov.iti.sakila.utils.FilmList;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.ArrayList;
import java.util.Optional;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class FilmWebService {

    private FilmDao filmDao = new FilmDao();

    @WebMethod(operationName = "getFilmById")
    public FilmDto getFilmById(@WebParam(name = "id") int id) {
        Optional<FilmDto> optionalFilmDto = filmDao.getFilmById(id);
        return optionalFilmDto.orElse(null);
    }

    @WebMethod(operationName = "saveFilm")
    public void saveFilm(@WebParam(name = "film") Film film) {
        filmDao.save(film);
    }

    @WebMethod(operationName = "updateFilm")
    public void updateFilm(@WebParam(name = "film") Film film) {
        filmDao.update(film);
    }

    @WebMethod(operationName = "deleteFilm")
    public void deleteFilm(@WebParam(name = "film") Film film) {
        filmDao.delete(film);
    }

    @WebMethod(operationName = "getAllFilms")
    public FilmList getAllFilms() {
        return new FilmList((ArrayList<FilmDto>) filmDao.getAllFilms());
    }

    @WebMethod(operationName = "getAllFilmsByLimit")
    public FilmList getAllFilmsByLimit(@WebParam(name = "start") int start, @WebParam(name = "limit") int limit) {
        return new FilmList((ArrayList<FilmDto>) filmDao.getAllFilmsByLimit(start,limit));
    }
}
