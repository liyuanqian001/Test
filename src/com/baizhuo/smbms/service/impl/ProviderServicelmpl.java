package com.baizhuo.smbms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhuo.smbms.entity.Provider;
import com.baizhuo.smbms.mapper.ProviderMapper;
import com.baizhuo.smbms.service.ProviderService;

@Service(value = "ProviderService")
public class ProviderServicelmpl implements ProviderService{
	private ProviderMapper providerMapper;
	@Autowired
	public void setUserMapper(ProviderMapper providerMapper) {
		this.providerMapper = providerMapper;
	}
	public List<Provider> getlist() {
		return providerMapper.getlist();
	}

}
