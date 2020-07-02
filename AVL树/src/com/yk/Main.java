package com.yk;


import com.mj.printer.BinaryTrees;

class Main {
	
	public static void main(String[] args) {
		
		
		AVL<Integer> bst = new AVL<Integer>();
		int[] datas = new int[] {7,4,2,1,5,13,14,6,11,10,9,8,12};
		for (int i = 0; i < datas.length; i++) {
			bst.add(datas[i]);
		}
		BinaryTrees.println(bst); 
		bst.remove(7);
		System.out.println();
		BinaryTrees.println(bst); 
		
	}
	
	

}
