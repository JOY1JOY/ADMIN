package com.manager.www.domain;

import java.util.Date;

import com.manager.www.annoations.MyDynamicColumn;
import com.manager.www.annoations.MyID;
import com.manager.www.annoations.MyTable;


/**
 * 活动实体类
 * @author cookie
 *
 */

@MyTable("T_ACTIVITIES")
public class Activity {

	@MyID
	private int id;
	
	private String name;
	private int status;
	private String address;
	private Date stime;
	private Date etime;
	private String type;
	private String poster;
	private int pnum;
	private double fee;
	private double joy_fee;
	private int cuid;
	private Date cdatetime;
	private Date audi_datetime;
	private String thumbnail;
	@MyDynamicColumn
	private String userid;
	@MyDynamicColumn
	private String statusAdmin;
	private String description;
	
	private String del;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getJoy_fee() {
		return joy_fee;
	}

	public void setJoy_fee(double joy_fee) {
		this.joy_fee = joy_fee;
	}

	public int getCuid() {
		return cuid;
	}

	public void setCuid(int cuid) {
		this.cuid = cuid;
	}

	public Date getCdatetime() {
		return cdatetime;
	}

	public void setCdatetime(Date cdatetime) {
		this.cdatetime = cdatetime;
	}

	public Date getAudi_datetime() {
		return audi_datetime;
	}

	public void setAudi_datetime(Date audi_datetime) {
		this.audi_datetime = audi_datetime;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getStatusAdmin() {
		return statusAdmin;
	}

	public void setStatusAdmin(String statusAdmin) {
		this.statusAdmin = statusAdmin;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDel() {
		return del;
	}
	
	public void setDel(String del) {
		this.del = del;
	}

}
