package Classwork4;
import java.util.LinkedList;
import java.util.Queue;

public class Tree<E> {
	
	TreeNode<E> root;
	int size;
	
	public Tree(E rootData) {
        root = new TreeNode<>(rootData);
        size = 1;
    }

	public E element(TreeNode<E> node) {
		if(node == null) return null;
		return node.data;
	}
	
	public TreeNode<E> getParent(TreeNode<E> node) {
		Queue<TreeNode<E>> list = new LinkedList<>(); 
		if (node == root || node == null){
			return null;
		}
		list.add(root);
		while (!list.isEmpty()){
			TreeNode<E> cur = list.remove();
			if (cur.leftchild == node || cur.rightchild == node) {
				return cur;
			}
			if (cur.leftchild != null) list.add(cur.leftchild); 
			if (cur.rightchild != null) list.add(cur.rightchild);
		}
		return null; 
	}
	
	public LinkedList<TreeNode<E>> getChildren(TreeNode<E> node) {
		LinkedList<TreeNode<E>> children = new LinkedList<>();
		if (node.leftchild != null){
			children.add(node.leftchild);
		}
		if (node.rightchild != null) {
			children.add(node.rightchild);
		}
		if (node.leftchild == null && node.rightchild == null){
			return null;
		}
		return children;
	}
	
	
	public boolean isRoot(TreeNode<E> node) {
		if (node == root){
			return true;
		}
		return false;
	}
	
	public boolean isExternal(TreeNode<E> node) {
		if (node.leftchild == null && node.rightchild == null){
			return true;
		}
		return false;
	}
	
	public boolean isInternal(TreeNode<E> node) {
		if (node.leftchild != null || node.rightchild != null){
			return true;
		}
		return false;
	}
	
	public int nodeDepth(TreeNode<E> node) {
		int depth = 0;
		while(getParent(node) != null){
			node = getParent(node);
			depth += 1;
		}
		return depth;
	}
	
	public int treeHeight() {
		if (root == null) return -1;
		int maxDepth = 0;
		Queue<TreeNode<E>> nodes = new LinkedList<>();
		nodes.add(root);
		while(!nodes.isEmpty()){
			TreeNode<E> cur = nodes.remove();
			if(isExternal(cur) && nodeDepth(cur) > maxDepth) {
				maxDepth = nodeDepth(cur);
			}
			if (cur.leftchild != null) nodes.add(cur.leftchild);
			if (cur.rightchild != null) nodes.add(cur.rightchild);
		}
		return maxDepth;

	}
	
	public int size() {
		return countNodes(root);
	}

	public int countNodes(TreeNode<E> node) {
		if (node == null) return 0;
		return(1 + countNodes(node.leftchild) + countNodes(node.rightchild));
	}
	
	
	
}
