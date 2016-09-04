package com.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	// 根据ID加载实体
	T get(Class<T> entityClazz, Serializable id);
	// 保存实体
	Serializable save(T entity);
	// 更新实体
	void update(T entity);
	// 删除实体
	void delete(T entity);
	// 根据ID删除实体
	void delete(Class<T> entityClazz, Serializable id);
	// 取得所有实体
	List<T> findAll(Class<T> entityClazz);
	// 取得实体总数
	long findCount(Class<T> entityClazz);
}
