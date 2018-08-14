package jianZhiOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 循环法比递归法更加省时间，空间占用差不多。
 * 递归的好处是在大多数情况下可以减少代码量。
 * @author hao
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        //递归法,耗时642ms，因为会有大量重复计算。
        if(target <= 0){
            return 0;
        }else if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            return JumpFloor(target-1)+JumpFloor(target-2);
        }

        //循环法,15ms。空间相近，都为9000多K
//        if(target <= 0){
//            return 0;
//        }
//
//        int last = 1;
//        int result = 1;
//        while(target-- > 1){
//            result += last;
//            last = result - last;
//        }
//
//        return result;
    }

    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.JumpFloor(3));
    }
}
