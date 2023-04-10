package com.gov.iti.sakila.webService;

import com.gov.iti.sakila.dto.ActorDto;
import com.gov.iti.sakila.persistence.dao.ActorDao;
import com.gov.iti.sakila.persistence.entities.Actor;
import com.gov.iti.sakila.utils.ActorList;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlRootElement;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ActorWebService {

    private ActorDao actorDao = new ActorDao();

    @WebMethod(operationName = "getActorById")
    public ActorDto getActorById(@WebParam(name = "id") int id) {
        Optional<ActorDto> optionalActorDto = actorDao.getActorById(id);
        return optionalActorDto.orElse(null); // Return the ActorDto or null if it doesn't exist
    }

    @WebMethod(operationName = "saveActor")
    public boolean saveActor(@WebParam(name = "actor") Actor actor) {
        if (actor == null)
            return false;
        actorDao.save(actor);
        return true;
    }

    @WebMethod(operationName = "updateActor")
    public void updateActor(@WebParam(name = "actor") Actor actor) {
        actorDao.update(actor);
    }

    @WebMethod(operationName = "deleteActor")
    public void deleteActor(@WebParam(name = "actor") Actor actor) {
        actorDao.delete(actor);
    }

    @WebMethod(operationName = "getAllActors")
    public ActorList getAllActors() {
        return new ActorList((ArrayList<ActorDto>) actorDao.getAllActors());
    }

    @WebMethod(operationName = "getAllActorsByLimit")
    public ActorList getAllActorsByLimit(@WebParam(name = "start") int start, @WebParam(name = "limit") int limit) {
        return new ActorList((ArrayList<ActorDto>) actorDao.getAllActorsByLimit(start, limit));
    }

    @WebMethod(operationName = "deleteActorById")
    public boolean deleteActorById(@WebParam(name = "id") int id) {
        Optional<ActorDto> optionalActorDto = actorDao.getActorById(id);
        if (optionalActorDto.isPresent()) {
            Actor actor = actorDao.getById(id).get();
            actorDao.delete(actor);
            return true;
        }
        return false;
    }
}
