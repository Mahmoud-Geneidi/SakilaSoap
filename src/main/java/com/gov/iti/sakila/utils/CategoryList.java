package com.gov.iti.sakila.utils;

import com.gov.iti.sakila.dto.CategoryDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class CategoryList {


    private ArrayList<CategoryDto> categories;


    public CategoryList(ArrayList<CategoryDto> categories) {
        this.categories = categories;
    }

    public CategoryList() {
    }

    @XmlElement(name = "category")
    public ArrayList<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryDto> categories) {
        this.categories = categories;
    }
}


