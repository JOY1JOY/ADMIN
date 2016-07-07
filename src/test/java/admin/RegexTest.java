package admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	
	
	public static void main(String[] args) {
		
        String[] str = {
        		"2015-07-25 10:57:32","2015-07-25","2015/07/25 10:57:32","2015/07/25",
        		"2015年07月25日 10时57分32秒"
        };
        String[] dateSplit={"yyyy","MM","dd","HH","mm","ss"};
        String regx= "\\d{2,4}(\\D)\\d{0,2}(\\D)\\d{0,2}(\\D{0,10})\\d{0,2}(\\D{0,1})\\d{0,2}(\\D{0,1})\\d{0,2}(\\D{0,1})";
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(str[4]);
        int count = m.groupCount();
        m.find();
        String datePattern="";
        for(int i=1;i<=count;i++){
        	String g=m.group(i);
        	String d=dateSplit[i-1];
        	datePattern+=d+g;
        	if(g==null || g.length()<=0){
        		break;
        	}
        }
		
        System.out.println("-datePattern->"+datePattern);
	}

}
