package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.dto.ActorDto;
import com.gov.iti.sakila.mappers.ActorMapper;
import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.entities.Actor;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActorDao extends GenericDao<Actor> {


    private ActorMapper actorMapper = Mappers.getMapper(ActorMapper.class);
    public ActorDao() {
        super(Actor.class);
    }


    public Optional<ActorDto> getActorById(int id) {
        Optional<Actor> actorOptional = super.getById(id);
        return actorOptional.map(actorMapper::actorToActorDto);

    }

    public void save(Actor actor) {
        save(actor);
    }

    public void update(Actor actor) {
        update(actor);
    }

    public void delete(Actor actor) {
        delete(actor);
    }

    public List<ActorDto> getAllActors() {
        return getAll().stream()
                .map(actorMapper::actorToActorDto)
                .collect(Collectors.toList());
    }
}


