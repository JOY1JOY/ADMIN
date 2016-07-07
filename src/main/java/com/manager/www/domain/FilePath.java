package com.manager.www.domain;

public class FilePath {

	private String root;
	private String parentPath;
	private String fileName;
	private String extName;
	private String allPath;
	private String webPath;

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExtName() {
		return extName;
	}

	public void setExtName(String extName) {
		this.extName = extName;
	}

	public String getAllPath() {
		return allPath;
	}

	public void setAllPath(String allPath) {
		this.allPath = allPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}
	
	public String getWebPath() {
		return webPath;
	}

}
