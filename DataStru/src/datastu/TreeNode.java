package datastu;

//定义了一个可以存储任何类型的泛型树节点T
public class TreeNode<T>{
  public T data;
  public TreeNode<T> left;
  public TreeNode<T> right;
  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
      this.data = data;
      this.left = left;
      this.right = right;
  }
}
