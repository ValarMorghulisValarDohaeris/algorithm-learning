package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 堆排序
 * Created by hao on 2018/7/5.
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] ints = heapSort.heapSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        System.out.println(Arrays.toString(ints));
    }

    public int[] heapSort(int[] A, int n) {
        //构建大顶堆
        for (int i = n/2-1; i >= 0; i--) {
            //从第一个非叶子节点从下至上，从右向左调整
            adjustHeap(A,i,n);
        }
        //交换堆顶元素和末尾的元素，再进行堆调整
        for (int i = n-1; i > 0; i--) {
            swap(A,0,i);
            adjustHeap(A,0,i);
        }
        return A;
    }

    public void adjustHeap(int[] A,int index,int length){
        int temp = A[index];
        //这个循环用于调整大顶堆，构建大顶堆的时候，是从最下层开始往上的，下层已经满足要求，但是调整时，由于将最小的放到堆顶，所以需要一直往下调整
        for (int i = 2*index+1; i < length; i=2*i+1) {
            //如果左子结点小于右子结点，k指向右子结点
            if(i+1 < length && A[i+1] > A[i]){
                i++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(A[i] > temp){
                A[index] = A[i];
                index = i;
            }else{
                break;
            }
        }
        A[index] = temp;
    }

    public void swap(int[] A,int a,int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
