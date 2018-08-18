package jianZhiOffer;

import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 注意，大多数关于树的题目，用递归会大大减少代码量与复杂度。
 * Created on 2018/8/18.
 * @author hao
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        //递归
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        if(root.left != null){
            Mirror(root.left);
        }
        root.right = temp;
        if(root.right != null){
            Mirror(root.right);
        }

        //遍历
/*        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            TreeNode node = treeNodes.pop();
            if(node.left != null || node.right != null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.left != null){
                treeNodes.add(node.left);
            }
            if(node.right != null){
                treeNodes.add(node.right);
            }
        }*/
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
