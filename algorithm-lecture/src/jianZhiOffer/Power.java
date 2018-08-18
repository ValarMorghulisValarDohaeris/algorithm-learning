package jianZhiOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author hao
 */
public class Power {
    public double Power(double base, int exponent) throws Exception {
        /**
         * 1.全面考察指数的正负、底数是否为零等情况。
         * 2.写出指数的二进制表达，例如13表达为二进制1101。
         * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
         * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
         *
         * 时间复杂度为O(logn)
         */
        int n;
        double res = 1;
        if(exponent > 0){
            n = exponent;
        }else if(exponent < 0){
            if(base == 0){
                throw new Exception("分母不能为0");
            }
            n = -exponent;
        }else{
            return 1;
        }

        while(n != 0){
            if((n&1) == 1){
                res *= base;
            }
            base *= base;
            n = n>>1;
        }
        return exponent>0?res:1/res;

        //最普通的方式，时间复杂度位O(n)
//        boolean flag = false;
//        double result = base;
//        if(exponent < 0){
//            exponent = -exponent;
//            flag = true;
//        }else if(exponent == 0){
//            return 1d;
//        }
//
//        while(exponent-- > 1){
//            result = result*base;
//        }
//
//        if(flag) {
//            return 1 / result;
//        }else{
//            return result;
//        }
    }

    public static void main(String[] args) throws Exception {
        Power power = new Power();
        System.out.println(power.Power(0,-3));
    }
}
