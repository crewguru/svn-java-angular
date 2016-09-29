/*
 * Created on 11 Aug 2016 ( Time 20:25:40 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.crewguru.bean.jpa;

import java.io.Serializable;
import java.math.BigInteger;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "USER_PROFILE"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="USER_PROFILE", catalog="crewguru" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="UserProfileEntity.countAll", query="SELECT COUNT(x) FROM UserProfileEntity x" )
} )
public class UserProfileEntity implements Serializable {

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
    @Column(name="profession", nullable=false, length=500)
    private String     profession   ;

    @Column(name="profile_image", length=1000)
    private String     profileImage ;
    
    @Column(name="background_image", length=1000)
    private String     backgroundImage ;

	@Column(name="profilename", nullable=true, length=500)
    private String     profilename  ;

    @Column(name="profiledescription", nullable=true, length=4000)
    private String     profiledescription ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false, nullable=false)
    private Date       createdDate  ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false, nullable=false)
    private Date       updatedDate  ;

    @Column(name="twitter_link", length=500)
    private String     twitterLink  ;

    @Column(name="facebook_link", length=500)
    private String     facebookLink ;

    @Column(name="instagram_link", length=500)
    private String     instagramLink ;

    @Column(name="linkedin_link", length=500)
    private String     linkedinLink ;

    @Column(name="about_me", length=3000)
    private String     aboutMe      ;

    @Column(name="availability_hire")
    private Boolean    availabilityHire ;

    @Column(name="website", length=150)
    private String     website      ;

    @Column(name="skills", length=2000)
    private String     skills       ;

    @Column(name="phonenumber")
    private BigInteger    phonenumber  ;

    @Column(name="phoneext")
    private Integer    phoneext     ;
    
    @Column(name="industry", length=500)
    private String     industry  ;
    
    @Column(name="work_category", length=500)
    private String     workCategory  ;

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
    public UserProfileEntity() {
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
    
    
    
    //--- DATABASE MAPPING : profession ( VARCHAR ) 
    public void setProfession( String profession ) {
        this.profession = profession;
    }
    public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getWorkCategory() {
		return workCategory;
	}

	public void setWorkCategory(String workCategory) {
		this.workCategory = workCategory;
	}

	public String getProfession() {
        return this.profession;
    }

    //--- DATABASE MAPPING : profile_image ( VARCHAR ) 
    public void setProfileImage( String profileImage ) {
        this.profileImage = profileImage;
    }
    public String getProfileImage() {
        return this.profileImage;
    }
    
    //--- DATABASE MAPPING : background_image ( VARCHAR )
    
    public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

    //--- DATABASE MAPPING : profilename ( VARCHAR ) 
    public void setProfilename( String profilename ) {
        this.profilename = profilename;
    }
    public String getProfilename() {
        return this.profilename;
    }

    //--- DATABASE MAPPING : profiledescription ( VARCHAR ) 
    public void setProfiledescription( String profiledescription ) {
        this.profiledescription = profiledescription;
    }
    public String getProfiledescription() {
        return this.profiledescription;
    }

    //--- DATABASE MAPPING : created_date ( DATETIME ) 
    public void setCreatedDate( Date createdDate ) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }

    //--- DATABASE MAPPING : updated_date ( DATETIME ) 
    public void setUpdatedDate( Date updatedDate ) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    //--- DATABASE MAPPING : twitter_link ( VARCHAR ) 
    public void setTwitterLink( String twitterLink ) {
        this.twitterLink = twitterLink;
    }
    public String getTwitterLink() {
        return this.twitterLink;
    }

    //--- DATABASE MAPPING : facebook_link ( VARCHAR ) 
    public void setFacebookLink( String facebookLink ) {
        this.facebookLink = facebookLink;
    }
    public String getFacebookLink() {
        return this.facebookLink;
    }

    //--- DATABASE MAPPING : instagram_link ( VARCHAR ) 
    public void setInstagramLink( String instagramLink ) {
        this.instagramLink = instagramLink;
    }
    public String getInstagramLink() {
        return this.instagramLink;
    }

    //--- DATABASE MAPPING : linkedin_link ( VARCHAR ) 
    public void setLinkedinLink( String linkedinLink ) {
        this.linkedinLink = linkedinLink;
    }
    public String getLinkedinLink() {
        return this.linkedinLink;
    }

    //--- DATABASE MAPPING : about_me ( VARCHAR ) 
    public void setAboutMe( String aboutMe ) {
        this.aboutMe = aboutMe;
    }
    public String getAboutMe() {
        return this.aboutMe;
    }

    //--- DATABASE MAPPING : availability_hire ( BIT ) 
    public void setAvailabilityHire( Boolean availabilityHire ) {
        this.availabilityHire = availabilityHire;
    }
    public Boolean getAvailabilityHire() {
        return this.availabilityHire;
    }

    //--- DATABASE MAPPING : website ( VARCHAR ) 
    public void setWebsite( String website ) {
        this.website = website;
    }
    public String getWebsite() {
        return this.website;
    }

    //--- DATABASE MAPPING : skills ( VARCHAR ) 
    public void setSkills( String skills ) {
        this.skills = skills;
    }
    public String getSkills() {
        return this.skills;
    }

    //--- DATABASE MAPPING : phonenumber ( INT ) 
    public void setPhonenumber( BigInteger phonenumber ) {
        this.phonenumber = phonenumber;
    }
    public BigInteger getPhonenumber() {
        return this.phonenumber;
    }

    //--- DATABASE MAPPING : phoneext ( INT ) 
    public void setPhoneext( Integer phoneext ) {
        this.phoneext = phoneext;
    }
    public Integer getPhoneext() {
        return this.phoneext;
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
        sb.append(profession);
        sb.append("|");
        sb.append(profileImage);
        sb.append("|");
        sb.append(profilename);
        sb.append("|");
        sb.append(profiledescription);
        sb.append("|");
        sb.append(createdDate);
        sb.append("|");
        sb.append(updatedDate);
        sb.append("|");
        sb.append(twitterLink);
        sb.append("|");
        sb.append(facebookLink);
        sb.append("|");
        sb.append(instagramLink);
        sb.append("|");
        sb.append(linkedinLink);
        sb.append("|");
        sb.append(aboutMe);
        sb.append("|");
        sb.append(availabilityHire);
        sb.append("|");
        sb.append(website);
        sb.append("|");
        sb.append(skills);
        sb.append("|");
        sb.append(phonenumber);
        sb.append("|");
        sb.append(phoneext);
        return sb.toString(); 
    } 

}
