package com.xznu.edu.leave.base.dao;

public interface BaseDao<T> {
	/**
	 * 添加对象
	 * @param t
	 * @return
	 */
	public T add(T t);
	/**
	 * 更新对象
	 * @param t
	 */
	public void update(T t);

    T findById(Integer id);

    public T updates(T t);
	/**
	 * 根据id删除对象
	 * @param id
	 */
	public void delete(int id);
}
