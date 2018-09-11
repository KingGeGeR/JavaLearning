/**
 * 
 */
package algorithm;

/**
 * @author 11253
 *
 */
public class Sort {
	/*@
	 * 从下往上的冒泡
	 */
	public static void BubbleSort(int[] arr){

		//length个数，每次都从数组的最下边向上找最小的交换
		//length-1层大循环也就是要冒泡的次数，每次冒泡要比较的是内循环，小的往上
		for(int i=0;i<arr.length-1;i++) {
			for(int j=arr.length-1;j>i;j--) {
				if(arr[j]<arr[j-1]) {
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
	 }
	
	/*@
	 * 从上往下的沉底
	 */
	public static void BubbleSort2(int[] arr){


	     for(int i=0; i<arr.length-1; i++){   
	    	 for(int j=0;j<arr.length-i-1;j++) {
	    		 if(arr[j]>arr[j+1]) {
	    			 int temp=arr[j];
	    			 arr[j]=arr[j+1];
	    			 arr[j+1]=temp;
	    		 }
	    	 }
	     }
	 }
	
	/*@
	 * 選擇排序算法
	 */
	public static void SelectSort(int[] arr){

		for(int i=0;i<arr.length-1;i++) {
			int min=i;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			if(min!=i) {
				int temp=arr[i];
				arr[i]=arr[min];
				arr[min]=temp;
			}
		}
		
	}
	
	/*
	 * 插入排序算法
	 * 自己写的这种方法自己应该会更好理解，也方便自己来写下面的希尔排序
	 */
	public static void  InsertSort(int[] arr){

		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				} else {
					break;
				}
			}
		}
	}
	
	/*
	 * 希爾排序算法
	 */
	public static void ShellSort(int[] arr){

		int incNum=arr.length/2;
		while(incNum>0) {
			for(int i=0;i<incNum;i++) {
				for(int j=i+incNum;j<arr.length;j+=incNum) {
					for(int k=j;k>i;k-=incNum) {
						if(arr[k]<arr[k-incNum]) {
							int temp=arr[k];
							arr[k]=arr[k-incNum];
							arr[k-incNum]=temp;
						}else {
							break;
						}
					}
				}
			}
			incNum/=2;
		}		
	}
	
	/*
	 * 快速排序
	 * 对于快速排序果然还是理解的不够深入，思想很简单
	 *就是要找一个KEY值来作为标，然后小于KEY的都在KEY的左边，大于KEY的都在KEY的右边
	 *两个指针从两头开始往中间走，相遇则表示小的都在左边，大的都在右边了，而相遇时该位置的值就应该放KEY
	 */
	public static void QuickSort(int[] arr,int l,int r){
		if(l>=r) {
			return;
		}else {
			int key=arr[l];
			int i=l;
			int j=r;
			while(i<j) {
				while(arr[j]>=key&&j>i) {//ij没相遇，则从右向左找一个比KEY小的
					j--;
				}
				if(i<j) {
					arr[i]=arr[j];//然后把值赋予i指向的
					i++;//赋值完成，i往右走一个，因为当前i值符合规则了
				}
				
				while(arr[i]<=key&&i<j) {//ij没相遇，则从左向右找一个比KEY大的
					i++;
				}
				if(i<j) {
					arr[j]=arr[i];//然后把值赋予j指向的
					j--;//赋值完成，j向左走一个
				}
			}
			arr[i]=key;//别忘记这个
			QuickSort(arr,l,i-1);
			QuickSort(arr,i+1,r);
		}		
	}
	
	/*
	 * 归并排序,递归
	 */
	public static void MergeSort(int[] arr,int first,int last,int[] temp){
		if(first<last) {
			MergeSort(arr,first,(first+last)/2,temp);
			MergeSort(arr,(first+last)/2+1,last,temp);
			MergeArray(arr,first,(first+last)/2,last,temp);
		}
	}
	//合并 ：将两个序列a[first，middle],a[middle+1，end]合并
	private static void MergeArray(int[] arr,int first,int middle,int end,int[] temp){     

		int i=first;
		int j=middle+1;
		int k=0;
		while(i<=middle&&j<=end) {
			if(arr[i]<arr[j]) {
				temp[k]=arr[i];
				i++;
				k++;
			}else {
				temp[k]=arr[j];
				j++;
				k++;
			}
		}
		while(i<=middle) {
			temp[k]=arr[i];
			k++;
			i++;
		}
		while(j<=end) {
			temp[k]=arr[j];
			k++;
			j++;
		}
		for(int l=0;l<k;l++) {
			arr[first+l]=temp[l];//用temp重新覆盖arr,arr作为中间的结果
		}
		
	}
	
	//构建最大堆
	//从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2  
	/*
	private static void BuildMaxHeapFixdown(int[] arr,int len){
		int i=(len)/2-1;
		while(i>=0) {
			if(2*i+2<=len-1&&arr[i]<arr[2*i+2]) {
				int temp=arr[2*i+2];
				arr[2*i+2]=arr[i];
				arr[i]=temp;
			}
			if(2*i+1<=len-1&&arr[i]<arr[2*i+1]) {
				int temp=arr[2*i+1];
				arr[2*i+1]=arr[i];
				arr[i]=temp;
			}
			i--;
		}
	}*/
	/*
	 * 最大堆排序,这个太蠢了，每次都重建了一个最大堆，事实上并不需要
	 */
	/*
	public static void MaxHeapSort(int[] arr,int len){
 
		int i=0;
		while(i<len) {
			BuildMaxHeapFixdown(arr,len-i);
			int temp=arr[0];
			arr[0]=arr[len-i-1];
			arr[len-i-1]=temp;
			i++;
		}
	}
	*/
	//前提是我们的arr已经是一个堆了，那么首位互换之后，只需要沿着大节点向下调整即可
	//不小于左右子节点即可break，或者调整到叶子
	private static void MaxHeapAdjust(int[] arr,int beg,int len){

		for(int i=2*beg+1;i<len;i=2*i+1) {
			int j=beg;//记录父节点位置
			if(i+1<len&&arr[i]<arr[i+1]) {
				i++;
			}
			if(arr[j]<arr[i]) {
				int tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
			}else {
				break;
			}
			beg=i;
		}
	}
	
	public static void MaxHeapSort(int[] arr,int len){

		for(int i=len/2-1;i>=0;i--) {
			MaxHeapAdjust(arr,i,len);
		}
		for(int i=len-1;i>0;i--) {
			int tmp=arr[0];
			arr[0]=arr[i];
			arr[i]=tmp;
			MaxHeapAdjust(arr,0,i);
		}
	}
	
	/*
	 * 打印数组
	 */
	public static void PrintSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.print("\n");
	}
}
