package algorithm;

public class TestMain {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = { 90, 12, 561, 97, 33, 108, 6, 87 ,213,1,717,32,3312,33,12,5,87,78,98,90,989,23,31,2,5,7,9};
		//int[] temp= new int[arr.length];
		Sort.MaxHeapSort(arr, arr.length);
		Sort.PrintSort(arr);
	}

}
