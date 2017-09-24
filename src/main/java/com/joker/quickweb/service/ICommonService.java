package com.joker.quickweb.service;

import java.util.List;

/**
 * 公共复合操作service接口
 * @author joker
 *
 * @param <T>
 * {@link https://github.com/Jokerblazes/quickweb.git}
 */
public interface ICommonService <T> extends IService<T> {
	
	/**
	 * 
	 * @param ids
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	public void deleteByIds(String[] ids);
	
	/**
	 * 
	 * @param ids
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	public List<T> selectListByIds(String[] ids);
	
	/**
	 * 
	 * @param list
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	public void saveOrUpdateList(List<T> list);
	
	/**
	 * 
	 * @param entity
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	public void saveOrUpdate(T entity);
}
