package niukeLecture.sortArray;

/**
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 *
 * Created by hao on 2018/7/14.
 */
public class Finder {
    public static void main(String[] args) {
        Finder finder = new Finder();
        boolean result = finder.findX(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3, 3, 2);
        System.out.println(result);
    }

    public boolean findX(int[][] mat, int n, int m, int x) {
        if(mat == null || n*m == 0){
            return false;
        }

        //从左上角（下标为i,j）开始查找，如果x比左上角的大，则i++；若x比左上角小，则j--；若相等，则返回true。
        int i = 0;
        int j = m-1;

        while(i < n && j >= 0){
            if(mat[i][j] == x){
                return true;
            }else if(mat[i][j] > x){
                j--;
            }else{
                i++;
            }
        }

        return false;

    }
}
