package algorithm;

import datastu.BinaryTree;

public class TestMain {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = { 90, 12, 561, 97, 33, 108, 6, 87 ,213,1,717,32,3312,33,12,5,87,78,98,90,989,23,31,2,5,7,9};
		Sort.RadixSort(arr, new int[arr.length], arr.length, 4, 10,new int[10]);
		Sort.PrintSort(arr);
		datastu.BinaryTree<Object> bt=new datastu.BinaryTree<Object>();
		bt.testTree();
	}

}
