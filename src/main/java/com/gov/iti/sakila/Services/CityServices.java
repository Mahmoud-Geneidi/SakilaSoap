package com.gov.iti.sakila.Services;


import com.gov.iti.sakila.dto.CityDto;

import com.gov.iti.sakila.persistence.dao.CityDao;


import java.util.List;
import java.util.Optional;

public class CityServices {

    private final CityDao cityDao;

    public CityServices() {
        this.cityDao = new CityDao();
    }

    public Optional<CityDto> getCityById(Short id) {
        return cityDao.getCityById(id);
    }

    public void saveCity(CityDto cityDto) {
        cityDao.save(cityDto);
    }

    public void updateCity(CityDto cityDto) {
        cityDao.update(cityDto);
    }

    public void deleteCity(CityDto cityDto) {
        cityDao.delete(cityDto);
    }


    public List<CityDto> getAllCities() {
        return cityDao.getAllCities();
    }

    public List<CityDto> getAllCitiesByLimit(int start, int limit) {
        return cityDao.getAllCitiesByLimit(start, limit);
    }

    public void deleteCityById(Short id) {
        cityDao.deleteById(id);
    }
}
