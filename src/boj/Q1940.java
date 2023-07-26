package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1940 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] numArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArray);

        int start = 0;
        int end = N-1;
        int cnt = 0;

        while (start < end) {
            int sum = numArray[start] + numArray[end];
            if (sum > M) {
                end--;
                continue;
            }
            if (sum < M) {
                start++;
                continue;
            }
            if (sum == M) {
                cnt++;
                end--;
                start++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        new Q1940().solution();
    }
}
