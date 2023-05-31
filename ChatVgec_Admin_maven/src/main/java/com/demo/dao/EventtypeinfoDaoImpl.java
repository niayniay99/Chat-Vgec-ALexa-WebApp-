package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.EventtypeinfoVO;

@Repository
public class EventtypeinfoDaoImpl implements EventtypeinfoDao {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void save(EventtypeinfoVO eventtypeinfoVO) {
		try {
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(eventtypeinfoVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public List<EventtypeinfoVO> getEventtypeinfo() {
		List<EventtypeinfoVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from EventtypeinfoVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<EventtypeinfoVO> getEventtypeinfoById(int eventtypeinfoid) {
		List<EventtypeinfoVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from EventtypeinfoVO where status = true and eventtypeinfoid = " + eventtypeinfoid);
			list = q.list();
			
		} catch (Exception e) {e.printStackTrace();
		}
		return list;
	}

}
