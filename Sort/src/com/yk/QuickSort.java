package com.yk;

public class QuickSort {

	public static void main(String[] args) {
		System.out.println("hello quick");
		QuickSort quickSort = new QuickSort();
		int arr[] = new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};        
		quickSort.sort(arr);
	}
	private void sort(int [] arr) {		
	    sort(arr,0,arr.length);        
	    for (int i:arr) {            
	        System.out.print(i+"   ");        
	    }    
	}
	public void sort(int arr[],int begin,int end) {
		if (end - begin < 2) { // 子序列个数小于两个,
			return;
		}
		// 确定轴点元素
		int mid = pivotIndex(arr, begin, end);
		// 对子序列进行快速排序
		sort(arr,begin,mid);
		sort(arr,mid+1,end);
	}
	/**
	 * 构造出数组  arr 在[begin,end)范围内的轴点元素
	 * @return 轴点元素的最终位置
	 */
	private int pivotIndex(int[] arr,int begin,int end) {
		// 此处优化,应随机选出一个元素进行交换.减少出现最坏情况的概率
		{
			int index = begin + (int)Math.random()*(end - begin);
			int temp = 0;
			temp = begin;
			begin = index;
			index = temp;
		}		
		//1. 备份轴点元素
		int pivot = arr[begin];
		end--;
		while (begin < end) {
			while (begin < end) {
				if (pivot - arr[end] < 0) { 
					end--;
				}else { 
					arr[begin] = arr[end];begin++;
					break;
				}
			}
			while (begin < end) {
				if (pivot - arr[begin] > 0) { 
					begin++;
				}else { 
					arr[end] = arr[begin];end--;
					break;
				}
			}
		}
		// 将轴点元素放回到数组中
		arr[begin] = pivot;
		//返回轴点元素位置
		return begin;
	}
	   
	
}
