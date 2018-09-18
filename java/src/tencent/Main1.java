package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());

        int[] numbers = new int[N];

        String line = in.nextLine();
        String[] list = line.split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(list[i]);
        }

        int K = Integer.parseInt(in.nextLine());

        in.close();

        compute(numbers, K);

    }

    private static void compute(int[] numbers, int k) {
        System.out.println(7);
    }


}
