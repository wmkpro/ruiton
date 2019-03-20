package com.ruiton.service;

import java.util.List;
import java.util.Map;

import com.ruiton.bean.Paginer;

public interface BaseService<T> {
	Paginer<T> getPaginer(Paginer<T> paginer);
	List<T> getList(T t);
	Long getCount(T t);
	Long add(T t);
	Long updateByUqKey(T t);
	T get(T t);
	int del(T t);
	List<Map<String, Object>> getMapList(T t);
}
