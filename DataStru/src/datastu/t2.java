package datastu;

import java.util.Scanner;
import java.util.Vector;

public class t2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int t, n, k;
		int minNum, maxNum;
		minNum = 0;
		Vector<Integer> vec=new Vector<Integer>();
		Scanner sc=new Scanner(System.in);
        int len=Integer.parseInt(sc.nextLine());
		String[][] str=new String[len][2];
		int[][] num=new int[len][2];
		for(int i=0;i<len;i++) {
			str[i]=sc.nextLine().split(" ");
			n=Integer.parseInt(str[i][0]);
			k=Integer.parseInt(str[i][1]);
			if (k <= 1) maxNum = 0;
			else if (k <= (n + 1) / 2) maxNum = k - 1;
			else maxNum = n - k;
			vec.add(maxNum);
		}

		for (int i = 0; i<vec.size(); i++)
	        System.out.println(vec.get(i)+" "+0);
	}

}
