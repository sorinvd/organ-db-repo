package com.itschool.organdb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "organ_table")
public class OrganEntry {

    // --------- attributes of the class ----
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entry_id;

    private String manufacturer;
    private String geogLocation;
    private Integer constrYear;
    private Integer nrRegisters;
    private Integer nrManuals;


    //----- Constructor of the class OrganEntry
    protected OrganEntry(){
        // Hibernate needs a constructor without any arguments
        //can also be "protected", not necessarily public
    }

    public OrganEntry(String providedManufacturer, String providedGeogLoc,
                      Integer providedConstrYear, Integer providedNrRegisters,
                      Integer providedNrManuals)
    {
        this.manufacturer = providedManufacturer;
        this.geogLocation = providedGeogLoc;
        this.constrYear = providedConstrYear;
        this.nrRegisters = providedNrRegisters;
        this.nrManuals = providedNrManuals;

        //the ID is not needed -- it will be automatically managed
    }

    //---- getters & setters

    public long getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(long entry_id) {
        this.entry_id = entry_id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getGeogLocation() {
        return geogLocation;
    }

    public void setGeogLocation(String geogLocation) {
        this.geogLocation = geogLocation;
    }

    public Integer getConstrYear() {
        return constrYear;
    }

    public void setConstrYear(Integer constrYear) {
        this.constrYear = constrYear;
    }

    public Integer getNrRegisters() {
        return nrRegisters;
    }

    public void setNrRegisters(Integer nrRegisters) {
        this.nrRegisters = nrRegisters;
    }

    public Integer getNrManuals() {
        return nrManuals;
    }

    public void setNrManuals(Integer nrManuals) {
        this.nrManuals = nrManuals;
    }
}
