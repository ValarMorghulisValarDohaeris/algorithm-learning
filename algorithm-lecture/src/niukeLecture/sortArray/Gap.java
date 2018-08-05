package niukeLecture.sortArray;

/**
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 *
 * Created by hao on 2018/7/14.
 */
public class Gap {
    public static void main(String[] args) {
        Gap gap = new Gap();
        int i = gap.maxGap(new int[]{1, 2, 5, 4, 6}, 5);
        System.out.println(i);
    }

    public int maxGap(int[] A, int n) {
        if(A == null || n < 2){
            return 0;
        }

        //找出数组里的最大值和最小值
        int max = A[0];
        int min = A[0];

        for (int i = 1; i < n; i++) {
            if(A[i] > max){
                max= A[i];
            }
            if(A[i] < min){
                min = A[i];
            }
        }

        //构建n+1大小的数组，分别记录对应桶的是否有值，最大值，最小值。
        int[] maxs = new int[n+1];
        int[] mins = new int[n+1];
        boolean[] hasNum = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            //获取元素所对应的桶
            int bid = getBucketId(A[i],n,min,max);
            //若当前桶为空，则最大值和最小值都置为当前值，且将桶设为非空；若桶非空，则将当前值与桶的最大值以及最小值进行比较
            if(!hasNum[bid]){
                maxs[bid] = A[i];
                mins[bid] = A[i];
                hasNum[bid] = true;
            }else{
                maxs[bid] = Math.max(A[i],maxs[bid]);
                mins[bid] = Math.min(A[i],mins[bid]);
            }
        }//至此，得到了每个桶的最大值，最小值，以及是否有值，接下去只要遍历桶，然后算出相邻的最大值。

        //lasyMax为上一个非空桶的最大值
        int lastMax = min;
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if(hasNum[i]){
                //当前桶的最小值减去上个非空桶的最大值，得到的即为相邻两个元素的差值，取出所有差值里的最大值即为结果。
                result = Math.max(result,mins[i]-lastMax);
                lastMax = maxs[i];
            }
        }
        return result;
    }
    //需要使用long型，不然当数组较大(几百个)时会出错
    //double delta = (max - min) / n;
//    private int getBucketId(int num, int min, double delta) {
//        double d = (num - min) / delta;
//        return (int) d;
//    }

    public int getBucketId(long num,long len,long min,long max){
        return (int)((num-min)*len / (max-min));
    }
}
