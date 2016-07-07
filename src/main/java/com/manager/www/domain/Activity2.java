package com.manager.www.domain;

import java.util.Date;


/**
 * 活动实体类备分类,因为有些字段不需要被更新
 * @author cookie
 *
 */
public class Activity2 {

	private int id; 			// int
	private String name; 		// varchar
	private int status; 		// int
	private String address;	 	// varchar
	private Date stime; 		// date
	private Date etime; 		// date
	private String type; 		// varchar
	private String poster; 		// varchar
	private int pnum; 			// int 11
	private String mark; 		// varchar
	private String description; // varchar
	private String attention; 	// varchar
	private String caution; 	// varchar
	private double fee; 		// double
	private double joy_fee; 	// double
	private String gqr; 		// varchar
	private int autoSMS; 		// int
	private String smsContent; 	// varchar
	private int cuid; 			// int
	private Date cdatetime; 	// datetime
	private Date audi_datetime;	// datetime
	private String thumbnail; 	// varchar
	private String userid;
	private String statusAdmin; //
	

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

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
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

	public String getGqr() {
		return gqr;
	}

	public void setGqr(String gqr) {
		this.gqr = gqr;
	}

	public int getAutoSMS() {
		return autoSMS;
	}

	public void setAutoSMS(int autoSMS) {
		this.autoSMS = autoSMS;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
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
	
	public void setStatusAdmin(String statusAdmin) {
		this.statusAdmin = statusAdmin;
	}
	
	public String getStatusAdmin() {
		return statusAdmin;
	}

}
