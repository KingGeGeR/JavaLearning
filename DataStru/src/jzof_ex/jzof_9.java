package jzof_ex;

import java.util.Stack;

/**
 * 
 * @author 11253
 *������ջʵ�ֶ��У���һ��ջʼ�ջ��ǿյģ���push��ʱ��stack2�գ���pop��ʱ��stack1��
 *�����뵽��GC������������Survior From��to,����������
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
