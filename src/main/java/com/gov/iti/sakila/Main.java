package com.gov.iti.sakila;

import com.gov.iti.sakila.Services.CategoryServices;
import com.gov.iti.sakila.dto.CategoryDto;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CategoryServices categoryServices = new CategoryServices();
        System.out.println(categoryServices.getAllCategories());
    }
}
