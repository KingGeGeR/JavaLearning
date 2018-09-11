package datastu;

public class Sort {

	/*@
	 * �������ϵ�ð��
	 */
	public static void BubbleSort(int [] arr){

	     int temp;//��ʱ����
	     for(int i=0; i<arr.length-1; i++){   //��ʾ������һ��arr.length-1�Ρ�
	         for(int j=arr.length-1; j>i; j--){

	             if(arr[j] < arr[j-1]){
	                 temp = arr[j];
	                 arr[j] = arr[j-1];
	                 arr[j-1] = temp;
	             }
	         }
	     }
	 }
	
	/*@
	 * �������µĳ���
	 */
	public static void BubbleSort2(int [] arr){

	     int temp;//��ʱ����
	     for(int i=0; i<arr.length-1; i++){   //��ʾ������һ��arr.length-1�Ρ�
	         for(int j=0; j<arr.length-1-i; j++){

	             if(arr[j] > arr[j+1]){
	                 temp = arr[j];
	                 arr[j] = arr[j+1];
	                 arr[j+1] = temp;
	             }
	         }
	     }
	 }
	
	/*@
	 * �x�������㷨
	 */
	public static void select_sort(int array[],int lenth){

		   for(int i=0;i<lenth-1;i++){

		       int minIndex = i;
		       for(int j=i+1;j<lenth;j++){//�ҵ���С��Ԫ�ص�λ��
		          if(array[j]<array[minIndex]){
		              minIndex = j;//ȡ����Сλ�õ�����
		          }
		       }
		       if(minIndex != i){//���Q
		           int temp = array[i];
		           array[i] = array[minIndex];
		           array[minIndex] = temp;
		       }
		   }
		}
	
	/*
	 * ���������㷨
	 */
	public static void  insert_sort(int array[],int lenth){

		   int temp;

		   for(int i=0;i<lenth-1;i++){
		       for(int j=i+1;j>0;j--){
		           if(array[j] < array[j-1]){
		               temp = array[j-1];
		               array[j-1] = array[j];
		               array[j] = temp;
		           }else{         //����Ҫ����
		               break;
		           }
		       }
		   }
		}
	
	/*
	 * ϣ�������㷨
	 */
	public static void shell_sort(int array[],int lenth){

		   int temp = 0;
		   int incre = lenth;

		   while(true){
		       incre = incre/2;

		       for(int k = 0;k<incre;k++){    //����������Ϊ����������

		           for(int i=k+incre;i<lenth;i+=incre){//�����н��в�������

		               for(int j=i;j>k;j-=incre){
		                   if(array[j]<array[j-incre]){
		                       temp = array[j-incre];
		                       array[j-incre] = array[j];
		                       array[j] = temp;
		                   }else{
		                       break;
		                   }
		               }
		           }
		       }

		       if(incre == 1){
		           break;
		       }
		   }
		}
	
	/*
	 * ��������
	 */
	public static void quickSort(int a[],int l,int r){
	     if(l>=r)
	       return;

	     int i = l; int j = r; int key = a[l];//ѡ���һ����Ϊkey

	     while(i<j){

	         while(i<j && a[j]>=key)//���������ҵ�һ��С��key��ֵ
	             j--;
	         if(i<j){
	             a[i] = a[j];
	             i++;
	         }

	         while(i<j && a[i]<key)//���������ҵ�һ������key��ֵ
	             i++;

	         if(i<j){
	             a[j] = a[i];
	             j--;
	         }
	     } 
	     //i == j
	     a[i] = key;
	     quickSort(a, l, i-1);//�ݹ����
	     quickSort(a, i+1, r);//�ݹ����
	 }
	
	/*
	 * �鲢����
	 */
	public static void merge_sort(int a[],int first,int last,int temp[]){

		  if(first < last){
		      int middle = (first + last)/2;
		      merge_sort(a,first,middle,temp);//��벿���ź���
		      merge_sort(a,middle+1,last,temp);//�Ұ벿���ź���
		      mergeArray(a,first,middle,last,temp); //�ϲ����Ҳ���
		  }
		}
	//�ϲ� ������������a[first-middle],a[middle+1-end]�ϲ�
	public static void mergeArray(int a[],int first,int middle,int end,int temp[]){     
	  int i = first;
	  int m = middle;
	  int j = middle+1;
	  int n = end;
	  int k = 0; 
	  while(i<=m && j<=n){
	      if(a[i] <= a[j]){
	          temp[k] = a[i];
	          k++;
	          i++;
	      }else{
	          temp[k] = a[j];
	          k++;
	          j++;
	      }
	  }     
	  while(i<=m){
	      temp[k] = a[i];
	      k++;
	      i++;
	  }     
	  while(j<=n){
	      temp[k] = a[j];
	      k++;
	      j++; 
	  }

	  for(int ii=0;ii<k;ii++){
	      a[first + ii] = temp[ii];
	  }
	}
	
	//������С��
	public static void MakeMinHeap(int a[], int n){
	 for(int i=(n-1)/2 ; i>=0 ; i--){//�����ѵ�ʱ�����i��ʼ�Ļ����������
	     MinHeapFixdown(a,i,n);
	 }
	}
	//��i�ڵ㿪ʼ����,nΪ�ڵ����� ��0��ʼ���� i�ڵ���ӽڵ�Ϊ 2*i+1, 2*i+2  
	public static void MinHeapFixdown(int a[],int i,int n){

	   int j = 2*i+1; //�ӽڵ�
	   int temp = 0;

	   while(j<n){
	       //�������ӽڵ���Ѱ����С��
	       if(j+1<n && a[j+1]<a[j]){   
	           j++;
	       }

	       if(a[i] <= a[j])
	           break;

	       //�ϴ�ڵ�����
	       temp = a[i];
	       a[i] = a[j];
	       a[j] = temp;

	       i = j;
	       j = 2*i+1;
	   }
	}
	/*
	 * ��С������
	 */
	public static void MinHeap_Sort(int a[],int n){
		  int temp = 0;
		  MakeMinHeap(a,n);

		  for(int i=n-1;i>0;i--){
		      temp = a[0];
		      a[0] = a[i];
		      a[i] = temp; 
		      MinHeapFixdown(a,0,i);
		  }     
		}
	
	/*
	 * ��������
	 */
	public static void RadixSort(int A[],int temp[],int n,int k,int r,int cnt[]){

		   //A:ԭ����
		   //temp:��ʱ����
		   //n:���е����ָ���
		   //k:����λ��2
		   //r:����10
		   //cnt:�洢bin[i]�ĸ���

		   for(int i=0 , rtok=1; i<k ; i++ ,rtok = rtok*r){

		       //��ʼ��
		       for(int j=0;j<r;j++){
		           cnt[j] = 0;
		       }
		       //����ÿ�����ӵ����ָ���
		       for(int j=0;j<n;j++){
		           cnt[(A[j]/rtok)%r]++;
		       }
		       //cnt[j]�ĸ����޸�Ϊǰj������һ���м�������
		       for(int j=1;j<r;j++){
		           cnt[j] = cnt[j-1] + cnt[j];
		       }
		       for(int j = n-1;j>=0;j--){      //�ص����
		           cnt[(A[j]/rtok)%r]--;
		           temp[cnt[(A[j]/rtok)%r]] = A[j];
		       }
		       for(int j=0;j<n;j++){
		           A[j] = temp[j];
		       }
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
