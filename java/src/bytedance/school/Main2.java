package bytedance.school;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        if (n == 1) {
            System.out.println(10);
        } else if (n == 2) {
            System.out.println(100);
        } else {
            BigDecimal num1 = compute(n);

            BigDecimal num2 = new BigDecimal(0);
            for (int i = 1; i < n - 1; i++) {
                BigDecimal left = compute(i);
                BigDecimal right = compute(n - i - 1);
                BigDecimal total = (left.add(right));
                num2.add(total).add(total);
            }

            BigDecimal t = num1.add(num2);

            // t % 1000000007
            System.out.println(t.divideAndRemainder(BigDecimal.valueOf(1000000007))[1]);
        }
    }

    // 计算1，2两种表达式的个数
    private static BigDecimal compute(int n) {
        BigDecimal num1 = BigDecimal.valueOf(Math.pow(10, n));
        BigDecimal num2 = BigDecimal.valueOf(Math.pow(10, n - 2));
        return num1.add(num2);
    }
}
