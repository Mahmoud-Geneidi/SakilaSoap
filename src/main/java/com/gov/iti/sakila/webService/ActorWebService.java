package com.gov.iti.sakila.webService;

import com.gov.iti.sakila.Services.ActorServices;
import com.gov.iti.sakila.dto.ActorDto;
import com.gov.iti.sakila.persistence.JPAUtil;
import com.gov.iti.sakila.persistence.entities.Actor;
import com.gov.iti.sakila.utils.ActorList;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;


import java.util.ArrayList;
import java.util.Optional;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ActorWebService {

    private ActorServices actorServices = new ActorServices();

    @WebMethod(operationName = "getActorById")
    public ActorDto getActorById(@WebParam(name = "id") int id) {
        Optional<ActorDto> optionalActorDto = actorServices.getActorById(id);
        return optionalActorDto.orElse(null); // Return the ActorDto or null if it doesn't exist
    }

    @WebMethod(operationName = "saveActor")
    public boolean saveActor(@WebParam(name = "actor") Actor actor) {
        if (actor == null)
            return false;
        actorServices.saveActor(actor);
        return true;
    }

    @WebMethod(operationName = "updateActor")
    public void updateActor(@WebParam(name = "actor") Actor actor) {
        actorServices.updateActor(actor);
    }

    @WebMethod(operationName = "deleteActor")
    public void deleteActor(@WebParam(name = "actor") Actor actor) {
        actorServices.deleteActor(actor);
    }

    @WebMethod(operationName = "getAllActors")
    public ActorList getAllActors() {
        return new ActorList((ArrayList<ActorDto>) actorServices.getAllActors());
    }

    @WebMethod(operationName = "getAllActorsByLimit")
    public ActorList getAllActorsByLimit(@WebParam(name = "start") int start, @WebParam(name = "limit") int limit) {
        return new ActorList((ArrayList<ActorDto>) actorServices.getAllActorsByLimit(start, limit));
    }

    @WebMethod(operationName = "deleteActorById")
    public boolean deleteActorById(@WebParam(name = "id") int id) {
        Optional<ActorDto> optionalActorDto = actorServices.getActorById(id);
        if (optionalActorDto.isPresent()) {
            actorServices.deleteActorById(id);
            return true;
        }
        return false;
    }
}
