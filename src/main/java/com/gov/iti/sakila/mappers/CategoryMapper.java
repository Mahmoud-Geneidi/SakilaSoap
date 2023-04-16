package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.dto.CategoryDto;
import com.gov.iti.sakila.persistence.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;

@Mapper
public interface CategoryMapper {


    @Mapping(source = "categoryId" , target ="categoryId")
    @Mapping(source = "name" , target ="name")
    @Mapping(source = "lastUpdate" , target ="lastUpdate")

    CategoryDto categoryToCategoryDto(Category category);


    @Mapping(source = "categoryId" , target ="categoryId")
    @Mapping(source = "name" , target ="name")
    @Mapping(source = "lastUpdate" , target ="lastUpdate")
    Category categoryDtoToCategory(CategoryDto category);
}
