package com.xznu.edu.leave.base.dao.impl;


import java.lang.reflect.ParameterizedType;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.SystemContext;


public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;

	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	public T add(T t) {
		getSession().save(t);
		return t;
	}

	public Pager<T> findByAlias(String hql, Map<String, Object> alias) {
		return this.find(hql,null, alias);
	}

	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(hql);
		String cq = getCountHql(hql,true);
		Query cquery = getSession().createQuery(cq);
		Query query = getSession().createQuery(hql);
		//设置别名参数
		setAliasParameter(query, alias);
		setAliasParameter(cquery, alias);
		//设置参数
		setParameter(query, args);
		setParameter(cquery, args);
		Pager<T> pages = new Pager<T>();
		setPagers(query,pages);
		List<T> datas = query.list();
		pages.setDatas(datas);
		long total = (Long)cquery.uniqueResult();
		pages.setTotal(total);
		return pages;
	}

	private String getCountHql(String hql,boolean isHql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*) "+e;
		if(isHql)
			c.replaceAll("fetch", "");
		return c;
	}

	private String initSort(String hql) {
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(sort!=null&&!"".equals(sort.trim())) {
			hql+=" order by "+sort;
			if(!"desc".equals(order)) hql+=" asc";
			else hql+=" desc";
		}
		return hql;
	}

	public void update(T t) {
		getSession().update(t);
	}


	public void delete(int id) {
		getSession().delete(this.load(id));
	}


	public T load(int id) {
		return (T)getSession().load(getClz(), id);
	}

    @Override
    public T findById(Integer id) {
        return (T)getSession().load(getClz(), id);
    }

    public T updates(T bean) {
        // 取得元数据
        ClassMetadata cm = sessionFactory.getClassMetadata(getClz());
        // 取得主键名称
        String identifierName = cm.getIdentifierPropertyName();
        // 反射取得主键值
        Integer id = (Integer) getSimpleProperty(bean, identifierName);
        // 取得数据库中的对象
        T po = findById(id);
        // 取得所有属性
        String[] propNames = cm.getPropertyNames();
        // 定义存储新值
        Object newValue;
        for (String propName : propNames) {
            // 如果是主键就跳过
            if (propName.equals(identifierName)) {
                continue;
            }
            // 反射取得新值
            newValue = getSimpleProperty(bean, propName);
            if (newValue != null) {
                // 设置新值
                cm.setPropertyValue(po, propName, newValue);
            }
        }
        return po;
    }

    public static Object getSimpleProperty(Object bean, String propName) {
        try {
            return bean.getClass().getMethod(getReadMethod(propName)).invoke(bean);
        } catch (Exception e) {
            throw new RuntimeException("get object property failed: '" + propName + "'", e);
        }
    }

    private static String getReadMethod(String name) {
        return "get" + name.substring(0, 1).toUpperCase(Locale.ENGLISH)
                + name.substring(1);
    }

    private static String setReadMethod(String name) {
        return "set" + name.substring(0, 1).toUpperCase(Locale.ENGLISH)
                + name.substring(1);
    }


	@SuppressWarnings("rawtypes")
	private void setAliasParameter(Query query,Map<String,Object> alias) {
		if(alias!=null) {
			Set<String> keys = alias.keySet();
			for(String key:keys) {
				Object val = alias.get(key);
				if(val instanceof Collection) {
					//查询条件是列表
					query.setParameterList(key, (Collection)val);
				} else {
					query.setParameter(key, val);
				}
			}
		}
	}

	private void setParameter(Query query,Object[] args) {
		if(args!=null&&args.length>0) {
			int index = 0;
			for(Object arg:args) {
				query.setParameter(index++, arg);
			}
		}
	}


	@SuppressWarnings("rawtypes")
	private void setPagers(Query query,Pager pages) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageOffset==null||pageOffset<0) pageOffset = 0;
		if(pageSize==null||pageSize<0) pageSize = 15;
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
	}
}
