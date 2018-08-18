package jianZhiOffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * Created on 2018/8/18.
 * @author hao
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        /**
         * 递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
         * 如果根节点不相同，则判断tree1的左子树和tree2是否相同，
         * 再判断右子树和tree2是否相同
         */
        if(root1 == null || root2 == null){
            return false;
        }

        boolean result = doesTree1HaveTree2(root1,root2);
        if(result){
            return true;
        }else{
            return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }

        /**
         * 前序遍历，将数转化为字符串，再判断树1的字符串是否包含树2。
         * 这样仅适用于B时A的根结构的情况，如果B是A的中间结构，则不适用
         */
//        if(root1 == null || root2 == null){
//            return false;
//        }
//
//        StringBuffer sb1 = new StringBuffer();
//        preTraverse(root1,sb1);
//        StringBuffer sb2 = new StringBuffer();
//        preTraverse(root2,sb2);
//
//        if(sb1.toString().contains(sb2.toString())){
//            return true;
//        }
//
//        return false;
    }

    public boolean doesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }

        if(root1.val == root2.val){
            return doesTree1HaveTree2(root1.left,root2.left) && doesTree1HaveTree2(root1.right,root2.right);
        }else{
            return false;
        }
    }

    public void preTraverse(TreeNode root,StringBuffer sb){
         if(root.left != null){
             sb.append(root.left.val);
             preTraverse(root.left,sb);
         }
         if(root.right != null){
             sb.append(root.right.val);
             preTraverse(root.right,sb);
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
