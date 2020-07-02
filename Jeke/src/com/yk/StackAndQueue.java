package com.yk;

import java.util.Stack;

//栈,队列,优先队列
// 栈: FILO
// 队列: FIFO
// 优先队列: 实现方式:1.(Heap) 2.二叉搜索树 
public class StackAndQueue {
	
	public static void main(String[] args) {
		System.out.println("hello world");
		boolean isValied = kuohao2("()[[]");
		System.out.println("是否合法? " + (isValied ? "合法" : "不合法"));
		
	}
	Stack<Integer> stackPush;// = new Stack<Integer>();
	Stack<Integer> stackPop;// = new Stack<Integer>();
	//
	 /** Initialize your data structure here. */
    public StackAndQueue() {
    	stackPush = new Stack<Integer>();
    	stackPop = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	stackPush.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
    	return stackPop.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
    	return stackPop.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
    	return stackPop.isEmpty();
    }
	
	
	
	
	//1. 括号合法性的匹配
	public static boolean kuohao(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		int length = s.length();
		int index = 0;
		while (index < length) {
			if (s.charAt(index) == '(' || s.charAt(index) == '[' || s.charAt(index) == '{') {
				stack.push(s.charAt(index));
			}else { // ) ] }
				if (!stack.isEmpty()) {
					char currentChar = s.charAt(index);
 					char stackTop = stack.peek();
 					if ((currentChar == ')' && stackTop!= '(') || (currentChar == ']' && stackTop!= '[') || (currentChar == '}' && stackTop!= '{')) {
						return false;
					} else {
						stack.pop();
					}
				}else {
					return false;
				}
			}
			index++;
		}
		return stack.isEmpty();
	}
	
	public static boolean kuohao2(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int length = 0;
		do {
			length = s.length();
			s =  s.replace("{}", "").replace("[]", "").replace("()", "");
		}while(length != s.length());
		return s.length() == 0;
	}
	
	
}
