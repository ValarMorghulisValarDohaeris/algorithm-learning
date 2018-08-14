package jianZhiOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author hao
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if(target < 1){
            return 0;
        }

        int result = 1;
        while(target-- > 1){
            result = 2*result;
        }
        return result;
    }

    public static void main(String[] args) {
        JumpFloorII jumpFloor = new JumpFloorII();
        System.out.println(jumpFloor.JumpFloorII(3));
    }
}
