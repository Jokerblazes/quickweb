package com.joker.quickweb.service;

import java.util.List;
import java.util.Map;

/**
 * 公共基础操作service接口类
 * @author joker
 *{@link https://github.com/Jokerblazes/quickweb.git}
 * @param <T>
 */
public interface IService<T> {
	
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入（入参数据不能为空）
	 * @param record
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
    int insert(T record);

    /**
     * 
     * @param record
     * @return
     * @author joker
     * {@link https://github.com/Jokerblazes/quickweb.git}
     */
    int insertSelective(T record);

    /**
     * 
     * @param id
     * @return
     * @author joker
     * {@link https://github.com/Jokerblazes/quickweb.git}
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     * @return
     * @author joker
     * {@link https://github.com/Jokerblazes/quickweb.git}
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据主键更新
     * @param record
     * @return
     * @author joker
     * {@link https://github.com/Jokerblazes/quickweb.git}
     */
    int updateByPrimaryKey(T record);
	
	
	/**
	 * 根据条件查询
	 * @param entity
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	public T selectEntity(T entity);
	
	/**
	 * 根据条件查询list
	 * @param entity
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	public List<T> selectList(T entity);
	
	/**
	 * 根据条件查询list（分页）
	 * @param entity
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 * page data
	 */
	public Map<String,Object> selectListByPage(T entity);
}
