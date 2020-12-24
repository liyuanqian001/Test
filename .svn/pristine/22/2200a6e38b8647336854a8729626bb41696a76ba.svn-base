package com.baizhuo.smbms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhuo.smbms.entity.Provider;
import com.baizhuo.smbms.service.IUserService;
import com.baizhuo.smbms.service.ProviderService;

@Controller
@RequestMapping(value="/provider.do")
public class ProviderController {
	private ProviderService providerService;
	
	@Autowired
	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}
	
	@RequestMapping(params="method=queryi")
	public String list(Model model) {
		List<Provider> list = providerService.getlist();
		model.addAttribute("providerList", list);
		System.out.println(12341);
		return "jsp/providerlist";//转发
	}
}
