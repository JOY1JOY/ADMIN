package com.manager.www.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class PrintBean {
	
	
	public static void  print(Object obj){
		
        final BeanWrapper src = new BeanWrapperImpl(obj);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        for(java.beans.PropertyDescriptor pd : pds) {
        	if(!"class".equals(pd.getName())){
	            Object srcValue = src.getPropertyValue(pd.getName());
	            if (srcValue != null) {
	            	System.out.println(pd.getName()+"-->"+srcValue);
	            }else{
	            	System.out.println(pd.getName()+"--> null");
	            }	        		
        	}
        }
		
		
	}

}
