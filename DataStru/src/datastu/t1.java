package datastu;
import java.util.*;
public class t1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Scanner sc=new Scanner(System.in);
		char[] s=sc.nextLine().toCharArray();
		sc.close();
		int max=0;		
		int i=0;
		int j=0;
		int temp=0;
		while(i<s.length&&j<s.length){
			temp=0;
			HashMap<Character,Integer> charmap=new HashMap<Character,Integer>();
			for(j=i;j<s.length;j++) {
				if(charmap.containsKey(s[j])) {
					break;
				}else {
					charmap.put(s[j], 1);
					temp++;
				}
			}
			i=j;
			if(temp>max) {
				max=temp;
			}
		}				
		System.out.println(max);
	}

}
