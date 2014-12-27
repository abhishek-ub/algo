

public class BinarySearchTree {

	private Node root;
	private StringBuilder inorder;
	
	public static class Node{
		public Integer data;
		public Node left;
		public Node right;
		
		public String getData(){
			return Integer.toString(data);
		}
	}
	
	public BinarySearchTree(Integer rootdata){
		root=new Node();	
		root.data=rootdata;
	}
	
	public void insert(Integer data){
		Node temp=root;
		Node prev=temp;
		int l=0;
		while(temp!=null){
			if(data<=temp.data){
				prev=temp;
				temp=temp.left;
				l=1;
			}else{
				prev=temp;
				temp=temp.right;
				l=0;
			}
		}
		if(l==1){
			prev.left=new Node();
			prev.left.data=data;
		}else{
			prev.right=new Node();
			prev.right.data=data;
		}
		
	}
	/*
	 * Method deletes the first occurrence of element if found and
	 * moves the right child in its place
	 * @param element to be deleted
	 */
	public boolean delete(Integer data){
		if(data==root.data){
			if(root.left!=null){
				Node left=root.left;
				root=root.right;
				Node temp=root;
				Node prev=temp;
				while(temp!=null){
					prev=temp;
					temp=temp.left;
				}
				prev.left=left;
				return true;
			}else{
				root=root.right;
				return true;
			}
		}else{
			Node temp=root;
			Node prev=temp;
			int l=0;
			while(temp!=null){
				if(data<temp.data){
					prev=temp;
					temp=temp.left;
					l=1;
				}else if(data>temp.data){
					prev=temp;
					temp=temp.right;
					l=0;
				}else{
					if(temp.right!=null){
						Node left=temp.left;
						temp=temp.right;
						Node t=temp;
						Node p=t;
						while(t!=null){
							p=t;
							t=t.left;
						}
						p.left=left;
					}else{
						temp=temp.left;
					}
					
					if(l==1){
						prev.left=temp;
					}else{
						prev.right=temp;
					}
					
					return true;
				}
			}
		}
		
		System.out.println("Element Not found");
		return false;
	}
	/*
	 * Method to return inOrder traversal of 
	 * Tree as string representation
	 * 
	 */
	
	public String inOrder(){
		this.inorder=new StringBuilder();
		inOrder(root);
		return inorder.toString();
	}
	
	
	private void inOrder(Node head){
		if(head==null)return;
		inOrder(head.left);
		inorder.append(head.getData()+" ");
		inOrder(head.right);
		
	}
	
	
	public Node getRoot(){
		return root;
	}
	/*
	 * This can potentially make tree non Binary search
	 * Implementation should ensure the root being set is binary
	 * 
	 */
	public void setRoot(Node n){
		root=n;
	}
	
	/*
	 * Method to return minimum depth of tree 
	 */
	public int minHeight(){
		return minHeight(root);
	}
	
	private int minHeight(Node n){
		if(n==null)return 0;
		
		return 1+Math.min(minHeight(n.left),minHeight(n.right));
	}
	
	/*
	 * Method to return maximum depth of tree 
	 */
	public int maxHeight(){
		return maxHeight(root);
	}
	private int maxHeight(Node n){
		if(n==null)return 0;
		
		return 1+Math.max(maxHeight(n.left),maxHeight(n.right));
	}
}
