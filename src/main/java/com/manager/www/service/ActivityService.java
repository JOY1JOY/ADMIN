package com.manager.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.www.dao.ActivityDao;
import com.manager.www.domain.Activity;
import com.manager.www.entities.Person;
import com.manager.www.repositories.PersonRepository;

/**
 * 活动业务逻辑层
 * @author cookie
 *
 */
@Service
public class ActivityService {
	
	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private PersonRepository personRepository;
	

	@Transactional
	public List<Activity> findAll(){
		return activityDao.findAll();
	}


	/**
	 * 按照ID查询活动
	 * @param id
	 * @return
	 */
	public Activity findById(String id) {
		return activityDao.findById(id);
	}


	public int update(Activity activity) {
		return activityDao.update(activity);
	} 
	
	
	public List<Person> test(String email){
		return personRepository.findByEmail(email);
	}

}
