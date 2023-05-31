package com.demo.service;

import java.util.List;

import com.demo.model.ScholarshipVO;

public interface ScholarshipService {
	void save(ScholarshipVO scholarshipVO);

	List<ScholarshipVO> getScholarship();

	List<ScholarshipVO> getScholarshipById(int id);
	
}
