package jianZhiOffer;

import java.util.ArrayList;

/**
 * ToRetry
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * Created on 2018/8/19.
 * @author hao
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return arrayLists;
        }

        helper(new ArrayList<>(),root,target);

        return arrayLists;
    }

    public void helper(ArrayList<Integer> array, TreeNode node, int target){
        if(node == null){
            return;
        }

        array.add(node.val);
        if(node.val == target && node.left == null && node.right == null){
            //这步很重要，如果找到匹配的路径，需要复制一个ArrayList添加到集合中。如果直接使用当前的ArrayList，即使添加到集合后还是会被后面的操作改动。
            arrayLists.add(new ArrayList<>(array));
            array.remove(array.size()-1);
            return;
        }

        helper(array,node.left,target-node.val);
        helper(array,node.right,target-node.val);
        //使用完该路径后，需要移除该节点的值
        array.remove(array.size()-1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        FindPath findPath = new FindPath();
        ArrayList<ArrayList<Integer>> arrayLists = findPath.FindPath(treeNode1, 22);
        System.out.println(arrayLists.toString());
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
