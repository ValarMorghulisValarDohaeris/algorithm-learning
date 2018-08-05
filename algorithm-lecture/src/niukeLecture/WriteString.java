package niukeLecture;

import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by hao on 2018/7/8.
 */
public class WriteString {
    private static boolean flag = false;

    static class Write extends Thread{
        @Override
        public void run() {
            flag = true;
            System.out.println("设置完毕：" + System.currentTimeMillis());
        }
    }

    static class Read extends Thread{
        @Override
        public void run() {
            int i = 10;
            while(i>0){
                if(flag==true){
                    System.out.println("11111" + System.currentTimeMillis());
                    i--;
                    continue;
                }
                System.out.println("ddddddddddddd");
            }
        }
    }

    public static void main(String[] args){
        Thread t1 = new Thread(new Write());
        Thread t2 = new Thread(new Read());
        t2.start();
        t1.start();
    }
}
