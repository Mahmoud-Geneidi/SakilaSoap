package com.gov.iti.sakila.persistence.entities;// default package
// Generated Apr 7, 2023, 4:05:26 PM by Hibernate Tools 6.1.7.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Language generated by hbm2java
 */
@Entity
@Table(name="language"
    ,catalog="sakila"
)
public class Language  implements java.io.Serializable {


     private Byte languageId;
     private String name;
     private Timestamp lastUpdate;
     private Set<Film> filmsForLanguageId = new HashSet<Film>(0);
     private Set<Film> filmsForOriginalLanguageId = new HashSet<Film>(0);

    public Language() {
    }

	
    public Language(String name, Timestamp lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
    public Language(String name, Timestamp lastUpdate, Set<Film> filmsForLanguageId, Set<Film> filmsForOriginalLanguageId) {
       this.name = name;
       this.lastUpdate = lastUpdate;
       this.filmsForLanguageId = filmsForLanguageId;
       this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="language_id", unique=true, nullable=false)
    public Byte getLanguageId() {
        return this.languageId;
    }
    
    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    
    @Column(name="name", nullable=false, length=20)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="languageByLanguageId")
    public Set<Film> getFilmsForLanguageId() {
        return this.filmsForLanguageId;
    }
    
    public void setFilmsForLanguageId(Set<Film> filmsForLanguageId) {
        this.filmsForLanguageId = filmsForLanguageId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="languageByOriginalLanguageId")
    public Set<Film> getFilmsForOriginalLanguageId() {
        return this.filmsForOriginalLanguageId;
    }
    
    public void setFilmsForOriginalLanguageId(Set<Film> filmsForOriginalLanguageId) {
        this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
    }




}


