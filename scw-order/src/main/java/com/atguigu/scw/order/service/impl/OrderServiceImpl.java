package com.atguigu.scw.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.scw.order.bean.TOrder;
import com.atguigu.scw.order.bean.TOrderExample;
import com.atguigu.scw.order.mapper.TOrderMapper;
import com.atguigu.scw.order.service.OrderService;
@Service
class OrderServiceImpl implements OrderService{

	@Autowired
	TOrderMapper oderMapper;
	
	@Override
	public void creatorder(TOrder order) {
		// TODO Auto-generated method stub
		oderMapper.insert(order);
	}

	@Override
	public void updateOrderState(String ordernum, Integer status) {
		// TODO Auto-generated method stub
		TOrderExample example = new TOrderExample();
		example.createCriteria().andOrdernumEqualTo(ordernum);
		TOrder order = new TOrder();
		order.setStatus(status+"");
		oderMapper.updateByExampleSelective(order, example);
		
	}

}
