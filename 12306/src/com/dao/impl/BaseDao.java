package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IBaseDao;

/**
 * @功能: 数据库操作实现
 * @开发者: 陈文宇
 * @版本 1.0
 */

@Repository
public class BaseDao<T> implements IBaseDao<T>{
	
     /** 
      * @Autowired 自动装配 相当于get() set()
      */
	@Autowired
    private SessionFactory sessionFactory;

	/**
	 * 根据id进行查询信息
	 * 
	 * @param entityClazz 实体类
	 * @param id ID
	 * @return 数据对象
	 */
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id){
		return (T)sessionFactory.getCurrentSession().get(entityClazz, id);
	}
	
	/**
	 * 查询出对应实体的表中的所有信息
	 * 
	 * @param entityClazz 实体类
	 * @return  对应实体的表中的所有信息列表
	 */
	public List<T> findAll(Class<T> entityClazz) {
		return find("SELECT en FROM " + entityClazz.getSimpleName() + " en");
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return (List<T>)sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	/**
     * 查询出对应实体的表中的所有信息总数
     * 
     * @param entityClazz 实体类
     * @return 信息总数
     */
	public long findCount(Class<T> entityClazz){
		List<?> l = find("SELECT COUNT(*) FROM " + entityClazz.getSimpleName());
		// 取得查询得到的实体总数
		if(l != null && l.size() ==1){
			return (Long)l.get(0);
		}
		return 0;
	}

	/**
	 * 保存数据记录
	 * 
	 * @param entity 数据对象
	 */
	public Serializable save(T entity){
		return sessionFactory.getCurrentSession().save(entity);
	}
	
	/**
	 * 更新数据记录
	 * 
	 * @param entity 数据对象
	 */
	public void update(T entity){
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
	
	/**
	 * 删除数据记录
	 * 
	 * @param entity 数据对象
	 */
	public void delete(T entity){
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	/**
     * 根据ID删除数据记录
     * 
     * @param entity 实体类
     * @param id ID            
     */
	public void delete(Class<T> entityClazz, Serializable id){
		sessionFactory.getCurrentSession()
					.createQuery("DELETE " + entityClazz.getSimpleName() + " en WHERE en.id = ?0")
					.setParameter("0", id)
					.executeUpdate();
	}
	
    /**
     * 批量删除数据
     * 
     * @param entityClazz 实体类
     * @param ids ID数组集合
     *            
     */
	public void delete(Class<T> entityClazz, String[] ids) {
    	for (String id : ids) {
    		T obj =get(entityClazz, id);
            if (obj != null) {
            	delete(obj);
            }
        }
    }
}
