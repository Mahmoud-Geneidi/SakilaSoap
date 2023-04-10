package com.gov.iti.sakila.webService;


import com.gov.iti.sakila.dto.LanguageDto;
import com.gov.iti.sakila.persistence.dao.LanguageDao;

import com.gov.iti.sakila.persistence.entities.Language;


import com.gov.iti.sakila.utils.LanguageList;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.ArrayList;
import java.util.Optional;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class LanguageWebService {

    private LanguageDao languageDao = new LanguageDao();

    @WebMethod(operationName = "getLanguageById")
    public LanguageDto getLanguageById(@WebParam(name = "id") int id) {
        Optional<LanguageDto> optionalLanguageDto = languageDao.getLanguageById(id);
        return optionalLanguageDto.orElse(null); // Return the LanguageDto or null if it doesn't exist
    }

    @WebMethod(operationName = "saveLanguage")
    public boolean saveLanguage(@WebParam(name = "language") Language language) {
        if (language == null)
            return false;
        languageDao.save(language);
        return true;
    }

    @WebMethod(operationName = "updateLanguage")
    public void updateLanguage(@WebParam(name = "language") Language language) {
        languageDao.update(language);
    }

    @WebMethod(operationName = "deleteLanguage")
    public void deleteLanguage(@WebParam(name = "language") Language language) {
        languageDao.delete(language);
    }

    @WebMethod(operationName = "getAllLanguages")
    public LanguageList getAllLanguages() {
        return new LanguageList((ArrayList<LanguageDto>) languageDao.getAllLanguages());
    }

    @WebMethod(operationName = "getAllLanguagesByLimit")
    public LanguageList getAllLanguagesByLimit(@WebParam(name = "start") int start, @WebParam(name = "limit") int limit) {
        return new LanguageList((ArrayList<LanguageDto>) languageDao.getAllLanguagesByLimit(start, limit));
    }

    @WebMethod(operationName = "deleteLanguageById")
    public boolean deleteLanguageById(@WebParam(name = "id") int id) {
        Optional<LanguageDto> languageDto = languageDao.getLanguageById(id);
        if (languageDto.isPresent()) {
            Language language = (Language) languageDao.getById(id).get();
            languageDao.delete(language);
            return true;
        }
        return false;
    }
}
