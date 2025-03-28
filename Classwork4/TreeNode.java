package Classwork4;

public class TreeNode<E>{
	E data;
	TreeNode<E> leftchild;
	TreeNode<E> rightchild;
	//TreeNode<E> parent;
	
	public TreeNode(E e) {
		data = e;
		leftchild = null;
		rightchild = null;
	}
}
