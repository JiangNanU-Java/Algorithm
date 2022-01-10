package bytedance.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    static List<String[]> strings;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = Integer.parseInt(in.nextLine());
        strings = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            int row = Integer.parseInt(in.nextLine());
            String[] strings1 = new String[row];
            for (int j = 0; j < row; j++) {
                strings1[j] = in.nextLine();
            }
            strings.add(strings1);
        }
        in.close();

        for (String[] strings2:strings) {
            for (int i = 0; i < strings2.length; i+=2) {
                compute(strings2[i], strings2[i+1]); }
        }

    }

    private static void compute(String s1, String s2) {
        String circle1 = s1 + s1;
        int n = circle1.length();
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            temp[i] = circle1.charAt(n - i - 1);
        }
        String circle2 = String.valueOf(temp);


        if (circle1.contains(s2) || circle2.contains(s2)) {
            System.out.println("Yeah");
        } else {
            System.out.println("Sad");
        }
    }
}
