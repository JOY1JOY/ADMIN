package com.manager.www.domain;


/**
 * 字典类
 * @author cookie
 *
 */
public class TDict {
	
	public int id;
	public String dtype;
	public String dkey;
	public String pdkey;
	public String dvalue;
	public int dorder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDkey() {
		return dkey;
	}

	public void setDkey(String dkey) {
		this.dkey = dkey;
	}

	public String getPdkey() {
		return pdkey;
	}

	public void setPdkey(String pdkey) {
		this.pdkey = pdkey;
	}

	public String getDvalue() {
		return dvalue;
	}

	public void setDvalue(String dvalue) {
		this.dvalue = dvalue;
	}

	public int getDorder() {
		return dorder;
	}

	public void setDorder(int dorder) {
		this.dorder = dorder;
	}

}
