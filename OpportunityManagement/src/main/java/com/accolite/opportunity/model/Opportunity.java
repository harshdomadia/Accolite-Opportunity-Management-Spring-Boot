package com.accolite.opportunity.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="opportunityfinal1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Opportunity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer opportunityid;
	
	private String opportunitydescription;
	private String location;
	private String skills;
	private Integer openingcount;
	private Integer projectduration;
	private String lastdatetoapply;
	private Integer experience;
	private String managername;
	private String manageremail;
	private String createremail;
	public Integer getOpportunityid() {
		return opportunityid;
	}
	public void setOpportunityid(Integer opportunityid) {
		this.opportunityid = opportunityid;
	}
	
	public String getOpportunitydescription() {
		return opportunitydescription;
	}
	public void setOpportunitydescription(String opportunitydescription) {
		this.opportunitydescription = opportunitydescription;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public Integer getOpeningcount() {
		return openingcount;
	}
	public void setOpeningcount(Integer openingcount) {
		this.openingcount = openingcount;
	}
	public Integer getProjectduration() {
		return projectduration;
	}
	public void setProjectduration(Integer projectduration) {
		this.projectduration = projectduration;
	}
	public String getLastdatetoapply() {
		return lastdatetoapply;
	}
	public void setLastdatetoapply(String lastdatetoapply) {
		this.lastdatetoapply = lastdatetoapply;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManageremail() {
		return manageremail;
	}
	public void setManageremail(String manageremail) {
		this.manageremail = manageremail;
	}
	public String getCreateremail() {
		return createremail;
	}
	public void setCreateremail(String createremail) {
		this.createremail = createremail;
	}
	
	
	

}
