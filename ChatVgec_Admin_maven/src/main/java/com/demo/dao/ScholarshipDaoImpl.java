package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.ScholarshipVO;

@Repository
public class ScholarshipDaoImpl implements ScholarshipDao {
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public void save(ScholarshipVO scholarshipVO) {
		try {
			
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(scholarshipVO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<ScholarshipVO> getScholarship() {
		List<ScholarshipVO> list = new ArrayList();
		
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from ScholarshipVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ScholarshipVO> getScholarshipById(int id) {
		List<ScholarshipVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from ScholarshipVO where status = true and scholarshipid = " + id);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
