//Grind 75 problem #11
//finds the Lowest Common ancestor in a BST

import java.util.*;

class Lowest_Common_Ancestor_11{

	public TreeNode root;	
	
	private class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}		
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Lowest_Common_Ancestor_11 lca = new Lowest_Common_Ancestor_11();
		System.out.print("Enter list [x,y,z] : root = ");
		String s = in.nextLine();
		System.out.print("p > ");
		String p = in.nextLine();
		int pi = Integer.parseInt(p);
		System.out.print("q > ");
		String q = in.nextLine();
		int qi = Integer.parseInt(q);
		s = s.substring(1, s.indexOf("]"));
		String[] t = s.split(",");
		int[] values = new int[t.length];
		for(int i=0; i<t.length; i++){
			if(!t[i].equals("null")){
				values[i] = Integer.valueOf(t[i].trim());
			}
		}
		
		for(int i=0; i<values.length; i++){
			lca.makeTree(values[i]);
		}
		
		lca.solve(pi, qi);
	}
	
	private void solve(int p, int q){
		root = solveBST(root, p, q);
		System.out.println(root.val);
	}
	
	private TreeNode solveBST(TreeNode root, int p, int q){
		if(root == null){
			return root;
		}
		if(root != null){
			if(root.val > p && root.val > q){
				root = solveBST(root.left, p, q);
			}
			if(root.val < p && root.val < q){
				root = solveBST(root.right, p, q);
			}
			if(root.val == p || root.val == q){
				return root;
			}
		}
		return root;
	}
	
	private void makeTree(int x){
		root = makeTreeBST(root, x);
	}
	
	private TreeNode makeTreeBST(TreeNode root, int x){
		if(root == null){
			root = new TreeNode(x);
			return root;
		}
		if(x < root.val){ 
			root.left = makeTreeBST(root.left, x);
		}
		if(x > root.val){
			root.right = makeTreeBST(root.right, x);
		}
		return root;
	}
	
	private void print(){
		printTreeBST(root);
	}
	
	private void printTreeBST(TreeNode root){
		if(root != null){
			System.out.println(root.val + " ");
			printTreeBST(root.left);
			printTreeBST(root.right);
		}
	}
}
