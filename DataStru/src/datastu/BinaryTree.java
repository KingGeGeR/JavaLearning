package datastu;

import java.util.LinkedList;

public class BinaryTree<T> {

	/*
	 * 先序创建二叉树
	 * 返回：根节点
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
       * 先序遍历二叉树（递归）
     */
	public void PrintBinaryTreePreRecur(TreeNode<T> root) {
		
		if(root!=null) {
			//先序訪問根節點  
			System.out.print(root.data);
			//先序访问根节点的左子树
			PrintBinaryTreePreRecur(root.left);
			//先序访问根节点的右子树
			PrintBinaryTreePreRecur(root.right);
		}
	}
	
	/*
     * 中序遍历二叉树（递归）
   */
	public void PrintBinaryTreeMidRecur(TreeNode<T> root) {

		if (root != null) {
			// 中序访问根节点的左子树
			PrintBinaryTreeMidRecur(root.left);
			// 中序访问根节点
			System.out.print(root.data);
			// 中序访问根节点的右子树
			PrintBinaryTreeMidRecur(root.right);
		}
	}
	
	/*
     * 后序遍历二叉树（递归）
   */
	public void PrintBinaryTreeBacRecur(TreeNode<T> root) {

		if (root != null) {
			// 后序访问根节点的左子树
			PrintBinaryTreeBacRecur(root.left);			
			// 后序访问根节点的右子树
			PrintBinaryTreeBacRecur(root.right);
			// 后序访问根节点
			System.out.print(root.data);
		}
	}
	
	/*
     * 先序遍历二叉树（非递归）
     * 思路：对于任意节点T，访问这个节点并压入栈中，然后访问节点的左子树，
     *      遍历完左子树后，取出栈顶的节点T，再先序遍历T的右子树
     */
	public void PrintBinaryTreePreUnrecur(TreeNode<T> root) {
		
        TreeNode<T> p=root;//p为当前节点
        LinkedList<TreeNode<T>> stack=new LinkedList<>();
        //栈不为空时，或者p不为空时循环
        while(p!=null || !stack.isEmpty()){
            //当前节点不为空。访问并压入栈中。并将当前节点赋值为左儿子
            if (p!=null){
                stack.push(p);
                System.out.print(p.data);
                p=p.left;
            }else{//当前节点为空：
                //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
                //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
                //取出栈顶元素，赋值为right
                p=stack.pop();
                p=p.right;
            }
        }
	}
	
	public void PrintBinaryTreePreUnrecur2(TreeNode<T> root) {
		//自己写的这个方法很不好，就在于会把null给push进去
        TreeNode<T> p=root;//p为当前节点
        LinkedList<TreeNode<T>> stack=new LinkedList<>();
        //栈不为空时，或者p不为空时循环
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
                if(p.left==null&&p.right==null){//这边当时出问题了
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
	 * 中序遍历二叉树（非递归）
	 * 
	 * 思路：先将T入栈，遍历左子树；遍历完左子树返回时，栈顶元素应为T， 出栈，访问T->data，再中序遍历T的右子树。
	 */
	public void PrintBinaryTreeMidUnrecur(TreeNode<T> root) {
		TreeNode<T> p=root;//p为当前节点
        LinkedList<TreeNode<T>> stack=new LinkedList<>();
        //栈不为空时，或者p不为空时循环
        while(p!=null || !stack.isEmpty()){
            //当前节点不为空。访问并压入栈中。并将当前节点赋值为左儿子
            if (p!=null){
                stack.push(p);
                p=p.left;
            }else{//当前节点为空：
                //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
                //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
                //取出栈顶元素，赋值为right
                p=stack.pop();
                System.out.print(p.data);
                p=p.right;
            }
        }
	}
	
	/*
     * 后序遍历二叉树（非递归）
     *  
     */
    public void PrintBinaryTreeBacUnrecur(TreeNode<T> root)
    {
        class NodeFlag<T>{
            TreeNode<T> node;//TreeNode是NodeFlag的一个内部类，是一个HAS—A的关系
            char tag;
            public NodeFlag(TreeNode<T> node, char tag) {
                super();//构造函数不能被继承
                this.node = node;//树的结构
                this.tag = tag;//节点的标志
            }
        }
        LinkedList<NodeFlag<T>> stack=new LinkedList<>();//动态数组实现的栈,用的push和pop,注意
        TreeNode<T> p=root;
        NodeFlag<T> bt;//这里局部变量确实还没有初始化
        //栈不空或者p不空时循环  
        while(p!=null || !stack.isEmpty()){
            //遍历左子树
            while(p!=null){
                bt=new NodeFlag(p, 'L');//但是在这里bt完成了初始化
                stack.push(bt);
                p=p.left;
            }
            //左右子树访问完毕访问根节点 
            while(!stack.isEmpty() && stack.getFirst().tag=='R'){//栈顶树节点的标志要为右
                bt=stack.pop();
                System.out.print(bt.node.data);
            }
            //遍历右子树,并标记
            if (!stack.isEmpty()){
                bt=stack.peek();
                bt.tag='R';
                p=bt.node;
                p=p.right;
            }
        }
    }
	
    /*
     * 层次遍历二叉树（非递归）   
     * 方法1是无法知道有几层的
     * 而方法二是可以知道有几层的
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
    	LinkedList<TreeNode> queue=new LinkedList<>();//用动态数组实现的队列
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
             * 测试二叉树的  创建、遍历
            * 二叉树结构如下
         *            A
         *       B         C
         *    D     E   F     G
         *  H   I        J 
         */
        //输入ABDH##I##E##CF#J##G##（#用null代替）
        LinkedList<Character> tree=new LinkedList<>();
        tree.add('A');tree.add('B');tree.add('D');
        tree.add('H');tree.add(null);tree.add(null);
        tree.add('I');tree.add(null);tree.add(null);
        tree.add('E');tree.add(null);tree.add(null);
        tree.add('C');tree.add('F');tree.add(null);
        tree.add('J');tree.add(null);tree.add(null);
        tree.add('G');tree.add(null);tree.add(null);

        TreeNode<Character> root=binaryTree.creatBinaryPre(tree);

        //先序遍历（递归）
        binaryTree.PrintBinaryTreePreRecur(root);System.out.println("先序遍历（递归）");
        //中序遍历（递归）
        binaryTree.PrintBinaryTreeMidRecur(root);System.out.println("中序遍历（递归）");
        //后序遍历（递归）
        binaryTree.PrintBinaryTreeBacRecur(root);System.out.println("后序遍历（递归）");


        //先序遍历（非递归）
        binaryTree.PrintBinaryTreePreUnrecur(root);System.out.println("先序遍历（非递归）");
        //中序遍历（非递归）
        binaryTree.PrintBinaryTreeMidUnrecur(root);System.out.println("中序遍历（非递归）");
        //后序遍历（非递归）
        binaryTree.PrintBinaryTreeBacUnrecur(root);System.out.println("后序遍历（非递归）");
        //层次遍历（非递归）
        binaryTree.PrintBinaryTreeLayerUnrecur(root);System.out.println("层次遍历（非递归）");
        //先序遍历（非递归）
        binaryTree.PrintBinaryTreePreUnrecur2(root);System.out.println("先序 myway");
        binaryTree.PrintBinaryTreeLayerUnrecur2(root);System.out.println("层次遍历（非递归）myway");
    }
}
