package jianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * Created on 2018/8/19.
 * @author hao
 */
public class PrintFromTopToBottomByLine {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //递归法
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        helper(pRoot, arrayList, 1);
        return arrayList;


        //遍历法
/*        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if(pRoot == null){
            return arrayList;
        }

        Queue queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        int preRow = 1,count = 0;
        while (!queue.isEmpty()){
            while(preRow-- > 0){
                TreeNode node = (TreeNode) queue.poll();
                arr.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                    count++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    count++;
                }
            }
            arrayList.add(arr);
            preRow = count;
            count = 0;
            arr = new ArrayList<>();
        }

        return arrayList;*/
    }

    public void helper(TreeNode node, ArrayList<ArrayList<Integer>> arrayLists, int depth){
        if(node == null){
            return;
        }
        if(depth > arrayLists.size()){
            arrayLists.add(new ArrayList<>());
        }
        arrayLists.get(depth-1).add(node.val);

        helper(node.left, arrayLists, depth+1);
        helper(node.right, arrayLists, depth+1);
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
