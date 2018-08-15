package jianZhiOffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author hao
 */
public class RectCover {
    public int RectCover(int target) {
        if(target <= 0){
            return 0;
        }

        int next = 1;
        int result = 1;
        while(target-- > 0){
            next += result;
            result = next - result;
        }

        return result;
    }

    public static void main(String[] args) {
        RectCover rectCover = new RectCover();
        System.out.println(rectCover.RectCover(3));
    }
}
