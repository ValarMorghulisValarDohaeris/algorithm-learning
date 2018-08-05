package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 插入排序
 * Created by hao on 2018/7/4.
 */
public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] ints = insertionSort.insertionSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        System.out.println(Arrays.toString(ints));
    }

    public int[] insertionSort(int[] A, int n) {
        if(A == null || A.length != n){
            return null;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 ; j--) {
                if(A[j] < A[j-1]){
                    swap(A,j,j-1);
                }
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
