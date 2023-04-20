package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.dto.CategoryDto;
import com.gov.iti.sakila.mappers.CategoryMapper;
import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.JPAUtil;
import com.gov.iti.sakila.persistence.entities.Category;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryDao extends GenericDao<Category> {

    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    public CategoryDao(Class<Category> entityClass) {
        super(entityClass);
    }

    public CategoryDao() {
        super(Category.class);
    }

    public Optional<CategoryDto> getCategoryById(int id,EntityManager entityManager) {
        Optional<Category> categoryOptional = super.getById( id, entityManager);
        return categoryOptional.map(categoryMapper::categoryToCategoryDto);
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = super.getAll();
        return categories.stream().map(categoryMapper::categoryToCategoryDto).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<CategoryDto> getAllByLimit(int start, int limit) {
        List<Category> categories = getAll();
        int endIndex = Math.min(start + limit, categories.size());
        return categories.subList(start, endIndex).stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void save(CategoryDto category) {
        super.save(categoryMapper.categoryDtoToCategory(category));
    }

    public void update(CategoryDto category) {
        super.update(categoryMapper.categoryDtoToCategory(category));
    }

    public void delete(CategoryDto category) {
        super.delete(categoryMapper.categoryDtoToCategory(category));
    }

    public void deleteById(int id, EntityManager em) {
        Optional<Category> categoryOptional = getById(id,em);
        categoryOptional.ifPresent(category -> Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
        }));
    }
}
