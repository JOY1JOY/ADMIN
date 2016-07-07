package com.manager.www.dao;


/**
 * 数据库操作基本类 增删改查
 * @author cookie
 *
 */
public interface BaseDao  {
	
	/**
	 * 添加对象
	 * @param obj
	 */
	public void add(Object obj);

	/**
	 * 删除对象
	 * @param obj
	 */
	public void delete(Object obj);
	
	/**
	 * 更新对象
	 * @param obj
	 */
	public void update(Object obj);
	
	/**
	 * 查找对象
	 * @param obj
	 */
	public void find(Object obj);
	
}
