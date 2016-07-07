package com.manager.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.www.dao.TDictDao;
import com.manager.www.domain.TDict;

@Service
public class TDictService {
	
	@Autowired 
	private TDictDao tDictDao;
	
	/**
	 * 根据类型查询字典
	 * @param type
	 * @return
	 */
	public List<TDict> findByType(String type){
		return tDictDao.findByType(type);
	}
	
	/**
	 * 查询字典并不含父结点
	 * @param type
	 * @param pdkey
	 * @return
	 */
	public List<TDict> findByTypeAndNotPdkey(String type,String pdkey){
		return tDictDao.findByTypeAndNotDkey(type,pdkey);
	}	

}
