package com.demo.dao;

import java.util.List;

import com.demo.model.HostelVO;

public interface HostelDao {
	void save(HostelVO hostelVO);

	List<HostelVO> getHostel();

	List<HostelVO> getHostelById(int id);

}
