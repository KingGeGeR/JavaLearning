package jzof_ex;

import datastu.TreeNode;

public class jzof_5 {
	
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	//不为空
    	TreeNode myTree=null;
    	if(pre.length==0) {
    		myTree=null;
    	}else {
    		//找到根节点,并分别将根的左子树的先序和中序分别存放进数组，再分别将根的右子树的先序和中序分别存进数组
			myTree= new TreeNode(pre[0],null,null);//忘记new新的节点
			int leftLen = 0;
			for (int i = 0; i < in.length; i++) {
				if (in[i] == pre[0]) {
					leftLen = i;
					break;
				}
			}
			int[] leftpre = new int[leftLen];
			int[] leftin = new int[leftLen];
			int[] rightpre = new int[in.length - leftLen - 1];
			int[] rightin = new int[in.length - leftLen - 1];
			for (int j = 0; j < leftLen; j++) {
				leftpre[j] = pre[j+1];
				leftin[j] = in[j];//起始位置搞错了
			}
			for (int k = 0; k < in.length - leftLen - 1; k++) {//终止条件搞错了
				rightpre[k] = pre[leftLen + k + 1];
				rightin[k] = in[leftLen + k + 1];
			}
			// 重建根节点的左子树
			myTree.left = reConstructBinaryTree(leftpre, leftin);
			// 重建根节点的右子树
			myTree.right = reConstructBinaryTree(rightpre, rightin);				
    	}
    	return myTree;//返回没搞清
    }
}
