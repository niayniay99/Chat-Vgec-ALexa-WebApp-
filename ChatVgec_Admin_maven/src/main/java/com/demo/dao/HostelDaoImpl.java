package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.HostelVO;

@Repository
public class HostelDaoImpl implements HostelDao {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void save(HostelVO hostelVO) {
		try {
			
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(hostelVO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<HostelVO> getHostel() {
		List<HostelVO> list = new ArrayList();
		
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from HostelVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HostelVO> getHostelById(int id) {
		List<HostelVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from HostelVO where status = true and hostelid = " + id);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
