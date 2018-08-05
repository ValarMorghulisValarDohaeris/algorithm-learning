package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 快速排序
 * Created by hao on 2018/7/5.
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = quickSort.quickSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        System.out.println(Arrays.toString(ints));
    }

    public int[] quickSort(int[] A, int n) {
        sort(A,0,n-1);
        return A;
    }

    public void sort(int[] A,int begin,int end){
        int temp = meidan(A,begin,end);
        int tbegin = begin;
        int tend = end;
        while(tbegin < tend){
            while(tend > tbegin && A[tend] >= temp){
                tend--;
            }
            A[tbegin] = A[tend];
            while(tbegin < tend && A[tbegin] <= temp){
                tbegin++;
            }
            A[tend] = A[tbegin];
        }
        A[tbegin] = temp;

        if(tbegin < end){
            sort(A,tbegin+1,end);
        }
        if(tend > begin){
            sort(A,begin,tend);
        }
    }

    public int meidan(int[] A,int begin,int end){
        int mid = begin + (end-begin)/2;
        if(A[mid] > A[end]){
            swap(A,mid,end);
        }
        if(A[begin] > A[end]){
            swap(A,begin,end);
        }
        if(A[begin] < A[mid]){
            swap(A,begin,mid);
        }
        return A[begin];
    }

    public void swap(int[] A,int a,int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
