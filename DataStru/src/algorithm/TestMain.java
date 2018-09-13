package algorithm;

import datastu.BinaryTree;

import jzof_ex.Jxof_10_2;
import jzof_ex.Jzof_12;
import jzof_ex.Jzof_13;

public class TestMain {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = { 90, 12, 561, 97, 33, 108, 6, 87 ,213,1,717,32,3312,33,12,5,87,78,98,90,989,23,31,2,5,7,9};
		Sort.RadixSort(arr, new int[arr.length], arr.length, 4, 10,new int[10]);
		Sort.PrintSort(arr);
		datastu.BinaryTree<Object> bt=new datastu.BinaryTree<Object>();
		bt.testTree();
		char[] matrix= "ABCESFCSADEE".toCharArray();
		char[] str="ABCB".toCharArray();
		Jzof_13 test=new Jzof_13();
		System.out.println(test.movingCount(5, 10, 10));
	}

}
