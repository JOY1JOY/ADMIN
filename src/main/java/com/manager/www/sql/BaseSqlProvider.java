package com.manager.www.sql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.manager.www.annoations.MyDynamicColumn;
import com.manager.www.annoations.MyID;
import com.manager.www.annoations.MyTable;
import com.manager.www.domain.Activity;

public class BaseSqlProvider {
	
	public String updateSql2(Object Obj){
		
		  return new SQL() {{
			    UPDATE("PERSON");
			    SET("FIRST_NAME = #{firstName}");
			    SET("FIRST_NAME = #{firstName}");
			    WHERE("ID = #{id}");
			    WHERE("");
			  }}.toString();
	}
	
	public String updateSql(Object obj){
		
		final Object obj3 = obj;
		
		String sql=new SQL(){{
			
			MyTable myTable = obj3.getClass().getAnnotation(MyTable.class);
			if(myTable!=null){
				UPDATE(myTable.value());
			}else{
				UPDATE(obj3.getClass().getSimpleName());
			}
			
			String idColumn = "id";
			List<String> dcList = new ArrayList<String>();
			
			Field[] fields = obj3.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				boolean isId = field.isAnnotationPresent(MyID.class);
				if(isId){
					System.out.println("ID-->"+field.getName());
					idColumn=field.getName();
				}
				boolean isDc = field.isAnnotationPresent(MyDynamicColumn.class	);
				if(isDc){
					System.out.println("dc-->"+field.getName());
					dcList.add(field.getName());
				}
			}
		
	        final BeanWrapper src = new BeanWrapperImpl(obj3);
	        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	        for(java.beans.PropertyDescriptor pd : pds) {
	        	if(!"class".equals(pd.getName())){
		            Object srcValue = src.getPropertyValue(pd.getName());
		            
		            if (srcValue != null && ! dcList.contains(pd.getName())) {
		            	if(pd.getName().equalsIgnoreCase(idColumn)){
		            		WHERE("id = #{id}");
		            	}else{
				            if(srcValue instanceof Number ){
				            	int num=((Number) srcValue).intValue();
				            	if(num!=0){
				            		SET(pd.getName()+" = #{"+pd.getName()+"}");
				            	}
				            }else{
				            	SET(pd.getName()+" = #{"+pd.getName()+"}");
				            }
		            	}
		            }
	        	}
	        }
			    
		}}.toString();
		System.out.println("update-sql-->>"+sql);
		return sql;
	}

	
	public static void main(String[] args) {
		BaseSqlProvider b = new BaseSqlProvider();
		b.updateSql(new Activity());
	}
}
