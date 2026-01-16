package xiecheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
    static class Time implements Comparable<Time> {
        int id;
        String start;
        String end;

        public boolean compute(String A) {
            return A.compareTo(start) > 0 && end.compareTo(A) > 0;
        }


        @Override
        public String toString() {
            return String.valueOf(id);
        }

        @Override
        public int compareTo(Time o) {
            return this.id - o.id;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String A = in.nextLine();
        List<Time> times = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            Time time = new Time();
            String[] t = in.nextLine().split(" ");
//            System.out.println(t[0]+" "+t[1]+" "+t[2]);
            time.id = Integer.parseInt(t[0]);
            time.start = t[1];
            time.end = t[2];
            times.add(time);
        }
        in.close();
//        System.out.println(times);

        int[] result = new int[N];
        int i = 0;

        for (Time time : times) {
            if (time.compute(A)) {
                result[i] = time.id;
                i++;
            }
        }

        if (result[0] == 0) {
            System.out.println("null");
        }else {
            Arrays.sort(result);
            for (int j = 0; j < result.length; j++) {

                if (result[j] > 0) {
                    System.out.println(result[j]);
                }
            }
        }

    }
}
//10
//20180602
//1001 20180103 20180100
//1001 20180103 20180101
//1001 20180103 20180102
//1001 20180103 20180607
//1001 20180103 20180104
//1001 20180103 20180105
//1001 20180103 20180106
//1001 20180103 20180107
//1001 20180103 20180108
//1003 20180103 20180603