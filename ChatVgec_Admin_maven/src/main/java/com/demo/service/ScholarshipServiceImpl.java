package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.ScholarshipDao;
import com.demo.model.ScholarshipVO;

@Service
@Transactional
public class ScholarshipServiceImpl implements ScholarshipService {

	@Autowired
	private ScholarshipDao scholarshipDao;

	@Override
	public void save(ScholarshipVO scholarshipVO) {
		 this.scholarshipDao.save(scholarshipVO);
		
	}

	@Override
	public List<ScholarshipVO> getScholarship() {

		return this.scholarshipDao.getScholarship();
	}

	@Override
	public List<ScholarshipVO> getScholarshipById(int id) {
		return this.scholarshipDao.getScholarshipById(id);
	}

}
