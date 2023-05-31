package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.HostelDao;
import com.demo.model.HostelVO;

@Service
@Transactional
public class HostelServiceImpl implements HostelService{
		
		@Autowired
		private HostelDao hostelDao;
		
		@Override
		public void save(HostelVO hostelVO) {
			 this.hostelDao.save(hostelVO);
			
		}

		@Override
		public List<HostelVO> getHostel() {

			return this.hostelDao.getHostel();
		}

		@Override
		public List<HostelVO> getHostelById(int id) {
			return this.hostelDao.getHostelById(id);
		}

		
}
