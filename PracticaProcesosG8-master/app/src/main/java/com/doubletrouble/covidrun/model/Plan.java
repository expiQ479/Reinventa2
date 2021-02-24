package com.doubletrouble.covidrun.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "planes", indices = {@Index(value = {"id"}, unique = true)})
public class Plan {

    @PrimaryKey(autoGenerate = true)
    public int id;
    String shortName;
    String description;
    double experiencePoints;
    double expectedHours;
    double rating;

    // Constructor para Utils
    public Plan(String shortName, String description, double experiencePoints, double expectedHours, double rating) {
        // Id will be introduced from db when saving
        this.shortName = shortName;
        this.description = description;
        this.experiencePoints = experiencePoints;
        this.expectedHours = expectedHours;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(double experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public double getExpectedHours() {
        return expectedHours;
    }

    public void setExpectedHours(double expectedHours) {
        this.expectedHours = expectedHours;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
