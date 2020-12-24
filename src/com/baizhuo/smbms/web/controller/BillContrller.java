package com.baizhuo.smbms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhuo.smbms.entity.Bill;
import com.baizhuo.smbms.entity.Provider;
import com.baizhuo.smbms.service.BillService;
import com.baizhuo.smbms.service.ProviderService;

@Controller
@RequestMapping(value = "/bill.do")
public class BillContrller {
	private BillService billService;

	@Autowired
	public void setProviderService(BillService billService) {
		this.billService = billService;
	}

	@RequestMapping(params = "method=query")
	public String list(Model model) {
		List<Bill> list = billService.getlist();
		model.addAttribute("billList", list);
		return "jsp/billlist";// 转发
	}
}
