package com.joker.quickweb.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.joker.quickweb.annotation.TableId;

public class ReflectionUtil {
	private ReflectionUtil() {}
	
	public static int getId(Object entity) {
		Object result = 0;
		String idName = null;
		Class clazz = entity.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			TableId tableId = field.getDeclaredAnnotation(TableId.class);
			if (tableId != null) {
				idName = tableId.value();
				break;
			}
		}
		Method method = null;
		try {
			method = clazz.getMethod("get" + idName, null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			result = method.invoke(entity, null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return (Integer) result;
	}
}
