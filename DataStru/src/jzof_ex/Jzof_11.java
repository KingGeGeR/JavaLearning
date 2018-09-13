package jzof_ex;

public class Jzof_11 {
    public int minNumberInRotateArray(int[] array) {
        if(array.length<=0) {
        	return 0;
        }       
        int high=array.length-1;
        int low=0;
        int mid=(high+low)/2;
        while(low<high) {
        	if(array[low]<=array[mid]) {
        		low=mid;
        	}else {
        		high=mid;
        	}
            if(low==high-1) {
            	return array[high];
            }
        }
        return array[0];
    }
}
