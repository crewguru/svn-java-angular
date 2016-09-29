/*
 * Created on 10 Aug 2016 ( Time 19:37:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.crewguru.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "USER"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="USER", catalog="crewguru" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="UserEntity.countAll", query="SELECT COUNT(x) FROM UserEntity x" )
} )
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="user_id", nullable=false, length=50)
    private String     userId       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="password", nullable=false, length=15)
    private String     password     ;

    @Column(name="firstname", length=50)
    private String     firstname    ;

    @Column(name="lastname", length=50)
    private String     lastname     ;

    @Column(name="email_id", nullable=false, length=100)
    private String     emailId      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
  

    @OneToMany(mappedBy="user", targetEntity=UserProjectsEntity.class, cascade = CascadeType.ALL)
    private List<UserProjectsEntity> listOfUserProjects;

    @OneToMany(mappedBy="user", targetEntity=UserProfileEntity.class, cascade = CascadeType.ALL)
    private List<UserProfileEntity> listOfUserProfile;

    @OneToMany(mappedBy="user", targetEntity=WorkExperienceEntity.class, cascade = CascadeType.ALL)
    private List<WorkExperienceEntity> listOfWorkExperience;

    @OneToMany(mappedBy="user", targetEntity=LocationEntity.class, cascade = CascadeType.ALL)
    private List<LocationEntity> listOfLocation;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UserEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUserId( String userId ) {
        this.userId = userId ;
    }
    public String getUserId() {
        return this.userId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : password ( VARCHAR ) 
    public void setPassword( String password ) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    //--- DATABASE MAPPING : firstname ( VARCHAR ) 
    public void setFirstname( String firstname ) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return this.firstname;
    }

    //--- DATABASE MAPPING : lastname ( VARCHAR ) 
    public void setLastname( String lastname ) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return this.lastname;
    }

    //--- DATABASE MAPPING : email_id ( VARCHAR ) 
    public void setEmailId( String emailId ) {
        this.emailId = emailId;
    }
    public String getEmailId() {
        return this.emailId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
   

    public void setListOfUserProjects( List<UserProjectsEntity> listOfUserProjects ) {
        this.listOfUserProjects = listOfUserProjects;
    }
    public List<UserProjectsEntity> getListOfUserProjects() {
        return this.listOfUserProjects;
    }

    public void setListOfUserProfile( List<UserProfileEntity> listOfUserProfile ) {
        this.listOfUserProfile = listOfUserProfile;
    }
    public List<UserProfileEntity> getListOfUserProfile() {
        return this.listOfUserProfile;
    }

    public void setListOfWorkExperience( List<WorkExperienceEntity> listOfWorkExperience ) {
        this.listOfWorkExperience = listOfWorkExperience;
    }
    public List<WorkExperienceEntity> getListOfWorkExperience() {
        return this.listOfWorkExperience;
    }

    public void setListOfLocation( List<LocationEntity> listOfLocation ) {
        this.listOfLocation = listOfLocation;
    }
    public List<LocationEntity> getListOfLocation() {
        return this.listOfLocation;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(userId);
        sb.append("]:"); 
        sb.append(password);
        sb.append("|");
        sb.append(firstname);
        sb.append("|");
        sb.append(lastname);
        sb.append("|");
        sb.append(emailId);
        return sb.toString(); 
    } 

}