package jianZhiOffer;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * Created on 2018/8/18.
 * @author hao
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        /**
         * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。然后两个指针同时往后移动，
         * 当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。
         */
        if(head == null || k <= 0){
            return null;
        }

        ListNode temp1 = head,temp2 = head;
        while(k-- > 1){
            if(temp1.next != null){
                temp1 = temp1.next;
            }else{
                return null;
            }
        }

        while(temp1.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp2;

        /**
         * 使用入栈出栈的方式，比较笨，大家都能想到
         */
//        if(head == null || k <= 0){
//            return null;
//        }
//
//        Stack<ListNode> listNodes = new Stack<>();
//        ListNode temp = head;
//        listNodes.add(temp);
//        while(temp.next != null){
//            temp = temp.next;
//            listNodes.add(temp);
//        }
//        while(k-- > 1){
//            if(!listNodes.isEmpty()){
//                listNodes.pop();
//            }else{
//                return null;
//            }
//        }
//
//        return listNodes.isEmpty()?null:listNodes.peek();
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
