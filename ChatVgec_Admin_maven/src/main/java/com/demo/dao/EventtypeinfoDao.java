package com.demo.dao;

import java.util.List;

import com.demo.model.EventtypeinfoVO;

public interface EventtypeinfoDao {
	void save(EventtypeinfoVO eventtypeinfoVO);

	List<EventtypeinfoVO> getEventtypeinfo();

	List<EventtypeinfoVO> getEventtypeinfoById(int eventtypeinfoid);

}
