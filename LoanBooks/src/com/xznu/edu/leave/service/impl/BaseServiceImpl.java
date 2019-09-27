package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class  BaseServiceImpl<T> implements BaseService<T> {
	/** 
     * 注入BaseDao 
     */  
	@Autowired
    private BaseDao<T> dao;

	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public void save(T entity) {
		dao.add(entity);
	}

	public void update(T entity) {
		dao.update(entity);
	}

	public void updates(T entity) {
		dao.updates(entity);
	}

	public void delete(int id) {
		dao.delete(id);
	}

    @Override
    public T findById(int id) {
        return dao.findById(id);
    }

	@Override
	public T getById(int id) {
		return null;
	}

	@Override
	public List<T> getByHQL(String hql, Map<String, Object> alias) {
		return null;
	}

	@Override
	public T getOneByHql(String hql, Map<String, Object> alias) {
		return null;
	}
}
