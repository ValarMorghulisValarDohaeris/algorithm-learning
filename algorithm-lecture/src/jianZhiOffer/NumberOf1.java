package jianZhiOffer;

/**
 * Retry
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author hao
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        //使用n=(n-1)&n，去掉n的二进制形式中的最右边的1。有几个1遍历几次
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;

        //思想：用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数。遍历32次
//        int count = 0;
//        int flag = 1;
//        while (flag != 0) {
//            if ((n & flag) != 0) {
//                count++;
//            }
//            flag = flag << 1;
//        }
//        return count;

        //直接使用Interger.toBinaryString()将整数转换为二进制字符串
//        int count = 0;
//        String s = Integer.toBinaryString(n);
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if(chars[i] == '1'){
//                count++;
//            }
//        }
//        return count;
    }

    public static void main(String[] args) {
        NumberOf1 numberOf1 = new NumberOf1();
        System.out.println(numberOf1.NumberOf1(5));
    }
}
