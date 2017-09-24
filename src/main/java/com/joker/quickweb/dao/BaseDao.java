package com.joker.quickweb.dao;

import java.util.List;


public interface BaseDao<T> {
	
	int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
	
//	public int deleteByEntity(T entity);
	
	public T selectEntity(T entity);
	
	public List<T> selectList(T entity);
	
	public List<T> selectListByPage(T entity);
	
	
	
}
