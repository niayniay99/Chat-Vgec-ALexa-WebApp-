package com.demo.dao;

import java.util.List;


import com.demo.model.ScholarshipVO;

public interface ScholarshipDao {
	void save(ScholarshipVO scholarshipVO);

	List<ScholarshipVO> getScholarship();

	List<ScholarshipVO> getScholarshipById(int id);

}
