package com.demo.service;

import java.util.List;

import com.demo.model.EventtypeVO;

public interface EventtypeService {
	void save(EventtypeVO eventtypeVO);

	List<EventtypeVO> getEventtype();

	List<EventtypeVO> getEventtypeById(int eventtypeId);


}
