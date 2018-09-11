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
	 * �������ϵ�ð��
	 */
	public static void BubbleSort(int[] arr){

		//length������ÿ�ζ�����������±���������С�Ľ���
		//length-1���ѭ��Ҳ����Ҫð�ݵĴ�����ÿ��ð��Ҫ�Ƚϵ�����ѭ����С������
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
	 * �������µĳ���
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
	 * �x�������㷨
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
	 * ���������㷨
	 * �Լ�д�����ַ����Լ�Ӧ�û������⣬Ҳ�����Լ���д�����ϣ������
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
	 * ϣ�������㷨
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
	 * ��������
	 * ���ڿ��������Ȼ�������Ĳ������룬˼��ܼ�
	 *����Ҫ��һ��KEYֵ����Ϊ�꣬Ȼ��С��KEY�Ķ���KEY����ߣ�����KEY�Ķ���KEY���ұ�
	 *����ָ�����ͷ��ʼ���м��ߣ��������ʾС�Ķ�����ߣ���Ķ����ұ��ˣ�������ʱ��λ�õ�ֵ��Ӧ�÷�KEY
	 */
	public static void QuickSort(int[] arr,int l,int r){
		if(l>=r) {
			return;
		}else {
			int key=arr[l];
			int i=l;
			int j=r;
			while(i<j) {
				while(arr[j]>=key&&j>i) {//ijû�����������������һ����KEYС��
					j--;
				}
				if(i<j) {
					arr[i]=arr[j];//Ȼ���ֵ����iָ���
					i++;//��ֵ��ɣ�i������һ������Ϊ��ǰiֵ���Ϲ�����
				}
				
				while(arr[i]<=key&&i<j) {//ijû�����������������һ����KEY���
					i++;
				}
				if(i<j) {
					arr[j]=arr[i];//Ȼ���ֵ����jָ���
					j--;//��ֵ��ɣ�j������һ��
				}
			}
			arr[i]=key;//���������
			QuickSort(arr,l,i-1);
			QuickSort(arr,i+1,r);
		}		
	}
	
	/*
	 * �鲢����,�ݹ�
	 */
	public static void MergeSort(int[] arr,int first,int last,int[] temp){
		if(first<last) {
			MergeSort(arr,first,(first+last)/2,temp);
			MergeSort(arr,(first+last)/2+1,last,temp);
			MergeArray(arr,first,(first+last)/2,last,temp);
		}
	}
	//�ϲ� ������������a[first��middle],a[middle+1��end]�ϲ�
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
			arr[first+l]=temp[l];//��temp���¸���arr,arr��Ϊ�м�Ľ��
		}
		
	}
	
	//��������
	//��i�ڵ㿪ʼ����,nΪ�ڵ����� ��0��ʼ���� i�ڵ���ӽڵ�Ϊ 2*i+1, 2*i+2  
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
	 * ��������,���̫���ˣ�ÿ�ζ��ؽ���һ�����ѣ���ʵ�ϲ�����Ҫ
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
	//ǰ�������ǵ�arr�Ѿ���һ�����ˣ���ô��λ����֮��ֻ��Ҫ���Ŵ�ڵ����µ�������
	//��С�������ӽڵ㼴��break�����ߵ�����Ҷ��
	private static void MaxHeapAdjust(int[] arr,int beg,int len){

		for(int i=2*beg+1;i<len;i=2*i+1) {
			int j=beg;//��¼���ڵ�λ��
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
	 * ��ӡ����
	 */
	public static void PrintSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.print("\n");
	}
}
