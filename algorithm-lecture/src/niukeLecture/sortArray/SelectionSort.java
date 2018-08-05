package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 对于一个int数组，请编写一个选择排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 *
 * Created by hao on 2018/7/4.
 */
public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] ints = selectionSort.selectionSort(new int[]{54,35,48,36,27,12,44,44,8,14,26,17,28}, 13);
        System.out.println(Arrays.toString(ints));
    }

    public int[] selectionSort(int[] A, int n) {
        if(A == null || A.length != n){
            return null;
        }

        int min = 0;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i+1; j < n; j++) {
                if(A[j] < A[min]){
                    min = j;
                }
            }
            swap(A,i,min);
        }

        return A;
    }

    public void swap(int[] A,int x,int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
