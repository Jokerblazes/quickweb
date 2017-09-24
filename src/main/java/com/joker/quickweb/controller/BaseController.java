package com.joker.quickweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joker.quickweb.entity.Result;
import com.joker.quickweb.service.ICommonService;
import com.joker.quickweb.utils.WebUtils;

public abstract class BaseController<T> {
	
	protected ICommonService<T> commonService;
	
	@Autowired
	public void setCommonService(ICommonService<T> commonService) {
		this.commonService = commonService;
	}
	
	/**
	 * 根据id删除对象
	 * @param id
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public Result<Integer> delete(int id) {
		WebUtils.isThrowNullException(id);
		int flag = commonService.deleteByPrimaryKey(id);
		Result<Integer> result = new Result<Integer>().buildFlag(flag);
		return result;
	}

	/**
	 * 新建对象
	 * @param entity
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/insert")
	@ResponseBody
	public Result<Integer> insertSelective(T entity) {
		WebUtils.isThrowNullException(entity);
		int flag = commonService.insertSelective(entity);
		Result<Integer> result = new Result<Integer>().buildFlag(flag);
		return result;
	}

	/**
	 * 根据id查找对象
	 * @param id
	 * @param request
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/selectById")
	public String selectById(int id,HttpServletRequest request) {
		WebUtils.isThrowNullException(id);
		T data = commonService.selectByPrimaryKey(id);
		request.setAttribute("data", data);
		return "";
	}

	/**
	 * 根据对象id更新对象信息（更改信息）
	 * @param entity
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public Result<Integer> updateSelective(T entity) {
		WebUtils.isThrowNullException(entity);
		int flag = commonService.updateByPrimaryKeySelective(entity);
		Result<Integer> result = new Result<Integer>().buildFlag(flag);
		return result;
	}
	
	/**
	 * 根据对象id更新对象信息（所有提交信息）
	 * @param entity
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/updateAll")
	@ResponseBody
	public Result<Integer> updateByPrimaryKey(T entity) {
		WebUtils.isThrowNullException(entity);
		int flag = commonService.updateByPrimaryKey(entity);
		Result<Integer> result = new Result<Integer>().buildFlag(flag);
		return result;
	}

	
	/**
	 * 根据对象部分条件查找对象
	 * @param entity
	 * @param request
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/selectEntity")
	public String selectEntity(T entity,HttpServletRequest request) {
		WebUtils.isThrowNullException(entity);
		T data = commonService.selectEntity(entity);
		request.setAttribute("data", data);
		return "";
	}

	/**
	 * 查询对象list（可模糊搜索）
	 * @param entity
	 * @param request
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/list")
	public String list(T entity,HttpServletRequest request) {
		List<T> data = commonService.selectList(entity);
		request.setAttribute("data", data);
		return "";
	}

	/**
	 * 查询对象list（可模糊搜索,可分页）
	 * @param entity
	 * @param request
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/listByPage")
	public String listByPage(T entity,HttpServletRequest request) {
		Map<String,Object> map = commonService.selectListByPage(entity);
		request.setAttribute("map",map);
		return "";
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/deleteByIds")
	@ResponseBody
	public Result<Integer> deleteByIds(String ids) {
		String[] idArray = ids.split(",");
		WebUtils.isThrowNumberException(idArray);
		commonService.deleteByIds(idArray);
		Result<Integer> result = new Result<Integer>().buildFlag(1);
		return result;
	}
	
	/**
	 * 添加或者删除
	 * @param entity
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/saveOrUpdate")
	@ResponseBody
	public Result<Integer> saveOrUpdate(T entity) {
		commonService.saveOrUpdate(entity);
		Result<Integer> result = new Result<Integer>().buildFlag(1);
		return result;
	}
	
	/**
	 * 根据id数组查询对象list
	 * @param ids
	 * @param request
	 * @return
	 * @author joker
	 * {@link https://github.com/Jokerblazes/quickweb.git}
	 */
	@RequestMapping(value="/selectListByIds")
	public String selectListByIds(String ids,HttpServletRequest request) {
		String[] idArray = ids.split(",");
		WebUtils.isThrowNumberException(idArray);
		commonService.selectListByIds(idArray);
		return "";
	}
	
	
}
