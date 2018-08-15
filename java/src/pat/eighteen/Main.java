package pat.eighteen;

import java.util.Scanner;

/**
 * 1018
 * PASS
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // read
        String s = in.nextLine();
        in.close();

        // segmentation
        String[] nums = s.split("\\s");
        String one = nums[0];
        String two = nums[1];

        // get per value
        String[] num1 = one.split("\\.");
        String[] num2 = two.split("\\.");

        Integer G1 = Integer.valueOf(num1[0]);
        Integer S1 = Integer.valueOf(num1[1]);
        Integer K1 = Integer.valueOf(num1[2]);

        Integer G2 = Integer.valueOf(num2[0]);
        Integer S2 = Integer.valueOf(num2[1]);
        Integer K2 = Integer.valueOf(num2[2]);

        // 计算K，得到进位US，得到结果RK
        Integer[] r1 = computeK(K1, K2);
        Integer US = r1[0];
        Integer RK = r1[1];

        // 计算S+进位US，进位UG，得到结果RS
        Integer[] r2 = computeS(S1, S2, US);
        Integer UG = r2[0];
        Integer RS = r2[1];

        // 计算G+进位UG，得到结果RG
        Integer RG = computeG(G1, G2, UG);

        // write
        String result = RG + "." + RS + "." + RK;
        System.out.println(result);
    }

    private static Integer computeG(Integer g1, Integer g2, Integer ug) {
        return g1 + g2 + ug;
    }

    private static Integer[] computeS(Integer s1, Integer s2, Integer us) {
        int rs = s1 + s2 + us;
        int ug = 0;
        while (rs >= 17) {
            rs -= 17;
            ug++;
        }
        return new Integer[]{ug, rs};
    }

    private static Integer[] computeK(Integer k1, Integer k2) {
        int rk = k1 + k2;
        int us = 0;
        while (rk >= 29) {
            rk -= 29;
            us++;
        }
        return new Integer[]{us, rk};
    }
}
