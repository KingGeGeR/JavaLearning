package jzof_ex;
public class jzof_3 {

    public String replaceSpace(StringBuffer str) {
    	
    	//Scanner sc=new Scanner(System.in);
    	char[] stIn=(new String(str)).toCharArray();
    	String s="";
    	if(str==null) {
    		return null;
    	}else {
    		int i=0;//����ԭ���ո�������λ��
    		int j=0;//����ո����������λ��
    		while(i<stIn.length) {
    			if(stIn[i]==' ') {//�ַ���Ҫ���ַ�������
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
