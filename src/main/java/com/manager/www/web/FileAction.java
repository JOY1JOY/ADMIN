package com.manager.www.web;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.manager.www.domain.FilePath;

@Controller
@RequestMapping("file")
public class FileAction {

	@RequestMapping("fileUploadPage")
	public String fileUploadPage(){
		return "fileUploadPage";
	}
	
	
	/**
	 * 上传文件
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="uploadFile",method=RequestMethod.POST)
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
        ModelAndView m = new ModelAndView("fileUploadPage");
        if (!file.isEmpty()) {
        	FilePath filePath=getFilePath(file.getOriginalFilename());
        	System.out.println("-filePath->"+filePath.getAllPath());
        	File uploadfile = new File(filePath.getAllPath());
            FileUtils.writeByteArrayToFile(uploadfile, file.getBytes());
            
            JsonObject json = new JsonObject();
            json.addProperty("filePath", filePath.getWebPath());
            
            m.addObject("json", json.toString());
            m.addObject("filePath", filePath.getWebPath());
        }
        
        return m;
	}
	
	/**
	 * 根据源文件名成生文件名
	 * @param originalFileName
	 * @return
	 */
	private FilePath getFilePath(String originalFileName){
		
		
		
		/*根据系统类型确定根路径*/
		String os1 = System.getProperty("os.name");
		String root = "/opt/";
		if (os1.toLowerCase().startsWith("win")) {
			root = "D:\\";
		}
		
		
		/*获取文件分隔符*/
		String s= System.getProperties().getProperty("file.separator");
		Calendar c = Calendar.getInstance();
		
		
		String year=String.valueOf(c.get(Calendar.YEAR));
		String month=String.valueOf(c.get(Calendar.MONTH)+1);
		String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String fileName=UUID.randomUUID().toString().replace("-", "")+"_"+originalFileName;
		String path="images"+s+"at"+s+year+s+month+s+day;
		String parentPath=root+path;
		String allPath=root+path+s+fileName;
		String webPath="/"+(path+s+fileName).replace("\\", "/");
		
		
		FilePath filePath = new FilePath();
		filePath.setRoot(root);
		filePath.setFileName(fileName);
		filePath.setParentPath(parentPath);
		filePath.setAllPath(allPath);
		filePath.setWebPath(webPath);
		
		return filePath;
	}

}
