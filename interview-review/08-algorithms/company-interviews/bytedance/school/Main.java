package bytedance.school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static Person[] people;

    static class Person {
        int id;
        List<Integer> link = new LinkedList<>();

        public void addLink(int num) {
            link.add(num);
        }
    }

    public static void main(String[] args) throws IOException {
        // 1.读入
        int n = Integer.parseInt(br.readLine().trim());
        people = new Person[n];

        for (int i = 0; i < n; i++) {
            String[] links = br.readLine().split(" ");

            Person person = new Person();
            person.id = i + 1;
            for (String s : links) {
                if (!s.equals("0")) {
                    person.addLink(Integer.parseInt(s));
                }
            }

            people[i] = person;
        }

        br.close();

        List<Set<Integer>> collections = new ArrayList<>();
        for (Person person : people) {

            boolean success = false;
            // 若有Id 添加link
            for (Set<Integer> c : collections) {
                if (!success) {
                    if (c.contains(person.id)) {
                        c.addAll(person.link);
                        success = true;
                        break;
                    }
                }
            }

            if (!success) {
                // 若有link link
                for (Set<Integer> c : collections) {
                    if (!success) {
                        for (Integer link : person.link) {
                            if (c.contains(link)) {
                                c.add(person.id);
                                c.addAll(person.link);
                                success = true;
                                break;
                            }
                        }
                    }

                }

                if (!success) {
                    Set<Integer> c = new HashSet<>();
                    c.add(person.id);
                    c.addAll(person.link);
                    collections.add(c);
                }
            }
        }

        for (int i = 0; i < collections.size(); i++) {
            if (collections.get(i) != null) {
                for (int j = i + 1; j < collections.size(); j++) {
                    if (collections.get(j) != null) {
                        for (Integer v : collections.get(j)) {
                            if (collections.get(i).contains(v)) {
                                collections.get(i).addAll(collections.get(j));
                                collections.remove(j);
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(collections);
    }
}