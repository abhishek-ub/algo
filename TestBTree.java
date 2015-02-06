

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBTree {

	@Test
	public void test() {
		
		BinarySearchTree bt=new BinarySearchTree(2);
		bt.insert(1);
		bt.insert(4);
		bt.insert(3);
		bt.insert(8);
		bt.insert(10);
		bt.insert(5);
		bt.insert(-3);
		bt.insert(-4);
		bt.insert(-1);
		System.out.println(bt.inOrder());
		if(!bt.delete(-3))System.out.println("Failed to delete");
		System.out.println(bt.inOrder());
		assertTrue(bt.inOrder().contains("-4 -1 1 2 3 4 5 8 10"));
		
		int [] arr={1,2,3,4,5,6,7,8,9,10,11,12};
		BinarySearchTree minBST=minimalBST(arr);
		System.out.println(minBST.inOrder());
		System.out.println(minBST.minHeight());
		System.out.println(minBST.maxHeight());
		assertEquals(minBST.minHeight(), 3);
		assertEquals(minBST.maxHeight(), 4);
	}
	
	/*
	 * Given an sorted array
	 * Method returns a balances B tree
	 */
	public BinarySearchTree minimalBST(int[] arr){
		if(arr.length==0){
			return null;
		}else{
			BinarySearchTree bt=new BinarySearchTree(arr[(0+arr.length)/2]);
			bt.setRoot(minimalBST(arr,0,arr.length-1));
			return bt;
		}
	}
	
	private Node minimalBST(int[] arr,int start,int end){
		if(start>end) return null;
		int mid=(start+end)/2;
		Node bnd=new Node();
		bnd.data=arr[mid];
		bnd.left=minimalBST(arr,start,mid-1);
		bnd.right=minimalBST(arr,mid+1,end);
		return bnd;
	}

	
	
	
}
