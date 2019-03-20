package com.ruiton.dao;

import java.util.List;
import java.util.Map;

import com.ruiton.vo.OrderVo;

/**
 * 订单Dao
 * @author weiminke
 *
 */
public interface OrderDao extends BaseDao<OrderVo>{
	public List<Map<String, Object>> getMapList(OrderVo orderVo);
	
}
