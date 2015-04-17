package com.bbs.core;

import java.util.List;
import java.util.Map;

/**
 * @author johnny
 *
 * @param <T>
 * @param <TE>
 * @param <PK>
 */
public interface GenericMapper<T, TE, PK> {
    int countByExample(TE example);

    int deleteByExample(TE example);

    int deleteByPrimaryKey(PK id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(TE example);

    T selectByPrimaryKey(PK id);

//    int updateByExampleSelective(T record, TE example);

    int updateByExampleSelective(Map<String, Object> params);

    int updateByExample(T record, TE example);

    int updateByExample(Map<String, Object> params);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
