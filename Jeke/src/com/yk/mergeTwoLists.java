package com.yk;

import java.util.ArrayList;
import java.util.List;

public class mergeTwoLists {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		
		List<List<Integer>> resulitArrayList = reconstructMatrix(5, 5, new int[] {2,1,2,0,1,0,1,2,0,1});
		for (int i = 0; i < resulitArrayList.size(); i++) {
			for (int j = 0; j < resulitArrayList.get(i).size(); j++) {
				System.out.printf("%d ", resulitArrayList.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
/*
 * 
 * 	[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
  ]
 * */
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int x = matrix[0].length - 1, y = 0;
		while (y < matrix.length && x >= 0) {
			if (matrix[x][y] > target) {
				x--;
			}else if (matrix[x][y] == target) {
				return true;
			}else {
				y++;
			}
		}
		return false;
    }
	
	
	 public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		 List<Integer> inner1ArrayList = new ArrayList<Integer>(colsum.length);
		 List<Integer> inner2ArrayList = new ArrayList<Integer>(colsum.length);
		for (int i = 0; i < colsum.length; i++) {
			inner1ArrayList.add(i, 0);
			inner2ArrayList.add(i, 0);
		}

		List<List<Integer>> resList = new ArrayList<List<Integer>>(2);
		resList.add(inner1ArrayList);
		resList.add(inner2ArrayList);
		
		for (int i = 0; i < colsum.length; i++) {
			int lcolumn = colsum[i];
			int sum = 0;
			int sum2 = 0;
			for (int j = 0; j < colsum.length; j++) {
				sum += inner1ArrayList.get(j);
				sum2 += inner2ArrayList.get(j);
			}
			if (lcolumn == 2) {
				if (sum < upper) {
					inner1ArrayList.set(i,1);
				}
				if (sum2 < lower){
					inner2ArrayList.set(i,1);
				}
				if (sum2 == lower && sum == upper) {
					resList.remove(0);
					resList.remove(0);
					break;
				}
			}else if (lcolumn == 1) {
				if (sum < upper) {
					inner1ArrayList.set(i,1);
				}else if (sum2 < lower){
					inner2ArrayList.set(i,1);
				}else {
					resList.remove(0);
					resList.remove(0);
					break;
				}
			}else {
				
			}
		}
		return resList;
	 }
}
