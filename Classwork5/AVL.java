package Classwork5;

public class AVL {
	private AVLNode root;
	
	AVL(){
		root = null;
	}
	
	//erase the old tree when reading the next line
	public void delete() {
		root = null;
	}
	
	//calls the private insert method
	public void insert(AVLNode n) {
		root = insertHelper(root, n);
		
	}

	private AVLNode insertHelper(AVLNode curr, AVLNode node) {
		if (curr == null) {
			curr = node;
		}
		else {
			if (node.data < curr.data) {
				curr.left = insertHelper(curr.left, node);
				curr.left.parent = curr;
				curr.leftHeight++;
				updateHeight(curr);
			}
			else if (node.data > curr.data) {
				curr.right = insertHelper(curr.right, node);
				curr.right.parent = curr;
				curr.rightHeight++;
				updateHeight(curr);
			}
		}

		if (getBalance(curr) == 2){
			if (getBalance(curr.left) == 1){
				curr = rightRotate(curr);
			}
			else if (getBalance(curr.left) == -1){
				curr.left = leftRotate(curr.left);
				curr = rightRotate(curr);
			}
		}

		if (getBalance(curr) == -2) {
			if (getBalance(curr.right) == -1){
				curr = leftRotate(curr);
			}
			else if (getBalance(curr.right) == 1){
				curr.right = rightRotate(curr.right);
				curr = leftRotate(curr);
			}
		}


		return curr;
	} 

//	1. rotate right at 7    		|  2. rotate left at 5 then right at 7  
//			    7						    7								
//		      /  \					  	  /   \
//		    5     null                   5     null
//		   /						    / \
//		 3						    null   3
	
//	1. rotate left at 7             |  2. rotate right at 5 then left at 7  
//			     7						     7								
//  	       /  \					  	   /   \
//         null    5                    null    5
//                  \						   / \
//                   3						 3    null

	
	private AVLNode rightRotate(AVLNode curr) {
		AVLNode temp = curr.left;
		curr.left = temp.right;
		temp.right = temp.parent;
		temp.parent = curr.parent;
		curr.parent = temp;
		updateHeight(temp);
		updateHeight(curr);
		return temp;
	}
	
	private AVLNode leftRotate(AVLNode curr) {
		AVLNode temp = curr.right;
		curr.right = temp.left;
		temp.left = curr;
		temp.parent = curr.parent;
		curr.parent = temp;
		updateHeight(temp);
		updateHeight(curr);
		return temp;
	}
	
	private int getBalance(AVLNode node) {
		return node.leftHeight-node.rightHeight; //returns the balance of the node
												 //helps determine when to re-balance
	}
	
	private void updateHeight(AVLNode node) { //updates the height of the node
		
		if(node.left != null) 		//the left height
			node.leftHeight = node.left.height;
		else 
			node.leftHeight = -1;
		
		if(node.right != null)		//the right height
			node.rightHeight = node.right.height;
		else
			node.rightHeight = -1;
		
		node.height = max(node.leftHeight, node.rightHeight)+1; //get the height of the node 
		
	}
	
	private int max(int n, int m) {
		if(n >= m)
			return n;
		else 
			return m;
	}
	
	
	public void printAVL() {
		if(root!= null) {
			printAVL(root);
		}
	}
	private void printAVL(AVLNode bst) { //pre-order traversal of the AVL
		if(bst != null) {
			System.out.print(bst.data);
			printAVL(bst.left);
			printAVL(bst.right);
		}
		
	} 
	
}
