package niukeLecture.string;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 * 这里指的包含是指从相同的节点开始，到叶子节点完全相同，不能为B是A的一部分。
 *
 * 将二叉树序列化成字符串A和B，再看字符串B是否包含再字符串A中，如果在A中则说明B是A的子数结构。
 * 这里直接使用字符串的indexOf方法，比较偷懒。一般是需要自己写这里功能函数的，可以用暴力法，也可以用KMP法，KMP是最高效的。
 * Created by hao on 2018/7/21.
 */
public class IdenticalTree {
    public static void main(String[] args) {

    }

    public boolean chkIdentical(TreeNode A, TreeNode B) {
        return serialize(A).indexOf(serialize(B)) == -1?false:true;
    }

    public String serialize(TreeNode treeNode){
        if(treeNode == null){
            return "# ";
        }

        return treeNode.val + " " +  serialize(treeNode.left) + serialize(treeNode.right);
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
