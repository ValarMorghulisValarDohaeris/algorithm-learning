package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 *
 * Created by hao on 2018/7/13.
 */
public class ThreeColor {
    public static void main(String[] args) {
        ThreeColor threeColor = new ThreeColor();
        int[] ints = threeColor.sortThreeColor(new int[]{2,0,2,0,1,0,2,2,0,0,0,1,2,1,0,1,2,0,2,1,2,0,2,0,2,1,1,2,0,2,0,2,0,1,0,0,1,0,1,2,2,2,1,1,2,1,1,1,1,1,2,1,0,0,1,2,1,0,0,2,0,1,1,1,0,1,0,2,1,2,0,0,1,0,2,0,0,1,2,1,1,1,0,1,2,2,0,0,1,0,1,2,1,1,2,1,2,0,0,2,2,0,2,1,0,1,1,0,0,0,2,0,2,1,2,2,2,0,1,2,2,0,0,2,2,0,1,1,0,2,2,2,0,0,1,2,2,0,0,1,1,1,2,0,1,2,1,2,1,2,1,2,1,1,0,2,1,2,2,2,0,2,1,2,1,2,1,1,1,0,2,0,0,2,2,2,0,1,2,0,2,0,0,0,1,1,2,2,0,0,2,0,2,0,0,0,2,2,2,2,0,0,1,1,1,0,0,0,0,0,0,1,2,2,2,1,0,0,2,1,0,2,1,1,1,1,0,1,2,1,0,1,0,2,2,2,2,1,2,1,2,1,2,1,1,1,1,1,0,2,1,1,0,0},254);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortThreeColor(int[] A, int n) {
        if(A == null || n <= 1){
            return A;
        }

        int edgeOfZero = 0;
        int edgeOfTwo = n-1;
        for (int i = edgeOfZero; i <= edgeOfTwo; i++) {
            if(A[i] == 0){
                swap(A,i,edgeOfZero++);
                while(A[edgeOfZero] == 0){
                    edgeOfZero++;
                    i++;
                }
            }else if(A[i] == 2){
                swap(A,i,edgeOfTwo--);
                while(A[edgeOfTwo] == 2){
                    edgeOfTwo--;
                }
                i--;
            }
        }

        return A;

    }

    public void swap(int[] A,int x,int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
