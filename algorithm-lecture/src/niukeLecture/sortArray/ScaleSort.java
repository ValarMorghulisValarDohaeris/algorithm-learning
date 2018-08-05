package niukeLecture.sortArray;

import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
 * 每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序。
 * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 *
 * Created by hao on 2018/7/8.
 */
public class ScaleSort {
    public static void main(String[] args) {
        ScaleSort scaleSort = new ScaleSort();
        int[] ints = scaleSort.sortElement(new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9}, 10, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortElement(int[] A, int n, int k) {
        for(int i=0;i<n;i++){
            if(i+k<n)
                sort(A,i,i+k,k);
            //后面即使剩余的数组小于k，也是需要调整的，因为小根堆只保证了堆顶是最小值，其子节点是没有排序的
            else{
                sort(A,i,n,n-i);
            }
        }
        return A;
    }
    //l为偏移量，(r-l)/2为堆中的相对位置，再加上l，则为数组中的实际位置
    void sort(int[] A,int l,int r,int length){
        for(int i=(r-l)/2+l;i>=l;i--)
            heapAdjust(A,i,length,l);
    }
    //调整第index个节点
    void heapAdjust(int[] A,int index,int length,int l){
        int childLeft;
        int temp = A[index];
        for(;(index-l)*2+1+l<length+l;index = childLeft){
            childLeft = (index-l)*2+1+l;
            if(childLeft!=length+l-1&&A[childLeft]>A[childLeft+1])
                childLeft++;
            if(temp<A[childLeft]) break;
            else{
                A[index] = A[childLeft];
            }
        }
        A[index] = temp;
    }

}
