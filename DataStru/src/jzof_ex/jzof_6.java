package jzof_ex;

import datastu.TreeLinkNode;

public class jzof_6 {
	
    public datastu.TreeLinkNode GetNext(datastu.TreeLinkNode pNode)
    {
    	
    	if(pNode==null) {
    		return null;
    	}else {
    		//pNode����������
    		//�����������,�ҵ�����������������ӽڵ�
    		if(pNode.right!=null) {
    			pNode=pNode.right;
    			while(pNode.left!=null) {    										
					pNode=pNode.left;
				}
    			return pNode;
    		}else {
    			//���û��������
    			//�����ҵ���һ���ڵ㣬�ýڵ��������ڵ�����ӽڵ�
				while(pNode.next!=null) {
					if(pNode==pNode.next.left) {
						return pNode.next;
					}
					pNode=pNode.next;
				}
				return null;
    		}   		
    	}
    }
}
