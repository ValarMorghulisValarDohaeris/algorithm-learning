package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 * Created by hao on 2018/7/13.
 */
public class Merge {
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] ints = merge.mergeAB(new int[]{1, 3, 5, 0, 0, 0, 0, 0}, new int[]{2, 4, 6}, 3, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        int index = m+n-1;
        n--;
        m--;
        while(n >= 0 && m >= 0){
            if(A[n] > B[m]){
                A[index--] = A[n--];
            }else{
                A[index--] = B[m--];
            }
        }

        while(n >= 0){
            A[index--] = A[n--];
        }
        while(m >= 0){
            A[index--] = B[m--];
        }

        return A;
    }
}
