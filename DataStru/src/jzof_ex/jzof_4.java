package jzof_ex;
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;

import datastu.ListNode;

public class jzof_4 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<Integer> li=new ArrayList<Integer>();
    	ArrayList<Integer> bi=new ArrayList<Integer>();
        if(listNode==null) {
        	return li;
        }else {
        	while(listNode!=null) {
        		bi.add(listNode.val);
        		listNode=listNode.next;
        	}
        	for(int i=0;i<bi.size();i++) {
        		li.add(bi.get(bi.size()-i-1));
        	}
        	return li;
        }
    }
}

