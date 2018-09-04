package xiecheng;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        String buf = binary(num);
        in.close();
        compute(buf);
    }

    private static String  binary(long num){
        String buffer = Long.toBinaryString(num);
        return buffer;
    }

    private static void compute(String buf){
        System.out.println(buf.chars().filter(item -> item == '1').count());
    }
}
