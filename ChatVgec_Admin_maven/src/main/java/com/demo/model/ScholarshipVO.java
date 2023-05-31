package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scholarship_table")
public class ScholarshipVO {
	@Id
	@Column(name = "scholarship_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scholarshipid;
	
	@Column(name = "scholarship_name")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String scholarshipName;
	
	@Column(name = "minimum_result_criteria")
	private String minimumresultCriteria;

	@Column(name = "faculty_coordinator")
	private String facultyCoordinator;

	@Column(name = "scholarship_description")
	private String scholarshipDescription;

	@Column(name = "status")
	private boolean status = true;

	public int getScholarshipid() {
		return scholarshipid;
	}

	public void setScholarshipid(int scholarshipid) {
		this.scholarshipid = scholarshipid;
	}

	public String getMinimumresultCriteria() {
		return minimumresultCriteria;
	}

	public void setMinimumresultCriteria(String minimumresultCriteria) {
		this.minimumresultCriteria = minimumresultCriteria;
	}

	public String getFacultyCoordinator() {
		return facultyCoordinator;
	}

	public void setFacultyCoordinator(String facultyCoordinator) {
		this.facultyCoordinator = facultyCoordinator;
	}

	public String getScholarshipDescription() {
		return scholarshipDescription;
	}

	public void setScholarshipDescription(String scholarshipDescription) {
		this.scholarshipDescription = scholarshipDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
