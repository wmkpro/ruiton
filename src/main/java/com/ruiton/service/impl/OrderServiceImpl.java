package com.ruiton.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruiton.dao.BaseDao;
import com.ruiton.dao.OrderDao;
import com.ruiton.service.OrderService;
import com.ruiton.vo.OrderVo;

@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderVo> implements OrderService{
	
	@Resource
	private OrderDao orderDao;
	@Override
	public BaseDao<OrderVo> getBaseDao() {
		return orderDao;
	}
	
	@Override
	public List<Map<String, Object>> getMapList(OrderVo orderVo) {
		return orderDao.getMapList(orderVo);
	}
}
