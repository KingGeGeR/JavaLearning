package datastu;

import java.util.LinkedList;

public class BinaryTree<T> {

	/*
	 * ���򴴽�������
	 * ���أ����ڵ�
	 */
	public TreeNode<T> creatBinaryPre(LinkedList<T> treeData){
		
		TreeNode<T> root=null;
		T data=treeData.removeFirst();
		if(data!=null) {
			root=new TreeNode<T>(data,null,null);
			root.left=creatBinaryPre(treeData);
			root.right=creatBinaryPre(treeData);
		}
		return root;
	}
	
	/*
       * ����������������ݹ飩
     */
	public void PrintBinaryTreePreRecur(TreeNode<T> root) {
		
		if(root!=null) {
			//�����L�������c  
			System.out.print(root.data);
			//������ʸ��ڵ��������
			PrintBinaryTreePreRecur(root.left);
			//������ʸ��ڵ��������
			PrintBinaryTreePreRecur(root.right);
		}
	}
	
	/*
     * ����������������ݹ飩
   */
	public void PrintBinaryTreeMidRecur(TreeNode<T> root) {

		if (root != null) {
			// ������ʸ��ڵ��������
			PrintBinaryTreeMidRecur(root.left);
			// ������ʸ��ڵ�
			System.out.print(root.data);
			// ������ʸ��ڵ��������
			PrintBinaryTreeMidRecur(root.right);
		}
	}
	
	/*
     * ����������������ݹ飩
   */
	public void PrintBinaryTreeBacRecur(TreeNode<T> root) {

		if (root != null) {
			// ������ʸ��ڵ��������
			PrintBinaryTreeBacRecur(root.left);			
			// ������ʸ��ڵ��������
			PrintBinaryTreeBacRecur(root.right);
			// ������ʸ��ڵ�
			System.out.print(root.data);
		}
	}
	
	/*
     * ����������������ǵݹ飩
     * ˼·����������ڵ�T����������ڵ㲢ѹ��ջ�У�Ȼ����ʽڵ����������
     *      ��������������ȡ��ջ���Ľڵ�T�����������T��������
     */
	public void PrintBinaryTreePreUnrecur(TreeNode<T> root) {
		
        TreeNode<T> p=root;//pΪ��ǰ�ڵ�
        LinkedList<TreeNode<T>> stack=new LinkedList<>();
        //ջ��Ϊ��ʱ������p��Ϊ��ʱѭ��
        while(p!=null || !stack.isEmpty()){
            //��ǰ�ڵ㲻Ϊ�ա����ʲ�ѹ��ջ�С�������ǰ�ڵ㸳ֵΪ�����
            if (p!=null){
                stack.push(p);
                System.out.print(p.data);
                p=p.left;
            }else{//��ǰ�ڵ�Ϊ�գ�
                //  1����pָ��������ʱ����ʱջ��Ԫ�ر�Ȼ�����ĸ��ڵ�
                //  2����pָ����Ҷ���ʱ����ʱջ��Ԫ�ر�Ȼ������үү�ڵ�
                //ȡ��ջ��Ԫ�أ���ֵΪright
                p=stack.pop();
                p=p.right;
            }
        }
	}
	
	public void PrintBinaryTreePreUnrecur2(TreeNode<T> root) {
		//�Լ�д����������ܲ��ã������ڻ��null��push��ȥ
        TreeNode<T> p=root;//pΪ��ǰ�ڵ�
        LinkedList<TreeNode<T>> stack=new LinkedList<>();
        //ջ��Ϊ��ʱ������p��Ϊ��ʱѭ��
        try {
        	
        	while(p!=null)
            {
            	System.out.print(p.data);                
                if (p.left!=null) 
                {
                    stack.push(p.right);               
                    p=p.left;
                    continue;
                }
                if(p.right!=null) {
                	p=p.right;
                	continue;
                }
                if(p.left==null&&p.right==null){//��ߵ�ʱ��������
                	if(!stack.isEmpty()) {
                    	p=stack.pop(); 
                	}else {
                		p=null;
                	}
                 
                }
            }
        }catch(Exception ex) {
        	ex.printStackTrace();
        }finally {
        	
        }        
	}
	
	/*
	 * ����������������ǵݹ飩
	 * 
	 * ˼·���Ƚ�T��ջ������������������������������ʱ��ջ��Ԫ��ӦΪT�� ��ջ������T->data�����������T����������
	 */
	public void PrintBinaryTreeMidUnrecur(TreeNode<T> root) {
		TreeNode<T> p=root;//pΪ��ǰ�ڵ�
        LinkedList<TreeNode<T>> stack=new LinkedList<>();
        //ջ��Ϊ��ʱ������p��Ϊ��ʱѭ��
        while(p!=null || !stack.isEmpty()){
            //��ǰ�ڵ㲻Ϊ�ա����ʲ�ѹ��ջ�С�������ǰ�ڵ㸳ֵΪ�����
            if (p!=null){
                stack.push(p);
                p=p.left;
            }else{//��ǰ�ڵ�Ϊ�գ�
                //  1����pָ��������ʱ����ʱջ��Ԫ�ر�Ȼ�����ĸ��ڵ�
                //  2����pָ����Ҷ���ʱ����ʱջ��Ԫ�ر�Ȼ������үү�ڵ�
                //ȡ��ջ��Ԫ�أ���ֵΪright
                p=stack.pop();
                System.out.print(p.data);
                p=p.right;
            }
        }
	}
	
	/*
     * ����������������ǵݹ飩
     *  
     */
    public void PrintBinaryTreeBacUnrecur(TreeNode<T> root)
    {
        class NodeFlag<T>{
            TreeNode<T> node;//TreeNode��NodeFlag��һ���ڲ��࣬��һ��HAS��A�Ĺ�ϵ
            char tag;
            public NodeFlag(TreeNode<T> node, char tag) {
                super();//���캯�����ܱ��̳�
                this.node = node;//���Ľṹ
                this.tag = tag;//�ڵ�ı�־
            }
        }
        LinkedList<NodeFlag<T>> stack=new LinkedList<>();//��̬����ʵ�ֵ�ջ,�õ�push��pop,ע��
        TreeNode<T> p=root;
        NodeFlag<T> bt;//����ֲ�����ȷʵ��û�г�ʼ��
        //ջ���ջ���p����ʱѭ��  
        while(p!=null || !stack.isEmpty()){
            //����������
            while(p!=null){
                bt=new NodeFlag(p, 'L');//����������bt����˳�ʼ��
                stack.push(bt);
                p=p.left;
            }
            //��������������Ϸ��ʸ��ڵ� 
            while(!stack.isEmpty() && stack.getFirst().tag=='R'){//ջ�����ڵ�ı�־ҪΪ��
                bt=stack.pop();
                System.out.print(bt.node.data);
            }
            //����������,�����
            if (!stack.isEmpty()){
                bt=stack.peek();
                bt.tag='R';
                p=bt.node;
                p=p.right;
            }
        }
    }
	
    /*
     * ��α������������ǵݹ飩   
     * ����1���޷�֪���м����
     * ���������ǿ���֪���м����
     */
    public void PrintBinaryTreeLayerUnrecur(TreeNode<T> root)
    {
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode<T> p;
        queue.push(root);
        while(!queue.isEmpty())
        {
            p=queue.removeFirst();
            System.out.print(p.data);
            if (p.left!=null)
                queue.addLast(p.left);
            if (p.right!=null)
                queue.addLast(p.right);
        }
    }
    
    public void PrintBinaryTreeLayerUnrecur2(TreeNode<T> root) {
    	LinkedList<TreeNode> queue=new LinkedList<>();//�ö�̬����ʵ�ֵĶ���
    	queue.add(root);
    	int deepth=0;
    	while(!queue.isEmpty()) {
    		deepth++;
    		int length=queue.size();
    		int i=0;
    		while(i<length) {
    			System.out.print(queue.get(0).data);
    			if(queue.get(0).left!=null) {
    				queue.add(queue.get(0).left);
    			}
    			if(queue.get(0).right!=null) {
    				queue.add(queue.get(0).right);
    			}
    			queue.remove(0);
    			i++;
    		}
    	}
    	System.out.print(" "+deepth);
    }
    
    public void testTree() {
    	BinaryTree<Character> binaryTree=new BinaryTree<>();

        /*
             * ���Զ�������  ����������
            * �������ṹ����
         *            A
         *       B         C
         *    D     E   F     G
         *  H   I        J 
         */
        //����ABDH##I##E##CF#J##G##��#��null���棩
        LinkedList<Character> tree=new LinkedList<>();
        tree.add('A');tree.add('B');tree.add('D');
        tree.add('H');tree.add(null);tree.add(null);
        tree.add('I');tree.add(null);tree.add(null);
        tree.add('E');tree.add(null);tree.add(null);
        tree.add('C');tree.add('F');tree.add(null);
        tree.add('J');tree.add(null);tree.add(null);
        tree.add('G');tree.add(null);tree.add(null);

        TreeNode<Character> root=binaryTree.creatBinaryPre(tree);

        //����������ݹ飩
        binaryTree.PrintBinaryTreePreRecur(root);System.out.println("����������ݹ飩");
        //����������ݹ飩
        binaryTree.PrintBinaryTreeMidRecur(root);System.out.println("����������ݹ飩");
        //����������ݹ飩
        binaryTree.PrintBinaryTreeBacRecur(root);System.out.println("����������ݹ飩");


        //����������ǵݹ飩
        binaryTree.PrintBinaryTreePreUnrecur(root);System.out.println("����������ǵݹ飩");
        //����������ǵݹ飩
        binaryTree.PrintBinaryTreeMidUnrecur(root);System.out.println("����������ǵݹ飩");
        //����������ǵݹ飩
        binaryTree.PrintBinaryTreeBacUnrecur(root);System.out.println("����������ǵݹ飩");
        //��α������ǵݹ飩
        binaryTree.PrintBinaryTreeLayerUnrecur(root);System.out.println("��α������ǵݹ飩");
        //����������ǵݹ飩
        binaryTree.PrintBinaryTreePreUnrecur2(root);System.out.println("���� myway");
        binaryTree.PrintBinaryTreeLayerUnrecur2(root);System.out.println("��α������ǵݹ飩myway");
    }
}
