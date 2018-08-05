package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 计数排序
 * Created by hao on 2018/7/6.
 */
public class CountingSort {
    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] ints = countingSort.countingSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        System.out.println(Arrays.toString(ints));
    }

    public int[] countingSort(int[] A, int n) {
        int min = 0x7FFFFFFF;
        int max = 0;
        //找出数组中的最大值和最小值，最大值与最小值的区间，即为桶的大小
        for (int i = 0; i < n; i++) {
            if(A[i] < min){
                min = A[i];
            }
            if(A[i] > max){
                max = A[i];
            }
        }
        //统计桶各个位置上数的数量
        int[] bucket = new int[max-min+1];
        for (int i = 0; i < n; i++) {
            bucket[A[i]-min]++;
        }

        int i = 0;
        //将桶中的数赋给数组
        for (int j = 0; j <= max-min; j++) {
            for (int k = bucket[j]; k > 0; k--) {
               A[i++] = min+j;
            }
        }
        return A;
    }
}
