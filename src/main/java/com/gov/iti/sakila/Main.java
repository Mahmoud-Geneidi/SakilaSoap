package com.gov.iti.sakila;

import com.gov.iti.sakila.Services.CategoryServices;
import com.gov.iti.sakila.Services.CityServices;
import com.gov.iti.sakila.dto.CategoryDto;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CityServices cityServices = new CityServices();
        System.out.println(cityServices.getCityById((short) 602));
    }
}
