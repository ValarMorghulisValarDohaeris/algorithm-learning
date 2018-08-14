package jianZhiOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * Created on 2018/8/5.
 * @author hao
 */
public class StackAsQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new Exception("队列为空");
        }else{
            return stack2.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        StackAsQueue stackAsQueue = new StackAsQueue();
        stackAsQueue.push(1);
        stackAsQueue.push(2);
        stackAsQueue.push(3);
        System.out.println(stackAsQueue.pop());
        System.out.println(stackAsQueue.pop());
        stackAsQueue.push(4);
        System.out.println(stackAsQueue.pop());
        stackAsQueue.push(5);
        System.out.println(stackAsQueue.pop());
        System.out.println(stackAsQueue.pop());
    }
}
