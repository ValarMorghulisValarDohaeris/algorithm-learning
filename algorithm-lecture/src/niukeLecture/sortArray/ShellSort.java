package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 希尔排序
 * Created by hao on 2018/7/6.
 */
public class ShellSort {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] ints = shellSort.shellSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        System.out.println(Arrays.toString(ints));
    }

    public int[] shellSort(int[] A, int n) {
        int step = 3;
        int index;
        while(step > 0){
            for (int i = step; i < n; i++) {
                index= i;
                while(index-step >= 0 && A[index-step] > A[index]){
                    swap(A,index-step,index);
                    index = index-step;
                }
            }
            step--;
        }
        return A;
    }

    public void swap(int[] A,int a,int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
