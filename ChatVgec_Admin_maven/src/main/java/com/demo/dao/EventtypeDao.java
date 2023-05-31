package com.demo.dao;

import java.util.List;

import com.demo.model.EventtypeVO;

public interface EventtypeDao {
	void save(EventtypeVO eventtypeVO);

	List<EventtypeVO> getEventtype();

	List<EventtypeVO> getEventtypeById(int eventtypeId);

}
