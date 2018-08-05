package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 归并排序
 * Created by hao on 2018/7/4.
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] ints = mergeSort.mergeSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        System.out.println(Arrays.toString(ints));
    }


    public int[] mergeSort(int[] A, int n) {
        if(A == null || A.length != n){
            return null;
        }
        return sort(A,0,n-1);
    }

    public int[] sort(int[] A,int low,int high){
        int mid = low+(high-low)/2;
        //递归，从底往上归并
        if(low<high){
            sort(A,low,mid);
            sort(A,mid+1,high);
            merge(A,low,mid,high);
        }
        return A;
    }

    public void merge(int[] A,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        //把较小的移入到辅助数组中
        while(i<=mid && j <= high){
            if(A[i] < A[j]){
                temp[k++] = A[i++];
            }else{
                temp[k++] = A[j++];
            }
        }
        //将左边剩余的加入到辅助数组中
        while(i <= mid){
            temp[k++] = A[i++];
        }
        //将右边剩余的加入到辅助数组中
        while(j <= high){
            temp[k++] = A[j++];
        }
        //用辅助数组中的值覆盖原数组，达到排序的目的
        for (int l = 0; l < temp.length; l++) {
            A[l+low] = temp[l];
        }
    }

}
