package com.yk;

public class QuickSortTest {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
		QuickSortTest test = new QuickSortTest();
		test.sort(arr);
		for (int i : arr) {
			System.out.print(i + "   ");
		}
	}
	
	private void sort(int [] arr) {
		int begin = 0;
		int end = arr.length;
		sort(arr,begin,end);
	}
	
	private void sort(int [] arr ,int begin,int end) {
		if (end - begin < 2) {
			return;
		}
		int mid = pivotIndex(arr,begin, end);
		sort(arr,begin,mid);
		sort(arr,mid + 1,end);		
	}
	//找到轴点位置,并且遍历一次数组,把大的放到轴点元素右边,小的放到左边
	private int  pivotIndex( int[]arr, int begin,int end) {
		
		int pivot = arr[begin];
		end--;
		while (end > begin) {
			
			while (end >begin) {
				if (pivot - arr[end] < 0) {
					end--;
				}else {
					arr[begin++] = arr[end];
					break;
				}
			}
			while (end > begin) {
				if (pivot - arr[begin]  > 0) {
					begin++;
				}else {
					arr[end--] = arr[begin];
					break;
				}
			}
		}
		//能来到这个位置说明,begin == end
		arr[begin] = pivot;
		return begin;
	}
	

}
