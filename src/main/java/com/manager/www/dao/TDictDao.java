package com.manager.www.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.manager.www.domain.TDict;

/**
 * 数据字典数据处理层
 * @author cookie
 *
 */
public interface TDictDao extends BaseDao {

	
	/**
	 * 根据数据类型来查询字典
	 * @param type
	 * @return
	 */
	@Select("select * from t_dict f  where f.dtype=#{type}")
	public List<TDict> findByType(String type);

	
	/**
	 * 查询字典并不含父结点
	 * @param type
	 * @param pdkty
	 * @return
	 */
	@Select("select * from t_dict f  where f.dtype=#{type} and f.pdkey != #{pdkey}")
	public List<TDict> findByTypeAndNotDkey(@Param("type") String type, @Param("pdkey") String pdkey);
	
	
}
