package recruit.byte01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 测试nextInt和nextLine->再分割 的性能问题
 *
 * @author wshten
 * @date 2018/8/23 0023
 */
public class Test {

    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);


//        long time1 = readline();
        long time2 = readints();

        in.close();

//        System.out.println(time1);
        System.out.println(time2);

        // int 621 599
        // line

        /* test case:
100
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
         */
    }

    private static long readints() {
        int n = in.nextInt();

        long start = System.currentTimeMillis();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));

        return end - start;
    }

    private static long readline() {
        int n = in.nextInt();

        long start = System.currentTimeMillis();

        in.nextLine();
        int[] arr = new int[n];
        String nums = in.nextLine();
        String[] numList = nums.split(" ");

        long end = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numList[i]);
        }

        System.out.println(Arrays.toString(arr));

        return end - start;
    }
}
