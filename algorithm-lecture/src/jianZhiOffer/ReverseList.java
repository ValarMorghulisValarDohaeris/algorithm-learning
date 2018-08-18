package jianZhiOffer;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * Created on 2018/8/18.
 * @author hao
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        //优先级一：使用指针的方式，不需要借助辅助栈
        if(head == null){
            return null;
        }else if(head.next == null){
            return head;
        }

        ListNode pre = head,index = pre.next,next = index.next;
        pre.next = null;
        index.next = pre;
        while(next != null){
            pre = index;
            index = next;
            next = next.next;
            index.next = pre;
        }

        return index;

        //优先级二：递归
//        if(head == null || head.next == null){
//            return head;
//        }
//
//        ListNode newHead = ReverseList(head.next);
//
//        head.next.next = head;
//        head.next = null;
//
//        return newHead;

        //优先级三：使用辅助Stack，笨蛋能想到
//        if(head == null){
//            return null;
//        }
//
//        ListNode temp = head;
//        Stack<ListNode> listNodes = new Stack<>();
//        listNodes.add(head);
//        while(temp.next != null){
//            temp = temp.next;
//            listNodes.add(temp);
//        }
//
//        ListNode newHead = listNodes.pop(),index = newHead;
//        while(!listNodes.isEmpty()){
//            index.next = listNodes.pop();
//            index = index.next;
//        }
//        index.next = null;
//
//        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
