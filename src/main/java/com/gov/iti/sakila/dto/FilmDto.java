package com.gov.iti.sakila.dto;

import com.gov.iti.sakila.persistence.entities.Language;

import java.math.BigDecimal;
import java.util.Date;


public class FilmDto {

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
    private Date lastUpdate;

    public FilmDto(Short filmId, Language languageByLanguageId, Language languageByOriginalLanguageId, String title, String description,
                   Date releaseYear, byte rentalDuration, BigDecimal rentalRate, Short length, BigDecimal replacementCost,
                   String rating, String specialFeatures, Date lastUpdate) {
        this.filmId = filmId;
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
    }

    public FilmDto() {
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public Language getLanguageByLanguageId() {
        return languageByLanguageId;
    }

    public void setLanguageByLanguageId(Language languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }

    public Language getLanguageByOriginalLanguageId() {
        return languageByOriginalLanguageId;
    }

    public void setLanguageByOriginalLanguageId(Language languageByOriginalLanguageId) {
        this.languageByOriginalLanguageId = languageByOriginalLanguageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public byte getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmDto{" +
                "filmId=" + filmId +
                ", languageByLanguageId=" + languageByLanguageId +
                ", languageByOriginalLanguageId=" + languageByOriginalLanguageId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating='" + rating + '\'' +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
