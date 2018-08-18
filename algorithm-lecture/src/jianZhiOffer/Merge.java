package jianZhiOffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * Created on 2018/8/18.
 * @author hao
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        //递归
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode head = null;
        if(list1.val <= list2.val){
            head = list1;
            head.next = Merge(list1.next,list2);
        }else{
            head = list2;
            head.next = Merge(list1,list2.next);
        }

        return head;

        //遍历
/*        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode head;
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }

        ListNode index = head;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                index.next = list1;
                list1 = list1.next;
            }else{
                index.next = list2;
                list2 = list2.next;
            }
            index = index.next;
        }

        if(list1!=null){
            index.next = list1;
        }
        if(list2!=null){
            index.next = list2;
        }

        return head;*/
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
