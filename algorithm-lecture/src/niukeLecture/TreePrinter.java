package niukeLecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。
 * 保证结点数小于等于500。
 *
 * Created by hao on 2018/7/2.
 */
public class TreePrinter {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int[][] printTree(TreeNode root) {
        if(root == null){
            return null;
        }

        Queue queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode nlast = root;
        TreeNode last = root;

        int line = 0;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(line,new ArrayList<>());

        while(!queue.isEmpty()){
            TreeNode peekNode = (TreeNode) queue.poll();
            arrayLists.get(line).add(peekNode.val);
            if(peekNode.left != null){
                queue.offer(peekNode.left);
                nlast = peekNode.left;
            }

            if(peekNode.right != null){
                queue.offer(peekNode.right);
                nlast = peekNode.right;
            }

            if(peekNode == last){
                last = nlast;
                arrayLists.add(++line,new ArrayList<>());
            }
        }

        int[][] result = new int[line][];
        for (int i = 0; i < line; i++) {
            ArrayList<Integer> arrayList = arrayLists.get(i);
            int t = arrayList.size();
            int[] temp = new int[t];
            for (int j = 0; j < t; j++) {
                temp[j] = arrayList.get(j);
            }
            result[i] = temp;
        }

        return result;
    }
}
