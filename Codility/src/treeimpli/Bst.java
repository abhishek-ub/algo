package treeimpli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bst {
	private Node root;
	
	public Bst(){
	}
	private static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int data){
			this.data=data;
		}
		public int  getData(){
			return this.data;
		}
		
	}
	
	/*
	 * Given an sorted array the method builds an BST
	 * of minimum depth
	 */
	public void buildTree(int... arr){
		root=buildTree(arr,0,arr.length-1);
	}
	private Node buildTree(int[] arr,int s,int e){
		if(e<s){
			return null;
		}
		int mid=s+(e-s)/2;
		Node n=new Node(arr[mid]);
		n.left=buildTree(arr,s,mid-1);
		n.right=buildTree(arr,mid+1, e);
		return n;
	}
	/*
	 * InOrder Traversal
	 */
	public ArrayList<Integer> getInorder(){
		ArrayList<Integer>arrl=new ArrayList<Integer>();
		getInorder(this.root,arrl);
		return arrl;
	}
	
	private void getInorder(Node n,ArrayList<Integer> arrl){
		if(n==null){
			return;
		}
		getInorder(n.left,arrl);
		arrl.add(n.getData());
		getInorder(n.right,arrl);
		
	}
	
	/*
	 * PreOrder Traversal
	 */
	public ArrayList<Integer> getPreorder(){
		ArrayList<Integer>arrl=new ArrayList<Integer>();
		getPreorder(this.root,arrl);
		return arrl;
	}
	
	private void getPreorder(Node n,ArrayList<Integer> arrl){
		if(n==null){
			return;
		}
		arrl.add(n.getData());
		getPreorder(n.left,arrl);
		getPreorder(n.right,arrl);
		
	}
	
	/*
	 * PostOrder Traversal
	 */
	public ArrayList<Integer> getPostorder(){
		ArrayList<Integer>arrl=new ArrayList<Integer>();
		getPostorder(this.root,arrl);
		return arrl;
	}
	
	private void getPostorder(Node n,ArrayList<Integer> arrl){
		if(n==null){
			return;
		}
		
		getPostorder(n.left,arrl);
		getPostorder(n.right,arrl);
		arrl.add(n.getData());
		
	}
	/*
	 * Method returns list of elements 
	 * in different tree level
	 * 
	 * weigh in implementation of BFS
	 */
	public ArrayList<ArrayList<Integer>>getLevelList(){
		ArrayList<ArrayList<Integer>>result=new ArrayList<ArrayList<Integer>>();
		
		Queue<Node>frontline=new LinkedList<Node>() ;
		Queue<Node>backline=new LinkedList<Node>() ;
		frontline.add(root);
		
		while(frontline.size()!=0){
			ArrayList<Integer>arr=new ArrayList<Integer>();
			backline=frontline;
			frontline=new LinkedList<Node>() ;
			while(backline.size()!=0){
				Node n=backline.poll();
				if(n!=null){
					if(n.left!=null){
						frontline.add(n.left);
					}
					if(n.right!=null){
						frontline.add(n.right);
					}
					arr.add(n.data);
				}
				
			}
			result.add(arr);
		}
		
		return result;
	}
	
	public static void main(String... args) {
		int[] arr={1,2,3,4,5,6,7,8};
		Bst bst=new Bst();
		bst.buildTree(arr);
		ArrayList<Integer>inorder=bst.getInorder();
		ArrayList<Integer>preorder=bst.getPreorder();
		ArrayList<Integer>postorder=bst.getPostorder();
		
		System.out.println(inorder);
		System.out.println(preorder);
		System.out.println(postorder);
		
		ArrayList<ArrayList<Integer>>result=bst.getLevelList();
		System.out.println(result);
	}
}
