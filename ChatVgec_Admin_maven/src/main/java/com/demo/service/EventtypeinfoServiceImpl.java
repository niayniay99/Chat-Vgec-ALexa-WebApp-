package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.EventtypeinfoDao;
import com.demo.model.EventtypeinfoVO;

@Service
@Transactional
public class EventtypeinfoServiceImpl implements EventtypeinfoService {
	
	@Autowired
	private EventtypeinfoDao eventtypeinfoDao;

	@Override
	public void save(EventtypeinfoVO eventtypeinfoVO) {
		this.eventtypeinfoDao.save(eventtypeinfoVO);
	}

	@Override
	public List<EventtypeinfoVO> getEventtypeinfo() {
		return this.eventtypeinfoDao.getEventtypeinfo();
	}

	@Override
	public List<EventtypeinfoVO> getEventtypeinfoById(int eventtypeinfoid) {
		return this.eventtypeinfoDao.getEventtypeinfoById(eventtypeinfoid);
	}

}
