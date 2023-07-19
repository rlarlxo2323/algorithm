package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3460 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i<testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            String binary = Integer.toBinaryString(n);
            int length = binary.length();

            StringBuilder answer = new StringBuilder();

            for (int j=length-1; j>=0; j--) {
                if (binary.charAt(j) == '1') {
                    if (answer.length() != 0) {
                        answer.append(" ");
                    }
                    answer.append(Math.abs(j-(length-1)));
                }
            }
            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws IOException {
        new Q3460().solution();
    }
}
