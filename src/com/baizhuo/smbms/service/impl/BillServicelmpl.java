package com.baizhuo.smbms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhuo.smbms.entity.Bill;
import com.baizhuo.smbms.mapper.BillMapper;
import com.baizhuo.smbms.service.BillService;


@Service(value = "BillService")
public class BillServicelmpl implements BillService{
	private BillMapper billMapper;
	@Autowired
	public void setUserMapper(BillMapper billMapper) {
		this.billMapper = billMapper;
	}
	public List<Bill> getlist() {
		return billMapper.getlist();
	}
	
}
