package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.EventtypeVO;

@Repository
public class EventtypeDaoImpl implements EventtypeDao {
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public void save(EventtypeVO eventtypeVO) {
		try {
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(eventtypeVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<EventtypeVO> getEventtype() {
		List<EventtypeVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from EventtypeVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<EventtypeVO> getEventtypeById(int eventtypeId) {
		List<EventtypeVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from EventtypeVO where status = true and eventtypeid = " + eventtypeId);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
