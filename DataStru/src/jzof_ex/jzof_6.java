package jzof_ex;

import datastu.TreeLinkNode;

public class jzof_6 {
	
    public datastu.TreeLinkNode GetNext(datastu.TreeLinkNode pNode)
    {
    	
    	if(pNode==null) {
    		return null;
    	}else {
    		//pNode有无右子树
    		//如果有右子树,找到右子树的最左的左子节点
    		if(pNode.right!=null) {
    			pNode=pNode.right;
    			while(pNode.left!=null) {    										
					pNode=pNode.left;
				}
    			return pNode;
    		}else {
    			//如果没有右子树
    			//往上找到第一个节点，该节点是他父节点的左子节点
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
