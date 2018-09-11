package datastu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = { 90, 12, 561, 97, 33, 108, 6, 87 ,213,1,717,32,3312,33,12};
		//int[] arr = {  90, 12, 561, 97, 33, 108, 6, 87 };		
		//BinaryTree t=new BinaryTree();
		//t.testTree();
        Sort test=new Sort();
        Sort.MinHeap_Sort(arr, arr.length);
        Sort.PrintSort(arr);

	}

}
