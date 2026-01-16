package recruit.byte01;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 * TODO
 *
 * @author wshten
 * @date 2018/8/23 0023
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(sc.nextLine());
        }
        String[] numbers = list.get(0).split(" ");
        int groupnumber = Integer.parseInt(list.get(1).trim());
        for (int i = 2; i < list.size(); i++) {
            int count = 0;
            String[] grouparr = list.get(i).split(" ");
            int start = Integer.parseInt(grouparr[0]);
            int end = Integer.parseInt(grouparr[1]);
            for (int j = start - 1; j <= end - 1; j++) {
                if (numbers[j].equals(grouparr[2])) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
