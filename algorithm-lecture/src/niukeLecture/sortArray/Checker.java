package niukeLecture.sortArray;

import java.util.Arrays;

/**
 * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 *
 * Created by hao on 2018/7/12.
 */
public class Checker {
    public static void main(String[] args) {
        Checker checker = new Checker();
        boolean b = checker.checkDuplicate(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        System.out.println(b);
    }

    public boolean checkDuplicate(int[] a, int n) {
        if(a == null || n == 0){
            return false;
        }

        for (int i = n/2-1; i >= 0; i--) {
            adjustHeap(a,i,n);
        }
        //大顶堆的堆顶元素最大，与最后一个元素交换，放到最后去，然后再对前n-1个数进行同样的操作，这样就能得到一个升序的数组。
        //注意，使用大顶堆，得到的是一个升序的数组。
        for (int i = n-1; i > 0; i--) {
            swap(a,0,i);
            adjustHeap(a,0,i);
        }

        for (int i = 0; i < n-1; i++) {
            if(a[i] == a[i+1]){
                return true;
            }
        }
        return false;
    }

    public void adjustHeap(int[] a,int index,int length){
        int temp = a[index];
        int leftChild = 2*index+1;
        for (; leftChild < length;leftChild = 2*index+1) {
            if(leftChild+1 < length && a[leftChild+1] > a[leftChild]){
                leftChild++;
            }
            if(a[leftChild] > temp){
                a[index] = a[leftChild];
                index = leftChild;
            }else{
                break;
            }
        }
        a[index] = temp;
    }

    public void swap(int[] a,int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y]= temp;
    }

}
