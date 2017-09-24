package com.joker.quickweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.joker.quickweb.dao.BaseDao;
import com.joker.quickweb.service.ICommonService;
import com.joker.quickweb.utils.ReflectionUtil;


public class CommonServiceImpl<M extends BaseDao<T>, T> extends ServiceImpl<M, T> implements ICommonService<T> {
	
	@Transactional
	public void deleteByIds(String[] ids) {
		for (String id : ids) 
			baseDao.deleteByPrimaryKey(Integer.parseInt(id));
	}
	
	@Transactional
	public List<T> selectListByIds(String[] ids) {
		List<T> list = new ArrayList<T>();
		for (String id : ids) {
			T entity = baseDao.selectByPrimaryKey(Integer.parseInt(id));
			list.add(entity);
		}
		return list;
	}

	@Transactional
	public void saveOrUpdateList(List<T> list) {
		for (T entity : list) {
			saveOrUpdate(entity);
		}
	}
	
	public void saveOrUpdate(T entity) {
		int id = ReflectionUtil.getId(entity);
		if (id != 0) 
			baseDao.updateByPrimaryKeySelective(entity);
		else
			baseDao.insertSelective(entity);
	}
	
}
