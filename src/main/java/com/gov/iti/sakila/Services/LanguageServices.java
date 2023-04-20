package com.gov.iti.sakila.Services;

import com.gov.iti.sakila.dto.LanguageDto;
import com.gov.iti.sakila.persistence.JPAUtil;
import com.gov.iti.sakila.persistence.dao.LanguageDao;
import com.gov.iti.sakila.persistence.entities.Language;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class LanguageServices {
    private LanguageDao languageDao;
    private EntityManager entityManager;

    public LanguageServices() {
        this.languageDao = new LanguageDao();
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Optional<LanguageDto> getLanguageById(short id) {
        return languageDao.getLanguageById(id,entityManager);
    }

    public List<LanguageDto> getAllLanguages() {
        return languageDao.getAllLanguages();
    }

    public List<LanguageDto> getAllLanguagesByLimit(int start, int limit) {
        return languageDao.getAllLanguagesByLimit(start, limit);
    }

    public void saveLanguage(Language languageDto) {
        languageDao.save(languageDto);
    }

    public void deleteLanguage(LanguageDto languageDto) {
        languageDao.delete(languageDto);
    }

    public void deleteLanguageById(int id) {
        languageDao.deleteById(id,entityManager);
    }

    public void updateLanguage(LanguageDto languageDto) {
        languageDao.update(languageDto);
    }
}
