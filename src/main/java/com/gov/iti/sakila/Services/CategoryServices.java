package com.gov.iti.sakila.Services;

import com.gov.iti.sakila.dto.CategoryDto;
import com.gov.iti.sakila.persistence.JPAUtil;
import com.gov.iti.sakila.persistence.dao.CategoryDao;
import com.gov.iti.sakila.persistence.entities.Category;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class CategoryServices {

    private final CategoryDao categoryDao;
    private EntityManager entityManager;


    public CategoryServices() {
        this.categoryDao = new CategoryDao();
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Optional<CategoryDto> getCategoryById(int id) {
        return categoryDao.getCategoryById(id,entityManager);
    }

    public void saveCategory(CategoryDto category) {
        categoryDao.save(category);
    }

    public void updateCategory(CategoryDto category) {
        categoryDao.update(category);
    }

    public void deleteCategory(CategoryDto category) {
        categoryDao.delete(category);
    }

    public List<CategoryDto> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public List<CategoryDto> getAllCategoriesByLimit(int start, int limit) {
        return categoryDao.getAllByLimit(start, limit);
    }

    public void deleteCategoryById(int id) {
        categoryDao.deleteById(id,entityManager);
    }
}
