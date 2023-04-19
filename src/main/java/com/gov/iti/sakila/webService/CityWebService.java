package com.gov.iti.sakila.webService;

import com.gov.iti.sakila.Services.CityServices;
import com.gov.iti.sakila.dto.CityDto;
import com.gov.iti.sakila.persistence.dao.CityDao;
import com.gov.iti.sakila.persistence.entities.City;
import com.gov.iti.sakila.utils.CityList;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.ArrayList;
import java.util.Optional;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CityWebService {

    private CityServices cityServices = new CityServices();

    @WebMethod(operationName = "getCityById")
    public CityDto getCityById(@WebParam(name = "id") Short id) {
        Optional<CityDto> optionalCityDto = cityServices.getCityById(id);
        return optionalCityDto.orElse(null); // Return the CityDto or null if it doesn't exist
    }

    @WebMethod(operationName = "saveCity")
    public boolean saveCity(@WebParam(name = "city") CityDto city) {
        if (city == null)
            return false;
        cityServices.saveCity(city);
        return true;
    }

    @WebMethod(operationName = "updateCity")
    public void updateCity(@WebParam(name = "city") CityDto city) {
        cityServices.updateCity(city);
    }


    @WebMethod(operationName = "getAllCities")
    public CityList getAllCities() {
        return new CityList((ArrayList<CityDto>) cityServices.getAllCities());
    }

    @WebMethod(operationName = "getAllCitiesByLimit")
    public CityList getAllCitiesByLimit(@WebParam(name = "start") int start, @WebParam(name = "limit") int limit) {
        return new CityList((ArrayList<CityDto>) cityServices.getAllCitiesByLimit(start, limit));
    }

    @WebMethod(operationName = "deleteCityById")
    public boolean deleteCityById(@WebParam(name = "id") Short id) {
        Optional<CityDto> optionalCityDto = cityServices.getCityById(id);
        if (optionalCityDto.isPresent()) {
            cityServices.deleteCity(optionalCityDto.orElse(null));
            return true;
        }
        return false;
    }
}
