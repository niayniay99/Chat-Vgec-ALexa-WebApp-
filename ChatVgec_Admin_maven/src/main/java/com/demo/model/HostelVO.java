package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hostel_table")
public class HostelVO {
	@Id
	@Column(name = "hostel_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hostelid;
	
	@Column(name = "hostel_name")
	private String hostelName;
	
	@Column(name="totalrooms_available")
	private String totalroomsAvailable;
	
	@Column(name="hostel_fees")
	private String hostelFees;
	
	@Column(name = "hostel_description")
	private String hostelDescription;

	@Column(name = "status")
	private boolean status = true;

	public int getHostelid() {
		return hostelid;
	}

	public void setHostelid(int hostelid) {
		this.hostelid = hostelid;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public String getTotalroomsAvailable() {
		return totalroomsAvailable;
	}

	public void setTotalroomsAvailable(String totalroomsAvailable) {
		this.totalroomsAvailable = totalroomsAvailable;
	}

	public String getHostelFees() {
		return hostelFees;
	}

	public void setHostelFees(String hostelFees) {
		this.hostelFees = hostelFees;
	}

	public String getHostelDescription() {
		return hostelDescription;
	}

	public void setHostelDescription(String hostelDescription) {
		this.hostelDescription = hostelDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
