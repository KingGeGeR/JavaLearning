package jzof_ex;

public class Jxof_10 {

    public int Fibonacci(int n) {
    	int sum=0;
    	int tmp1=1;
    	int tmp2=1;
    	if(n<=2) {
            if(n==0){
                return 0;
            }else{
                return 1;
            }
    	}else {
        	for(int i=2;i<n;i++) {
        		sum=tmp1+tmp2;
        		tmp1=tmp2;
        		tmp2=sum;
        	}
        	return sum;
    	}
    }
}
