package tencent;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(in.nextLine());
            int[] nums = new int[M];

            String numsss = in.nextLine();
            String[] numList = numsss.split(" ");

            for (int j = 0; j < M; j++) {
                nums[j] = Integer.parseInt(numList[j]);
            }

            compute(nums);
        }

        in.close();
        }

    private static void compute(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    boolean success = isTriangle(nums[i], nums[j], nums[k]);

                    if (success) {
                        result += 1;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static boolean isTriangle(int num1, int num2, int num3) {

        int max = Math.max(num1, num2);
        max = Math.max(max, num3);

        if (max == num1) {
            return !fuhe(num1, num2, num3);
        } else if (max == num2) {
            return !fuhe(num2, num3, num1);
        } else if (max == num3) {
            return !fuhe(num3, num1, num2);
        } else {
            return true;
        }
    }

    private static boolean fuhe(int max, int min1, int min2) {
        return (min1 + min2) <= max;
    }
}

//2
//4
//14 21 94 35
//6
//10 16 87 43 51 75
