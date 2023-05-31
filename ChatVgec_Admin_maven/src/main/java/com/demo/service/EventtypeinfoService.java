package com.demo.service;

import java.util.List;

import com.demo.model.EventtypeinfoVO;

public interface EventtypeinfoService {

void save(EventtypeinfoVO eventtypeinfoVO);
	
	List<EventtypeinfoVO> getEventtypeinfo();

	List<EventtypeinfoVO> getEventtypeinfoById(int eventtypeinfoid);

}
