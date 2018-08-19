package jianZhiOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * Created on 2018/8/19.
 * @author hao
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        /**
         * 递归法，最好时间复杂度为O(nlogn)
         */
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return helper(sequence, 0, sequence.length-1);

        /**
         * 非递归法，不过时间复杂度为O(n*n)
         */
/*        if(sequence == null || sequence.length == 0){
            return false;
        }

        int len = sequence.length;
        int i = 0;
        while(len-- > 0){
            while(sequence[i++] < sequence[len]);
            i--;
            while(sequence[i++] > sequence[len]);

            if(i < len){
                return false;
            }
            i = 0;
        }
        return true;*/
    }

    public boolean helper(int[] sequence,int begin,int end){
        if(begin >= end){
            return true;
        }

        int index= begin;
        int media;
        while(index < end){
            if(sequence[index] < sequence[end]){
                index++;
            }else{
                break;
            }
        }
        media = index-1;
        while(index < end){
            if(sequence[index] < sequence[end]){
                return false;
            }
            index++;
        }

        return helper(sequence, begin, media) && helper(sequence, media+1, end-1);
    }

}
