package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11720 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String str = br.readLine();

        char[] strArray = str.toCharArray();

        int sum = 0;

        for (char a : strArray) {
            sum += Character.getNumericValue(a);
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        new Q11720().solution();
    }
}
