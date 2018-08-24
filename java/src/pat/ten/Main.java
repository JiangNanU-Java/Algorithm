package pat.ten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * PASS
 */
public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Deque<Node> deque = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    private static Node[] nodes;
    private static int[] values;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        values = new int[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            String[] s = br.readLine().split(" ");
            nodes[i].leftIndex = Integer.parseInt(s[0]);
            nodes[i].rightIndex = Integer.parseInt(s[1]);
        }

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(s[i]);
        }

        br.close();
        Arrays.sort(values);

        Node current = nodes[0];
        recursive(current, 0);

        deque.offer(nodes[0]);
        output();

        System.out.print(sb.toString().trim());
    }

    private static void output() {
        if (deque.isEmpty()) {
            return;
        }
        Node current = deque.pop();
        sb.append(current.value).append(" ");
        if (current.leftIndex != -1) {
            deque.offer(nodes[current.leftIndex]);
        }
        if (current.rightIndex != -1) {
            deque.offer(nodes[current.rightIndex]);
        }
        output();
    }

    private static int recursive(Node current, int index) {
        if (current.leftIndex != -1) {
            index = recursive(nodes[current.leftIndex], index);
        }

        current.value = values[index];
        index++;

        if (current.rightIndex != -1) {
            index = recursive(nodes[current.rightIndex], index);
        }
        return index;
    }

    static class Node {
        int leftIndex;
        int rightIndex;
        int value;
    }
}
