package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.dto.ActorDto;
import com.gov.iti.sakila.mappers.ActorMapper;
import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.entities.Actor;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
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
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<ActorDto> getAllActorsByLimit(int start, int limit) {
        List<Actor> actors = getAll();
        int endIndex = Math.min(start + limit, actors.size());
        return actors.subList(start, endIndex).stream()
                .map(actorMapper::actorToActorDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}


