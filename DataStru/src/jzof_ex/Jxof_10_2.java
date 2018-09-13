package jzof_ex;

public class Jxof_10_2 {
    public int JumpFloor(int target) {

    	int tmp1=1;
    	int tmp2=2;
    	int sum=0;
    	if(target<=2) {
    		if(target<1) {
    			return 0;
    		}else if(target<2) {
    			return 1;
    		}else {
    			return 2;
    		}
    	}else {
    		for(int i=2;i<target;i++) {
    			sum=tmp1+tmp2;
    			tmp1=tmp2;
    			tmp2=sum;
    		}
    		return sum;
    	}
    }
    
    public int JumpFloor_Recursive(int target) {

    	if(target<=2) {
    		if(target<1) {
    			return 0;
    		}else if(target<2) {
    			return 1;
    		}else {
    			return 2;
    		}
    	}else {
    		return JumpFloor_Recursive(target-1)+JumpFloor_Recursive(target-2);
    	}
    }
    
    public int JumpFloorII(int target) {

    	int[] arr=new int[target];
    	arr[0]=1;
    	if(target<=1) {
    		if(target<1) {
    			return 0;
    		}else{
    			return 1;
    		}
    	}else {
    		for(int i=1;i<target;i++) {
    			arr[i]=0;
    			for(int j=0;j<i;j++) {
        			arr[i]=arr[i]+arr[j];
    			}
    			arr[i]=arr[i]+1;
    		}
    		return arr[target-1];
    	}
    }
}
