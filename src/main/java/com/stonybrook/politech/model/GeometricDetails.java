package com.stonybrook.politech.model;

import org.locationtech.jts.geom.Geometry;

import java.util.Set;

public class GeometricDetails {
    private String ID;
    private String geometryJSON;
    private String originalDistrictID;
    private int population;
    private int gop_vote;
    private int dem_vote;

    public GeometricDetails(String ID, String geometryJSON, String originalDistrictID,
                            int population, int gop_vote, int dem_vote) {
        this.ID = ID;
        this.geometryJSON = geometryJSON;
        this.originalDistrictID = originalDistrictID;
        this.population = population;
        this.gop_vote = gop_vote;
        this.dem_vote = dem_vote;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setGeometryJSON(String geometryJSON) {
        this.geometryJSON = geometryJSON;
    }

    public void setOriginalDistrictID(String originalDistrictID) {
        this.originalDistrictID = originalDistrictID;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setGop_vote(int gop_vote) {
        this.gop_vote = gop_vote;
    }

    public void setDem_vote(int dem_vote) {
        this.dem_vote = dem_vote;
    }

    public String getGeometryJSON() {
        return geometryJSON;
    }

    public String getOriginalDistrictID() {
        return originalDistrictID;
    }

    public int getPopulation() {
        return population;
    }

    public int getGop_vote() {
        return gop_vote;
    }

    public int getDem_vote() {
        return dem_vote;
    }
}
