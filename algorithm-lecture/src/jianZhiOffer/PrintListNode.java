package jianZhiOffer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * Created on 2018/8/5.
 * @author hao
 */
public class PrintListNode {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode == null){
            return arrayList;
        }

        ListNode temp = listNode;
        while(temp != null){
            arrayList.add(temp.val);
            temp = temp.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = arrayList.size()-1; i >= 0; i--) {
            result.add(arrayList.get(i));
        }

        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
