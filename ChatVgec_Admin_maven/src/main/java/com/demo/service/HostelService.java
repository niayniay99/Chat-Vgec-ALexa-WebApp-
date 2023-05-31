package com.demo.service;

import java.util.List;

import com.demo.model.HostelVO;

public interface HostelService {

	void save(HostelVO hostelVO);

	List<HostelVO> getHostel();

	List<HostelVO> getHostelById(int id);

}
