package com.yk;

public class ThreadTest {

	public static void main(String[] args) {

		MisucThread mThread = new MisucThread();
		mThread.start();
		
		
	}
	public void threadMethod1() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			System.out.println("current thread : " + Thread.currentThread());	
		 	}
		});
		t.start();

	}

}
