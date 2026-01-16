package tencent;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    static class Node {
        int nodeX;
        int nodeY;

        Node(int x, int y) {
            this.nodeX = x;
            this.nodeY = y;
        }

        int dist(int x0, int y0) {
            int d_x = x0 - nodeX;
            int d_y = y0 - nodeY;

            int dist = Math.abs(d_x) + Math.abs(d_y);
            return dist;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String first = in.nextLine();

        int N = Integer.parseInt(first.split(" ")[0]);
        int M = Integer.parseInt(first.split(" ")[1]);

        List<Node> nodes = new ArrayList<>(N);
        List<Node> starts = new ArrayList<>(M);

        for (int i = 0; i < N; i++) {
            String line = in.nextLine();

            int x = Integer.parseInt(line.split(" ")[0]);
            int y = Integer.parseInt(line.split(" ")[1]);

            Node node = new Node(x, y);
            nodes.add(node);
        }

        for (int i = 0; i < M; i++) {
            String line = in.nextLine();

            int x = Integer.parseInt(line.split(" ")[0]);
            int y = Integer.parseInt(line.split(" ")[1]);

            Node node = new Node(x, y);
            starts.add(node);
        }

        in.close();

        for (Node start : starts) {
            int thisResult = 0;

            for (Node node : nodes) {
                int dist = node.dist(start.nodeX, start.nodeY);
                thisResult += dist;
            }

            System.out.println(thisResult);
        }
    }
}


//3 3
//5 5
//5 10
//10 5
//1 1
//5 5
//10 10