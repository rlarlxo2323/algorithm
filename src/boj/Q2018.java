package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2018 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numArray = new int[N];

        for (int i = 0; i < N; i++) {
            numArray[i] = i+1;
        }

        int start = 0;
        int end = 0;
        int cnt = 1;
        int sum = 0;

        while (start != N-1) {
            if (sum < N) {
                sum += numArray[end];
                end++;
                continue;
            }
            if (sum > N) {
                sum -= numArray[start];
                start++;
                continue;
            }
            if (sum == N) {
                cnt++;
                sum += numArray[end];
                end++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        new Q2018().solution();
    }
}
