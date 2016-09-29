/*
 * Created on 10 Aug 2016 ( Time 20:43:40 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.crewguru.bean;

import java.io.Serializable;

import javax.validation.constraints.*;


public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    @Size( min = 1, max = 50 )
    private String userId;

    @Size( max = 11 )
    private String city;

    @Size( max = 11 )
    private String state;

    @Size( max = 11 )
    private String zip;

    @Size( max = 1 )
    private String type;

    @Size( max = 11 )
    private String country;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }

    public Integer getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setUserId( String userId ) {
        this.userId = userId;
    }
    public String getUserId() {
        return this.userId;
    }

    public void setCity( String city ) {
        this.city = city;
    }
    public String getCity() {
        return this.city;
    }

    public void setState( String state ) {
        this.state = state;
    }
    public String getState() {
        return this.state;
    }

    public void setZip( String zip ) {
        this.zip = zip;
    }
    public String getZip() {
        return this.zip;
    }

    public void setType( String type ) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    public void setCountry( String country ) {
        this.country = country;
    }
    public String getCountry() {
        return this.country;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(userId);
        sb.append("|");
        sb.append(city);
        sb.append("|");
        sb.append(state);
        sb.append("|");
        sb.append(zip);
        sb.append("|");
        sb.append(type);
        sb.append("|");
        sb.append(country);
        return sb.toString(); 
    } 


}
