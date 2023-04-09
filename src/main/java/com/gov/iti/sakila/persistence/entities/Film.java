package com.gov.iti.sakila.persistence.entities;// default package
// Generated Apr 7, 2023, 4:05:26 PM by Hibernate Tools 6.1.7.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Film generated by hbm2java
 */
@Entity
@Table(name="film"
    ,catalog="sakila"
)
@XmlRootElement
public class Film  implements java.io.Serializable {


     private Short filmId;
     private Language languageByLanguageId;
     private Language languageByOriginalLanguageId;
     private String title;
     private String description;
     private Date releaseYear;
     private byte rentalDuration;
     private BigDecimal rentalRate;
     private Short length;
     private BigDecimal replacementCost;
     private String rating;
     private String specialFeatures;
     private Timestamp lastUpdate;
     private Set<Inventory> inventories = new HashSet<Inventory>(0);
     private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);
     private Set<FilmCategory> filmCategories = new HashSet<FilmCategory>(0);

    public Film() {
    }

	
    public Film(Language languageByLanguageId, String title, byte rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost, Timestamp lastUpdate) {
        this.languageByLanguageId = languageByLanguageId;
        this.title = title;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.lastUpdate = lastUpdate;
    }
    public Film(Language languageByLanguageId, Language languageByOriginalLanguageId, String title, String description, Date releaseYear, byte rentalDuration, BigDecimal rentalRate, Short length, BigDecimal replacementCost, String rating, String specialFeatures, Timestamp lastUpdate, Set<Inventory> inventories, Set<FilmActor> filmActors, Set<FilmCategory> filmCategories) {
       this.languageByLanguageId = languageByLanguageId;
       this.languageByOriginalLanguageId = languageByOriginalLanguageId;
       this.title = title;
       this.description = description;
       this.releaseYear = releaseYear;
       this.rentalDuration = rentalDuration;
       this.rentalRate = rentalRate;
       this.length = length;
       this.replacementCost = replacementCost;
       this.rating = rating;
       this.specialFeatures = specialFeatures;
       this.lastUpdate = lastUpdate;
       this.inventories = inventories;
       this.filmActors = filmActors;
       this.filmCategories = filmCategories;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="film_id", unique=true, nullable=false)
    public Short getFilmId() {
        return this.filmId;
    }
    
    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="language_id", nullable=false)
    public Language getLanguageByLanguageId() {
        return this.languageByLanguageId;
    }
    
    public void setLanguageByLanguageId(Language languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="original_language_id")
    public Language getLanguageByOriginalLanguageId() {
        return this.languageByOriginalLanguageId;
    }
    
    public void setLanguageByOriginalLanguageId(Language languageByOriginalLanguageId) {
        this.languageByOriginalLanguageId = languageByOriginalLanguageId;
    }

    
    @Column(name="title", nullable=false, length=128)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="release_year", length=4)
    public Date getReleaseYear() {
        return this.releaseYear;
    }
    
    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    
    @Column(name="rental_duration", nullable=false)
    public byte getRentalDuration() {
        return this.rentalDuration;
    }
    
    public void setRentalDuration(byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    
    @Column(name="rental_rate", nullable=false, precision=4, scale=2)
    public BigDecimal getRentalRate() {
        return this.rentalRate;
    }
    
    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    
    @Column(name="length")
    public Short getLength() {
        return this.length;
    }
    
    public void setLength(Short length) {
        this.length = length;
    }

    
    @Column(name="replacement_cost", nullable=false, precision=5, scale=2)
    public BigDecimal getReplacementCost() {
        return this.replacementCost;
    }
    
    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    
    @Column(name="rating", length=5)
    public String getRating() {
        return this.rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }

    
    @Column(name="special_features", length=54)
    public String getSpecialFeatures() {
        return this.specialFeatures;
    }
    
    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="film")
    public Set<Inventory> getInventories() {
        return this.inventories;
    }
    
    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="film")
    public Set<FilmActor> getFilmActors() {
        return this.filmActors;
    }
    
    public void setFilmActors(Set<FilmActor> filmActors) {
        this.filmActors = filmActors;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="film")
    public Set<FilmCategory> getFilmCategories() {
        return this.filmCategories;
    }
    
    public void setFilmCategories(Set<FilmCategory> filmCategories) {
        this.filmCategories = filmCategories;
    }





}


