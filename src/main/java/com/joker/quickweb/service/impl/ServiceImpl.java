package com.joker.quickweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.joker.quickweb.dao.BaseDao;
import com.joker.quickweb.service.IService;
import com.joker.quickweb.utils.PageDto;

public class ServiceImpl<M extends BaseDao<T>, T> implements IService<T> {

	@Autowired
	protected M baseDao;

	public int deleteByPrimaryKey(Integer id) {
		return baseDao.deleteByPrimaryKey(id);
	}

	public int insert(T record) {
		return baseDao.insert(record);
	}

	public int insertSelective(T record) {
		return baseDao.insertSelective(record);
	}

	public T selectByPrimaryKey(Integer id) {
		return baseDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(T record) {
		return baseDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(T record) {
		return baseDao.updateByPrimaryKey(record);
	}

	public T selectEntity(T entity) {
		return baseDao.selectEntity(entity);
	}

	public List<T> selectList(T entity) {
		return baseDao.selectList(entity);
	}

	public Map<String,Object> selectListByPage(T entity) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<T> data = baseDao.selectListByPage(entity);
		Page<T> page = (Page<T>) data;
		map.put("page", new PageDto(page));
		map.put("data", data);
		return map;
	}
	
	
	

}
