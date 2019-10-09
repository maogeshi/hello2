package com.atguigu.scw.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.scw.bean.TMember;
import com.atguigu.scw.common.utils.AppResponse;
import com.atguigu.scw.common.utils.ScwUtils;
import com.atguigu.scw.order.bean.TOrder;
import com.atguigu.scw.order.service.OrderService;
import com.atguigu.scw.order.vo.request.OrderComfirmVo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags="订单模块")
@RequestMapping("/order/")
@RestController
@Slf4j
public class OrderController {

	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	OrderService orderService;
	
	
	
	@PostMapping("updateOrderState")
	public AppResponse<String> updateOrderState(@RequestParam("ordernum")String ordernum,@RequestParam("status")Integer status) {
		orderService.updateOrderState(ordernum,status);
		return AppResponse.ok(null, "修改订单成功");
		 
	}	
	
	
	@ApiOperation("取消订单")
	@PostMapping("cancle")
	public String cancle() {
		return "";
	}
	
	@ApiOperation("创建订单")
	@PostMapping("createorder")
	public AppResponse<String> createOrder(@RequestBody OrderComfirmVo vo) {
		log.info("传入的参数vo：{}",vo);
		//没有设置memberid，可以根据accessToken去查询
		TMember member = ScwUtils.getBeanFromRedis(stringRedisTemplate, vo.getAccessToken(), TMember.class);
		vo.setMemberid(member.getId());
		//将vo转为Torder
		TOrder order = new TOrder();
		BeanUtils.copyProperties(vo, order);
		order.setStatus(vo.getStatus()+"");
		order.setInvoice(vo.getInvoice()+"");
		
		log.info("转换后的订单对象：{}",order);
		//调用业务层将Torder存到数据中
		orderService.creatorder(order);
		//给webui项目响应结果
		
		return AppResponse.ok(null, "订单创建成功");
	}
	
	@ApiOperation("立即付款")
	@PostMapping("pay")
	public String pay() {
		return "";
	}
	
	
}
