package com.gov.iti.sakila.persistence.entities;// default package
// Generated Apr 7, 2023, 4:05:26 PM by Hibernate Tools 6.1.7.Final


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Timestamp;

/**
 * FilmActor generated by hbm2java
 */
@Entity
@Table(name="film_actor"
    ,catalog="sakila"
)
public class FilmActor  implements java.io.Serializable {


     private FilmActorId id;
     private Film film;
     private Actor actor;
     private Timestamp lastUpdate;

    public FilmActor() {
    }

    public FilmActor(FilmActorId id, Film film, Actor actor, Timestamp lastUpdate) {
       this.id = id;
       this.film = film;
       this.actor = actor;
       this.lastUpdate = lastUpdate;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="actorId", column=@Column(name="actor_id", nullable=false) ), 
        @AttributeOverride(name="filmId", column=@Column(name="film_id", nullable=false) ) } )
    public FilmActorId getId() {
        return this.id;
    }
    
    public void setId(FilmActorId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="film_id", nullable=false, insertable=false, updatable=false)
    public Film getFilm() {
        return this.film;
    }
    
    public void setFilm(Film film) {
        this.film = film;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="actor_id", nullable=false, insertable=false, updatable=false)
    public Actor getActor() {
        return this.actor;
    }
    
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }




}


