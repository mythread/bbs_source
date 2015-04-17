package com.bbs.core;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author johnny
 * 
 * @param <T>
 * @param <TE>
 * @param <PK>
 */
public abstract class GenericServiceImpl<T extends Object, TE extends Object, PK>
		implements GenericService<T, TE, PK> {

	protected abstract GenericMapper<T, TE, PK> getGenericMapper();

	@Override
	public int deleteByPrimaryKey(PK id) {
		return this.getGenericMapper().deleteByPrimaryKey(id);
	}

	@Override
	public T insert(T entity) {
		int flag = this.getGenericMapper().insert(entity);
		if (flag > 0) {
			return entity;
		} else {
			return null;
		}
	}

	@Override
	public T insertSelective(T entity) {
		int flag = this.getGenericMapper().insertSelective(entity);
		if (flag > 0) {
			return entity;
		} else {
			return null;
		}
	}

	@Override
	public T selectByPrimaryKey(PK id) {
		return this.getGenericMapper().selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T entity) {
		return this.getGenericMapper().updateByPrimaryKeySelective(entity);
	}

	@Override
	public int updateByPrimaryKey(T entity) {
		return this.getGenericMapper().updateByPrimaryKey(entity);
	}

	@Override
	public List<T> selectByExample(TE entity) {
		return this.getGenericMapper().selectByExample(entity);
	}

	@Override
	public int countByExample(TE example) {
		return this.getGenericMapper().countByExample(example);
	}

	@Override
	public int deleteByExample(TE example) {
		return this.getGenericMapper().deleteByExample(example);
	}

	@Override
	public int updateByExampleSelective(T record, TE example) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("record", record);
		params.put("example", example);
		return this.getGenericMapper().updateByExampleSelective(params);
	}

	@Override
	public int updateByExample(T record, TE example) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("record", record);
		params.put("example", example);
		return this.getGenericMapper().updateByExample(params);
	}

	@Override
	public List<T> queryAll() {
		return this.getGenericMapper().selectByExample(null);
	}

}
