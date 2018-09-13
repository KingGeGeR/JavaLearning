package jzof_ex;

import java.util.Stack;

/**
 * 
 * @author 11253
 *用两个栈实现队列，有一个栈始终会是空的，当push的时候stack2空，当pop的时候stack1空
 *让我想到了GC里对于年轻代，Survior From和to,标记清除复制
 */
public class jzof_9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        
    	while(!stack2.isEmpty()) {
    		stack1.push(stack2.pop());
    	}
    	stack1.push(node);
    }
    
    public int pop() {
    
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	return stack2.pop();
    }
}
