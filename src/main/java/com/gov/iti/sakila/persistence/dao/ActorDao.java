package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.entities.Actor;

import java.util.List;
import java.util.Optional;

public class ActorDao extends GenericDao<Actor> {



    public ActorDao() {
        super(Actor.class);
    }


    public Optional<Actor> getById(int id) {
        return getById(id);
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

    public List<Actor> getAllActors() {
        return getAll();
    }
}


