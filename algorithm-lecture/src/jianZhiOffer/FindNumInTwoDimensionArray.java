package jianZhiOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * Created on 2018/8/5.
 * @author hao
 */
public class FindNumInTwoDimensionArray {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        int i = 0;
        int j = array[0].length-1;
        while(i < array.length && j >= 0 && array[i][j] != target){
            if(array[i][j] > target){
                j--;
            }else{
                i++;
            }
        }

        if(i < array.length && j >= 0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        FindNumInTwoDimensionArray findNumInTwoDimensionArray = new FindNumInTwoDimensionArray();
//        boolean find = findNumInTwoDimensionArray.Find(10, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        boolean find = findNumInTwoDimensionArray.Find(10, null);
        System.out.println(find);
    }
}
