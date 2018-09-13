package exam;

import java.util.Scanner;

public class XL0912T2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()) {
			String[] str=sc.nextLine().split(" ");
			int red=Integer.parseInt(str[0]);
			int bla=Integer.parseInt(str[1]);
			int num=0;
			for(int i=6;i>=0;i--) {
				if(i*red+bla*(7-i)<0) {
					num=i;
					break;
				}
			}
			int rest=(7-num-4>0)?3-num:0;
			int sum=((7-num)*2+rest)*bla+(14-(7-num)*2+3-rest)*red;
			System.out.println(sum);
		}
		sc.close();
	}

}
