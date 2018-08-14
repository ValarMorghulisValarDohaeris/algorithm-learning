package jianZhiOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * 动态规划+循环的方式。
 * 其实也可以用递归的方式实现，不过可能当数很大的时候，递归过多导致stackOverFlow。
 *
 * Created by hao on 2018/8/13.
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if(n < 0 || n >= 40){
            return -1;
        }

        int last = 0;
        int nextOne = 1;
        while(n-- > 0){
            nextOne += last;
            last = nextOne - last;
        }

        return last;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(5));
    }
}
