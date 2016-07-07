package admin;

import java.util.Calendar;
import java.util.UUID;

public class Hello {
	
	public static void main(String[] args) {
		
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
		String fileName=UUID.randomUUID().toString().replace("-", "");
		
		
		StringBuilder sb = new StringBuilder();
		
		
		sb.append(root);
		sb.append("images"+s+"at"+s);
		sb.append(year+s);
		sb.append(month+s);
		sb.append(day+s);
		sb.append(fileName);
		
		System.out.println("-->"+sb.toString());
	}

}
