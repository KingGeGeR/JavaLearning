package jzof_ex;
public class jzof_3 {

    public String replaceSpace(StringBuffer str) {
    	
    	//Scanner sc=new Scanner(System.in);
    	char[] stIn=(new String(str)).toCharArray();
    	String s="";
    	if(str==null) {
    		return null;
    	}else {
    		int i=0;//查找原来空格所处的位置
    		int j=0;//插入空格所多出来的位置
    		while(i<stIn.length) {
    			if(stIn[i]==' ') {//字符不要和字符串混淆
    				str.deleteCharAt(i+j);
    				str.insert(i+j, "%20");
    				j=j+2;
    			}
                i++;
    		}
    	}
    	s=new String(str);
    	/*for(int i=0;i<stOut.length-1;i++) {
    		s=s+stOut[i]+"%20";
    	}
    	s=s+stOut[stOut.length-1];*/
    	
    	
    	return s;
    }
}
