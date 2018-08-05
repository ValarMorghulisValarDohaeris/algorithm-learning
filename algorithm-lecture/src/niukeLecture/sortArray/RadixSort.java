package niukeLecture.sortArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基数排序
 * Created by hao on 2018/7/6.
 */
public class RadixSort {
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] ints = radixSort.radixSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        System.out.println(Arrays.toString(ints));
    }
    private int[] radix = {1, 10, 100, 1000};
    public int[] radixSort(int[] A, int n) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayLists.add(new ArrayList<>());
        }

        int count = 0;
        int index = 0;
        ArrayList<Integer> temp;
        while(count < 4){
            for (int i = 0; i < n; i++) {
                int num = getNumber(A[i],count);
                arrayLists.get(num).add(A[i]);
            }
            for (int i = 0; i < 10; i++) {
                temp = arrayLists.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    A[index] = temp.get(j);
                    index++;
                }
                temp.clear();
            }
            count++;
            index = 0;
        }

        return A;

    }

    private int getNumber(int num,int i){
        num = num/radix[i];
        return num%10;
    }
}
