/*
 * Created on 10 Aug 2016 ( Time 20:43:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.crewguru.bean;

import java.io.Serializable;

import javax.validation.constraints.*;


public class UserProjects implements Serializable {

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

    @NotNull
    @Size( min = 1, max = 500 )
    private String projctName;

    @Size( max = 3000 )
    private String projectImages;

    @Size( max = 1000 )
    private String projectDescription;

    @Size( max = 3000 )
    private String projectDetails;

    @Size( max = 500 )
    private String projectField;

    @NotNull
    @Size( min = 1, max = 500 )
    private String projectlocation;



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

    public void setProjctName( String projctName ) {
        this.projctName = projctName;
    }
    public String getProjctName() {
        return this.projctName;
    }

    public void setProjectImages( String projectImages ) {
        this.projectImages = projectImages;
    }
    public String getProjectImages() {
        return this.projectImages;
    }

    public void setProjectDescription( String projectDescription ) {
        this.projectDescription = projectDescription;
    }
    public String getProjectDescription() {
        return this.projectDescription;
    }

    public void setProjectDetails( String projectDetails ) {
        this.projectDetails = projectDetails;
    }
    public String getProjectDetails() {
        return this.projectDetails;
    }

    public void setProjectField( String projectField ) {
        this.projectField = projectField;
    }
    public String getProjectField() {
        return this.projectField;
    }

    public void setProjectlocation( String projectlocation ) {
        this.projectlocation = projectlocation;
    }
    public String getProjectlocation() {
        return this.projectlocation;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(userId);
        sb.append("|");
        sb.append(projctName);
        sb.append("|");
        sb.append(projectImages);
        sb.append("|");
        sb.append(projectDescription);
        sb.append("|");
        sb.append(projectDetails);
        sb.append("|");
        sb.append(projectField);
        sb.append("|");
        sb.append(projectlocation);
        sb.append("|");
        sb.append(id);
        return sb.toString(); 
    } 


}
