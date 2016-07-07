package com.manager.www.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manager.www.domain.Activity;
import com.manager.www.domain.JsonMessage;
import com.manager.www.domain.TDict;
import com.manager.www.entities.Person;
import com.manager.www.service.ActivityService;
import com.manager.www.service.TDictService;
import com.manager.www.utils.CustomDateEditor1;
import com.manager.www.utils.PrintBean;

@Controller
@RequestMapping("view/activity")
public class ActivityAction {
	
	@Resource
	private ActivityService activityService;
	
	@Resource
	@Autowired
	private TDictService tDictService;
	
	

	/**
	 * 查询活动列表页面
	 * @return
	 */
	@RequestMapping("findList")
	public ModelAndView findList(){
		
		ModelAndView m = new ModelAndView("activityList");
		
		//page.setBegin(1);
		//page.setPageSize(10);
		List<Activity> list= activityService.findAll();
		
		m.addObject("list", list);
		
		return  m;
	}
	
	@RequestMapping("op")
	@ResponseBody
	public JsonMessage op(Activity activity){
		JsonMessage jm = new JsonMessage();
		int count = activityService.update(activity);
		System.out.println("count:->"+count);
		jm.setSuccess(true);
		jm.setMessage("操作成功");
		return  jm;
	}
	
	
	
	
	/**
	 * 编辑活动页面
	 * @return
	 */
	@RequestMapping(value="edit")
	public ModelAndView edit(@RequestParam(required=true) String id){
		ModelAndView m = new ModelAndView("activityEdit");
		Activity activity = activityService.findById(id);
		List<TDict> statusList = tDictService.findByType("status_admin");
		List<TDict> addressList = tDictService.findByType("address_admin");
		List<TDict> typeList = tDictService.findByTypeAndNotPdkey("at_type","np");
		m.addObject("typeList", typeList);
		m.addObject("statusList", statusList);
		m.addObject("addressList", addressList);
		m.addObject("activity", activity);
		return m;
	}

	/**
	 * 更新数据
	 * @param activity
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Activity activity){
		PrintBean.print(activity);
		activityService.update(activity);
		return "redirect:findList";
	}
	
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		dateFormat.setLenient(false);  
		binder.registerCustomEditor(Date.class, new CustomDateEditor1(dateFormat, true));   //true:允许输入空值，false:不能为空值 	
	}
	
	@RequestMapping("test")
	@ResponseBody
	public List<Person > test(String email){
		return activityService.test(email);
	}
}
