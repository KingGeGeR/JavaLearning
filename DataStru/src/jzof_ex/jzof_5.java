package jzof_ex;

import datastu.TreeNode;

public class jzof_5 {
	
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	//��Ϊ��
    	TreeNode myTree=null;
    	if(pre.length==0) {
    		myTree=null;
    	}else {
    		//�ҵ����ڵ�,���ֱ𽫸��������������������ֱ��Ž����飬�ٷֱ𽫸��������������������ֱ�������
			myTree= new TreeNode(pre[0],null,null);//����new�µĽڵ�
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
				leftin[j] = in[j];//��ʼλ�ø����
			}
			for (int k = 0; k < in.length - leftLen - 1; k++) {//��ֹ���������
				rightpre[k] = pre[leftLen + k + 1];
				rightin[k] = in[leftLen + k + 1];
			}
			// �ؽ����ڵ��������
			myTree.left = reConstructBinaryTree(leftpre, leftin);
			// �ؽ����ڵ��������
			myTree.right = reConstructBinaryTree(rightpre, rightin);				
    	}
    	return myTree;//����û����
    }
}
