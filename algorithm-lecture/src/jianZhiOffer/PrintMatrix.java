package jianZhiOffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * Created on 2018/8/19.
 * @author hao
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(matrix == null){
            return arrayList;
        }
        
        int len = matrix.length,width = matrix[0].length;
        helper(matrix, arrayList, 0, width-1, len-1);
        return arrayList;
    }
    
    public void helper(int[][] matrix, ArrayList<Integer> arrayList, int i, int j, int len){
        if(i <= j && i <= len){
            for (int k = i; k <= j; k++) {
                arrayList.add(matrix[i][k]);
            }
            for (int k = i+1; k <= len; k++) {
                arrayList.add(matrix[k][j]);
            }
            for (int k = j-1; k >= i && len > i; k--) {
                arrayList.add(matrix[len][k]);
            }
            for (int k = len-1; k > i && j>i; k--) {
                arrayList.add(matrix[k][i]);
            }

            helper(matrix,arrayList,++i,--j,--len);
        }
    }

    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();
        //int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr = new int[][]{{1,2,3,4,5},{6,7,8,9,10}};
        ArrayList<Integer> arrayList = printMatrix.printMatrix(arr);
        System.out.println(arrayList.toString());
    }
}
