package com.yk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ArraySample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("hello array");
//		int[] arr = {-1,0,1,2,-1,-4};
//		threeTotal(arr,0);
		
//     System.out.println("5 的斐波那契: "+fibonaqi(5));
		
//		int [] arr =new int [] {2,11,7, 15};
//		int target = 9;
// 		int [] result = twoSumSolution1(arr,target);
// 		
// 		for (int i = 0; i < result.length; i++) {
//			System.out.println("index="+result[i]);
//		}

//		boolean isContain = twoDoubleSolution1(82);
//		System.out.println("是否包含两个整数的平方和等于5 ? " + (isContain ? "包含": "不包含"));
		
//		boolean isHui = huiwen("abcdecba");
//		System.out.println("是回文吗? " + (isHui ? "是" : "不是"));
		
		
//		nums1 = [1,2,3,4,0,0,0], m = 4
//				nums2 = [2,5,6],n = 3
//				Output: [1,2,2,3,4,5,6]
				
		ArraySample sample = new ArraySample();
		int [] arr1 = new int[] {1,2,3,4,0,0,0};
		int [] arr2 = new int[] {2,5,6};
		sample.merge(arr1,4,arr2,3);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
	}
	
	//nums = {-1,0,1,2,-1,-4}
	
	public static void threeTotal(int[] arr,int target) {
		ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>();
		HashMap<Integer , Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(i, arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			int firstValue = arr[i];
			int twoSums = target - firstValue;
			arr = volume(arr,firstValue);
			int[] lastDatas = twoSum(arr, twoSums);
			if (lastDatas.length > 0) {
				arrayList.add(new Integer[] {firstValue,lastDatas[0],lastDatas[1]});
			}
		}
		for (int i = 0; i < arrayList.size(); i++) {
			Integer[] tarr = arrayList.get(i);
			System.out.println("" +tarr[0] + " " + tarr[1] + " " +tarr[2]);
		}
	}
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return new int[] {};
    }
	private static int[] volume(int[] arr, int key) {
        int count = 0;
        for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
            if (arr[i] == key && i != j)
                count++;
            if (arr[j] == key && i != j)
                count++;
            if (arr[i] == key && i == j)
                count++;
        }
        int nrr[] = new int[arr.length - count];
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                continue;
            else 
                nrr[count++] = arr[i];
        }
        return arr = nrr;
    }
///斐波那契
	public static Integer fibonaqi (Integer target) {
		if (target == 0) {
			return 0;
		}		
		if (target == 1) {
			return 1;
		}
		return fibonaqi(target - 1) + fibonaqi(target - 2);
	}
	//
	public static int[] twoSumSolution1(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
 			int resulit = numbers[i] + numbers[j];
			if (resulit > target) {
				j--;
			}else if (resulit == target) {
				return new int [] {i,j};
			}else if (resulit < target) {
				i++;
			}
		}
		return new int [] {};
	}
	//题目描述：判断一个非负整数是否为两个整数的平方和。
	public static boolean twoDoubleSolution1(int target) {
		int i = 0;
		int j = target;
		while (i < j) {
 			int result = i*i + j * j ;
 			if (result > target) {
				j--;
			}else if (result < target) {
				i++;
			}
 			else if (result == target) {
				return true;
			}
		}
		return false;
	}
	// 题目描述：可以删除一个字符，判断是否能构成回文字符串。
    //所谓的回文字符串，是指具有左右对称特点的字符串，例如 "abcba" 就是一个回文字符串。abcdedkcba
	public static boolean huiwen(String sourceString) {
		int i = 0;
		int j = sourceString.length() - 1;
		while (i < j) {
			i++;
 			j--;
			char first = sourceString.charAt(i);
 			char last = sourceString.charAt(j);
			if (first != last) {
				return isHui(sourceString, i+1, j) || isHui(sourceString, i, j-1);
			}
 			
		}
		return true;
	}
	//abcdedkcba =====> dedk
	public static boolean isHui(String sourceString,int firstIndex,int lastIndex) {
		int i = firstIndex;
		int j = lastIndex;
		boolean isH = false;
		while (i < j) {
			char first = sourceString.charAt(i);
 			char last = sourceString.charAt(j);
 			if (first != last) {
 				return false;
			}
 			i++;
 			j--;
		}
		return true;
	}
	
	public static boolean validPalindrome(String s) {
	    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
	        if (s.charAt(i) != s.charAt(j)) {
	            return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
	        }
	    }
	    return true;
	}

	private  static  boolean isPalindrome(String s, int i, int j) {
	    while (i < j) {
	        if (s.charAt(i++) != s.charAt(j--)) {
	            return false;
	        }
	    }
	    return true;
	}
//	题目描述：把归并结果存到第一个数组上。
//	Input:
//	nums1 = [1,2,3,4,0,0,0], m = 4
//			nums2 = [2,5,6],n = 3
//			Output: [1,2,2,3,4,5,6]
//	[0,0],0,[1,2],2
//	[1,2],2,[0],0
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		System.out.println("merge");
		int i = m - 1;
		int j = n - 1;
		int total = m+n-1;
		while (i >=0 || j >=0) {
			
			if (i < 0) {
				nums1[total] = nums2[j];
				j--;
			}else if (j < 0) {
				nums1[total] = nums1[i];
				i--;
			}
			else if (nums1[i] < nums2[j]) {
					nums1[total] = nums2[j];
					j--;
			}else if (nums1[i] == nums2[j]) {
					j--;
					nums1[total] = nums1[i];
			}else {
					nums1[total] = nums1[i];
					i--;
			}	
			total--;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(1);
    }
	
	
}
