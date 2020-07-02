package com.yk;


public class Main {
	
	public void test1() {
		DeQueuee<Integer> queue = new DeQueuee<>();
		/**
		 * 未    55,44,33,11,22头
		 */
		queue.enQueueFromFront(11);
		queue.enQueueFromFront(22);
		queue.enQueueFromTail(33);
		queue.enQueueFromTail(44);
		queue.enQueueFromTail(55);
		
		System.out.println(queue.peekFront());
		System.out.println("");
		while (!queue.isEmpty()) {
		 System.out.println(queue.outQueueFromTail());
		}
	}
	
	static void test2() {
		CircleQueue<Integer> cQueue = new CircleQueue<>();
		for (int i = 0; i < 10; i++) {
			cQueue.enQueue(i);
		}
//		for (int i = 0; i < 5; i++) {
//			cQueue.outQueue();
//		}
		for (int i = 10; i <17; i++) {
			cQueue.enQueue(i);
		}
		System.out.println(cQueue);
		while (!cQueue.isEmpty()) {
			System.out.println(cQueue.outQueue());
		}
	}

	public static  void main(String[] args) {

		System.out.println("Queue main");
				
		test2();

		
		
	}

}
