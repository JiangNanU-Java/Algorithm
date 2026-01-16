package xiecheng;

import java.util.*;

public class Main3 {

    static class Cache {
        int size;
        Map<Integer, Node> map;
        Node[] mincount;

        public Cache(int size) {
            map = new HashMap<>(size);
            mincount = new Node[size];
        }

        public void put(int key, int val) {
            if (map.containsKey(key)) {
                map.replace(key, new Node(key, val));
            } else {
                remove();
                map.put(key, new Node(key, val));
                Arrays.sort(mincount);
            }
        }

        public void remove() {
            if (this.map.size() <= size) {
            } else {
                map.remove(mincount[0].key);
            }
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                map.get(key).count++;
                return map.get(key).val;
            }
        }

        static class Node implements Comparable<Node> {
            int key;
            int val;
            int count;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.count = 0;
            }

            @Override
            public int compareTo(Node o) {
                return this.count - o.count;
            }
        }
    }

    public static void main(String[] args) {

    }

}
