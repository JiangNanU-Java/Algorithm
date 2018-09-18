package alimock;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Q:
 * 在一个数组中，有若干个数，每个数字都出现两次，也就是说数组中如果出现了一个2，那必定存在另一个2，
 * 除了一个数仅仅出现了一次，如何在空间复杂度为O(1)的情况下找出这个数。
 * <p>
 * S:
 * 如果一个数组中，每个数字都出现偶数次，只有一个数字出现一次，利用异或即可
 * 如果一个数组中，每个数字都出现奇数(大于1)次，只有一个数字出现一次，那么就用一个32位的数组，
 * 记录所有位中为1的个数，最后数组中每一个数字对这个奇数取余，不为0的，把它取出，按它的位数，转化成十进制的数字。
 */public class Main99 {
    /**
     * 异或运算 ^
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        in.close();
        for (int num : array) {
            for (int i = 0; i < array.length; i++) {
                array[i] ^= num;
            }
        }
    }


}
