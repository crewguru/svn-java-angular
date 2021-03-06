/*
 * Created on 10 Aug 2016 ( Time 19:37:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.crewguru.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "USER_PROJECTS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="USER_PROJECTS", catalog="crewguru" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="UserProjectsEntity.countAll", query="SELECT COUNT(x) FROM UserProjectsEntity x" )
} )
public class UserProjectsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="projct_name", nullable=false, length=500)
    private String     projctName   ;

    @Column(name="project_images", length=3000)
    private String     projectImages ;

    @Column(name="project_description", length=1000)
    private String     projectDescription ;

    @Column(name="project_details", length=3000)
    private String     projectDetails ;

    @Column(name="project_field", length=500)
    private String     projectField ;

    @Column(name="projectlocation", nullable=false, length=500)
    private String     projectlocation ;

	// "userId" (column "user_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="user_id")
    private UserEntity user        ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UserProjectsEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : projct_name ( VARCHAR ) 
    public void setProjctName( String projctName ) {
        this.projctName = projctName;
    }
    public String getProjctName() {
        return this.projctName;
    }

    //--- DATABASE MAPPING : project_images ( VARCHAR ) 
    public void setProjectImages( String projectImages ) {
        this.projectImages = projectImages;
    }
    public String getProjectImages() {
        return this.projectImages;
    }

    //--- DATABASE MAPPING : project_description ( VARCHAR ) 
    public void setProjectDescription( String projectDescription ) {
        this.projectDescription = projectDescription;
    }
    public String getProjectDescription() {
        return this.projectDescription;
    }

    //--- DATABASE MAPPING : project_details ( VARCHAR ) 
    public void setProjectDetails( String projectDetails ) {
        this.projectDetails = projectDetails;
    }
    public String getProjectDetails() {
        return this.projectDetails;
    }

    //--- DATABASE MAPPING : project_field ( VARCHAR ) 
    public void setProjectField( String projectField ) {
        this.projectField = projectField;
    }
    public String getProjectField() {
        return this.projectField;
    }

    //--- DATABASE MAPPING : projectlocation ( VARCHAR ) 
    public void setProjectlocation( String projectlocation ) {
        this.projectlocation = projectlocation;
    }
    public String getProjectlocation() {
        return this.projectlocation;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setUser( UserEntity user ) {
        this.user = user;
    }
    public UserEntity getUser() {
        return this.user;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
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
        return sb.toString(); 
    } 

}
