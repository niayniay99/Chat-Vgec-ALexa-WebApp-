package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.EventtypeDao;
import com.demo.model.EventtypeVO;

@Service
@Transactional
public class EventtypeServiceImpl implements EventtypeService {

	@Autowired
	private EventtypeDao eventtypeDao;

	@Override
	public void save(EventtypeVO eventtypeVO) {
		this.eventtypeDao.save(eventtypeVO);
	}

	@Override
	public List<EventtypeVO> getEventtype() {
		return this.eventtypeDao.getEventtype();
	}

	@Override
	public List<EventtypeVO> getEventtypeById(int eventtypeId) {
		return this.eventtypeDao.getEventtypeById(eventtypeId);
	}

}
