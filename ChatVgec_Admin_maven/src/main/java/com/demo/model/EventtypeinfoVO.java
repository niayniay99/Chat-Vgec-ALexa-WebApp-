package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventtypeinfo_table")
public class EventtypeinfoVO {
	@Id
	@Column(name = "eventtypeinfo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventtypeinfoid;

	@Column(name = "time_duration")
	private String timeDuration;

	@Column(name = "cost_of_event")
	private String costofEvent;
	
	@Column(name = "faculty_coordinator")
	private String facultyCoordinator;
	
	@Column(name = "student_coordinator")
	private String studentCoordinator;
	
	@Column(name = "status")
	private boolean status = true;

	@ManyToOne
	@JoinColumn(name = "eventtype_id")
	private EventtypeVO eventtypeVO;

	public int getEventtypeinfoid() {
		return eventtypeinfoid;
	}

	public void setEventtypeinfoid(int eventtypeinfoid) {
		this.eventtypeinfoid = eventtypeinfoid;
	}

	public String getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}

	public String getCostofEvent() {
		return costofEvent;
	}

	public void setCostofEvent(String costofEvent) {
		this.costofEvent = costofEvent;
	}

	public String getFacultyCoordinator() {
		return facultyCoordinator;
	}

	public void setFacultyCoordinator(String facultyCoordinator) {
		this.facultyCoordinator = facultyCoordinator;
	}

	public String getStudentCoordinator() {
		return studentCoordinator;
	}

	public void setStudentCoordinator(String studentCoordinator) {
		this.studentCoordinator = studentCoordinator;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public EventtypeVO getEventtypeVO() {
		return eventtypeVO;
	}

	public void setEventtypeVO(EventtypeVO eventtypeVO) {
		this.eventtypeVO = eventtypeVO;
	}

}
