package com.manager.www.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.manager.www.domain.Activity;
import com.manager.www.domain.Page;
import com.manager.www.sql.BaseSqlProvider;


/**
 * 活动第三个层架构
 * @author cookie
 *
 */
public interface ActivityDao extends BaseDao{

	
	/**
	 * 分页查询活动列表
	 * @param page
	 * @return
	 */
	@Select("SELECT t.*,(select f.userid from t_users f where f.uid =t.cuid) userid ,( select e.dvalue from t_dict e "
			+ "where e.dkey=t.status and e.dtype='status_admin') statusAdmin"
			+ " from t_activities t where t.del!='Y' or t.del IS NULL order by t.cdatetime desc limit #{begin},#{pageSize}")
	public List<Activity> findByPage(Page page);
	
	/**
	 * 分页查询活动列表
	 * @param page
	 * @return
	 */
	@Select("SELECT t.*,(select f.userid from t_users f where f.uid =t.cuid) userid ,( select e.dvalue from t_dict e "
			+ "where e.dkey=t.status and e.dtype='status_admin') statusAdmin"
			+ " from t_activities t where t.del!='Y' or t.del IS NULL order by t.cdatetime desc ")
	public List<Activity> findAll();	
	
	/**
	 * 查询活动信息按照活动ID
	 * @param id
	 * @return
	 */
	@Select("SELECT t.*,(select f.userid from t_users f where f.uid =t.cuid) userid ,( select e.dvalue from t_dict e "
			+ "where e.dkey=t.status and e.dtype='status_admin') statusAdmin"
			+ " from t_activities t  where t.id=#{id}")
	public Activity findById(String id);
	
	/**
	 * 更新活动信息
	 * @param activity
	 * @return
	 */
	@UpdateProvider(method="updateSql",type=BaseSqlProvider.class)
	public int update(Activity activity);
	
}
