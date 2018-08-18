package jianZhiOffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 1.记录下第一个偶数的位置，记为index
 * 2.往后遍历，每次碰到奇数，记为i，则将index到i的偶数整体后移一位，再将该奇数赋给index位置
 * 3.index++
 * @author hao
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {

        if(array == null || array.length == 0){
            return;
        }

        int index = 0,temp,first=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2 == 0){
                first = i;
                index = first;
                break;
            }
        }
        for (int i = first+1; i < array.length; i++) {
            if(array[i]%2 != 0){
                temp = array[i];
                int count = i -index;
                while(count > 0){
                    array[index+count] = array[index+(--count)];
                }
                array[index] = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        ReOrderArray reOrderArray = new ReOrderArray();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        reOrderArray.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
