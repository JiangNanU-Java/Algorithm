package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c = (char) br.read();
        char c2 = (char) br.read();
        char c3 = (char) br.read();
        System.out.println(c + " " + c2 + " " + c3);

        String s = br.readLine();
        String s2 = br.readLine();
        System.out.println(s);
        System.out.println(s2);

        br.close();
    }
}
