package com.gov.iti.sakila.webService;

import com.gov.iti.sakila.Services.CategoryServices;
import com.gov.iti.sakila.dto.CategoryDto;
import com.gov.iti.sakila.persistence.entities.Category;

import com.gov.iti.sakila.utils.CategoryList;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.ArrayList;
import java.util.Optional;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CategoryWebService {

    private CategoryServices categoryServices = new CategoryServices();

    @WebMethod(operationName = "getCategoryById")
    public CategoryDto getCategoryById(@WebParam(name = "id") short id) {
        Optional<CategoryDto> optionalCategoryDto = categoryServices.getCategoryById(id);
        return optionalCategoryDto.orElse(null); // Return the CategoryDto or null if it doesn't exist
    }

    @WebMethod(operationName = "saveCategory")
    public boolean saveCategory(@WebParam(name = "category") CategoryDto category) {
        if (category == null)
            return false;
        categoryServices.saveCategory(category);
        return true;
    }

    @WebMethod(operationName = "updateCategory")
    public void updateCategory(@WebParam(name = "category") CategoryDto category) {
        categoryServices.updateCategory(category);
    }

    @WebMethod(operationName = "deleteCategory")
    public void deleteCategory(@WebParam(name = "category") CategoryDto category) {
        categoryServices.deleteCategory(category);
    }

    @WebMethod(operationName = "getAllCategories")
    public CategoryList getAllCategories() {
        return new CategoryList((ArrayList<CategoryDto>) categoryServices.getAllCategories());
    }

    @WebMethod(operationName = "getAllCategoriesByLimit")
    public CategoryList getAllCategoriesByLimit(@WebParam(name = "start") int start, @WebParam(name = "limit") int limit) {
        return new CategoryList((ArrayList<CategoryDto>) categoryServices.getAllCategoriesByLimit(start, limit));
    }

    @WebMethod(operationName = "deleteCategoryById")
    public boolean deleteCategoryById(@WebParam(name = "id") byte id) {
        Optional<CategoryDto> optionalCategoryDto = categoryServices.getCategoryById(id);
        if (optionalCategoryDto.isPresent()) {
            Optional<CategoryDto> category = categoryServices.getCategoryById(id);
            categoryServices.deleteCategory(category.orElse(null));
            return true;
        }
        return false;
    }
}
