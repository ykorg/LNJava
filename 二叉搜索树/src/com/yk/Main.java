package com.yk;

import java.util.Comparator;

import com.mj.printer.BinaryTrees;
import com.yk.BinarySearchTree.Visitor;

class Main {
	
	private static class MyComparetor implements Comparator<Person>{
		@Override
		public int compare(Person e1, Person e2) {
			return e1.getAge() - e2.getAge();
		}
	}
	public static void main(String[] args) {

//		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
//		int[] datas = new int[] {7,4,9,2,5,9,11,3};
//		for (int i = 0; i < datas.length; i++) {
//			bst.add(datas[i]);
//		}
		
//		BinarySearchTree<Person> bst = new BinarySearchTree<>();
//		int[] datas = new int[] {7,4,9,2,5,9,11,3};
//		for (int i = 0; i < datas.length; i++) {
//			bst.add(new Person(datas[i]));
//		}
		
//		MyComparetor mComparetor = new  MyComparetor();
//		BinarySearchTree<Person> bst = new BinarySearchTree<>(new  MyComparetor());
		
//		BinarySearchTree<Person> bst = new BinarySearchTree<>(new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				// TODO Auto-generated method stub
//				return o1.getAge() - o2.getAge();
//			}
//			
//		});
		
		
//		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
//		int[] datas = new int[] {7,4,2,1,5,13,14,6,11,10,9,8,12};
//		for (int i = 0; i < datas.length; i++) {
//			bst.add(datas[i]);
//		}
//		BinaryTrees.println(bst); 
//		bst.remove(7);
//		System.out.println();
//		BinaryTrees.println(bst); 

		int a[]={1,2,3,4,5,6,7,8,9,10,11,12};
		prem(a,0,a.length-1);
		
		
	}
	
	public static void swap(int arr[],int a,int b){
		int temp;
		temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void prem(int arr[],int start,int end){
		if(start==end){
			for(int i=0;i<=end;++i){
				System.out.print(arr[i]);
			}
			System.out.println();
		}else{
			for(int j=start;j<=end;++j){
				swap(arr,start,j);
				prem(arr,start+1,end);
				swap(arr,start,j);
			}
		}
	}
	
	

}
