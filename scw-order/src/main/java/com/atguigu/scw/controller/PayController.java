package com.atguigu.scw.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="支付模块")
@RestController
@RequestMapping("/order/pay/")
public class PayController {
	
	@ApiOperation("支付宝支付")
	@PostMapping("alipay")
	public String alipay() {
		return "";
	}
	
	@ApiOperation("微信支付")
	@PostMapping("weixin")
	public String weixin() {
		return "";
	}
	
}
