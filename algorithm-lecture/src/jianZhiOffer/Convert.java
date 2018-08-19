package jianZhiOffer;

import java.util.function.Consumer;

/**
 * ToRetry
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * Created on 2018/8/19.
 * @author hao
 */
public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode pLastNodeInList = null;
        while(pLastNodeInList != null && pLastNodeInList.left != null){
            pLastNodeInList = pLastNodeInList.left;
        }

        return pLastNodeInList;
    }

    public void ConvertNode(TreeNode pNode, TreeNode pLastNodeInList){
        if(pNode == null){
            return;
        }

        TreeNode pCur = pNode;
        if(pNode.left != null){
            ConvertNode(pNode.left, pLastNodeInList);
        }
        pCur.left = pLastNodeInList;
        if(pLastNodeInList != null){
            pLastNodeInList.right = pCur;
        }

        pLastNodeInList = pCur;
        if(pCur.right != null){
            ConvertNode(pCur.right,pLastNodeInList);
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
