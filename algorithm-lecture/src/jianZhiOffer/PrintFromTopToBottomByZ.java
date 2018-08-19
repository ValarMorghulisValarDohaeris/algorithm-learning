package jianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * Created on 2018/8/19.
 * @author hao
 */
public class PrintFromTopToBottomByZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        /**
         * 借助两个辅助栈
         */
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if(pRoot == null){
            return arrayList;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(pRoot);
        int level = 1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(level%2 == 0){
                while(!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    arr.add(node.val);

                    if(node.right != null){
                        stack1.add(node.right);
                    }
                    if(node.left != null){
                        stack1.add(node.left);
                    }
                }
            }else{
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    arr.add(node.val);

                    if(node.left != null){
                        stack2.add(node.left);
                    }
                    if(node.right != null){
                        stack2.add(node.right);
                    }
                }
            }
            arrayList.add(arr);
            arr = new ArrayList<>();
            level++;
        }

        return arrayList;

        /**
         * 递归和遍历其实都使用了arr.add(0,node.val);来实现从右往左打印，但是该语句，每次add时，都会使得所有的元素后移一位，在数据量很大的时候，效率会非常低
         */
        //递归法
/*        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        helper(pRoot, arrayList, 1);
        return arrayList;*/

        //遍历法
/*        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if(pRoot == null){
            return arrayList;
        }

        Queue queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        int preRow = 1,count = 0,level = 1;
        while (!queue.isEmpty()){
            while(preRow-- > 0){
                TreeNode node = (TreeNode) queue.poll();
                if(level%2 == 0){
                    arr.add(0,node.val);
                }else{
                    arr.add(node.val);
                }

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
            level++;
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
        if(depth%2 == 0){
            arrayLists.get(depth-1).add(0,node.val);
        }else{
            arrayLists.get(depth-1).add(node.val);
        }

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
