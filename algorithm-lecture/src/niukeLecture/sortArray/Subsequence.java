package niukeLecture.sortArray;

/**
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 *
 * Created by hao on 2018/7/14.
 */
public class Subsequence {
    public static void main(String[] args) {
        Subsequence subsequence = new Subsequence();
        int i = subsequence.shortestSubsequence(new int[]{1,2,3,3,8,9},6);
        System.out.println(i);
    }

    public int shortestSubsequence(int[] A, int n) {
        if(A == null || n == 0){
            return 0;
        }

        int rightEdge = 0;
        int leftEdge = 0;
        int max = A[0];

        //从左往右遍历数组，记录出现的最大数为max，如果出现该数右边的元素比该数小，则将该元素的下标记为rightEdge，代表需要排序的子数组的右边界。
        for (int i = 1; i < n; i++) {
            if(A[i] > max){
                max = A[i];
            }else if(A[i] < max){
                rightEdge = i;
            }
        }

        int min = A[n-1];
        //从右往左遍历数组，记录出现的最小数为min，如果出现该数左边的元素比该数大，则将该元素的下标记为leftEdge，代表需要排序的子数组的左边界。
        for (int i = n-2; i >= 0; i--) {
            if(A[i] < min){
                min = A[i];
            }else if(A[i] > min){
                leftEdge = i;
            }
        }
        //左边界与右边界相等，说明数组有序，返回0；否则返回子数组长度。
        if(rightEdge != leftEdge){
            return rightEdge-leftEdge+1;
        }else{
            return 0;
        }
    }
}
