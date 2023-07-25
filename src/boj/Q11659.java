package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numArray = new int[N];
        int[] sumArray = new int[N];

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            numArray[i] = target;

            if (i == 0) {
                sumArray[i] = target;
                continue;
            }
            sumArray[i] = sumArray[i-1]+target;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(st.nextToken())-1;
            int o2 = Integer.parseInt(st.nextToken())-1;
            int result = 0;
            if (o1 == 0) {
                result = sumArray[o2];
            } else {
                result = sumArray[o2] - sumArray[o1-1];
            }

            System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        new Q11659().solution();
    }
}
