package pat.three;

import java.util.Scanner;

/**
 * 1003
 * TODO
 */
public class Main {
    /**
     * 数据结构
     */
    static class Node {
        int id;
        int parentId;

        public Node(int id, int parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }

    public static void main(String[] args) {

        int N;
        Double price;
        Double rise;

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        price = in.nextDouble();
        rise = in.nextDouble();

        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            int parent = in.nextInt();
            Node node = new Node(i, parent);
            nodes[i] = node;
        }

        in.close();

        int maxHigh = 1;

        for (Node node : nodes) {
            while (true) {
                if (nodes[node.parentId].parentId != 0) {
                    maxHigh++;
                } else {
                    break;
                }
            }
        }

    }
}
