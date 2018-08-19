package jianZhiOffer;

import java.security.cert.PolicyNode;

/**
 * ToRetry
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * Created on 2018/8/19.
 * @author hao
 */
public class CloneRandomListNode {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }

        RandomListNode pNode = pHead;
        //复制节点
        while(pNode != null){
            RandomListNode pClone = new RandomListNode(pNode.label);
            pClone.next = pNode.next;
            pNode.next = pClone;
            pNode = pClone.next;
        }

        //复制节点指向其随机节点
        pNode = pHead;
        while(pNode != null){
            if(pNode.random != null){
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }

        RandomListNode head = pHead.next, cur = head;
        pNode = pHead;
        while(pNode != null){
            pNode.next = pNode.next.next;
            if(cur.next != null){
                cur.next = cur.next.next;
            }
            pNode = pNode.next;
            cur = cur.next;
        }

        return head;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
