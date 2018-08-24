package pat.sixteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int np = Integer.parseInt(in.next());
        int ng = Integer.parseInt(in.next());

        int[] goals = new int[np];
        int i = 0;
        while (in.hasNext()) {
            goals[i] = Integer.parseInt(in.next());
            i++;
        }

        // 顺序队列
        List<Integer> sequence = new ArrayList<>(np);
        while (in.hasNext()) {
            sequence.add(Integer.parseInt(in.next()));
        }

        List<Integer> winner = compute(ng, sequence, goals);

    }

    private static List<Integer> compute(int ng, List<Integer> sequence, int[] goals) {
        List<Integer> match = new ArrayList<>(ng);
        for (int i = 0; i < ng; i++) {
            match.add(sequence.get(i));

        }

        return null;
    }


}