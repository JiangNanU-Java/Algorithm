package recruit.byte01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1.读数据
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] userLikes = new int[n];
        for (int i = 0; i < n; i++) {
            userLikes[i] = in.nextInt();
        }

        int q = in.nextInt();
        int[][] querySet = new int[q][3];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 3; j++) {
                querySet[i][j] = in.nextInt();
            }
        }

        in.close();

        StringBuilder builder = new StringBuilder();
        for (int[] query : querySet) {
            builder.append(compute(userLikes, query)).append("\n");
        }

        System.out.println(builder.toString().trim());
    }

    // 计算人数
    private static int compute(int[] userLikes, int[] query) {
        int count = 0;

        for (int i = query[0] - 1; i < query[1]; i++) {
            if (userLikes[i] == query[2]) {
                count++;
            }
        }

        return count;
    }
}
