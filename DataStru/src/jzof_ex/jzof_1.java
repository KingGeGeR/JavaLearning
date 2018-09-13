package jzof_ex;
import java.util.HashMap;
public class jzof_1 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    
    	int i=0;
    	if(length==0) {
    		return false;
    	}else {
        	HashMap<Integer,Integer> li=new HashMap<Integer,Integer>();
        	while(length>i) {
        		if(li.containsKey(numbers[i])) {
        			duplication[0]=numbers[i];
        			return true;
        		}else {
        			li.put(numbers[i], 1);
        		}
        		i++;
        	}
        	return false;
    	}

    }
}