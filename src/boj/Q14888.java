package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14888 {
    private int maximum = Integer.MIN_VALUE;
    private int minimum = Integer.MAX_VALUE;
    private int[] numList;
    private final int[] opList = new int[4];

    public void dfs(int depth, int num, int plus, int minus, int multi, int divide, int maxDepth) {
        if (depth == maxDepth) {
            maximum = Math.max(maximum, num);
            minimum = Math.min(minimum, num);
            return;
        }

        if (plus > 0) {
            dfs(depth + 1, num + numList[depth], plus-1, minus, multi, divide, maxDepth);
        }
        if (minus > 0) {
            dfs(depth + 1, num - numList[depth], plus, minus-1, multi, divide, maxDepth);
        }
        if (multi > 0) {
            dfs(depth + 1, num * numList[depth], plus, minus, multi-1, divide, maxDepth);
        }
        if (divide > 0) {
            dfs(depth + 1, num / numList[depth], plus, minus, multi, divide-1, maxDepth);
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numList = new int[n];

        StringTokenizer numSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numList[i] = Integer.parseInt(numSt.nextToken());
        }

        StringTokenizer opSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opList[i] = Integer.parseInt(opSt.nextToken());
        }

        dfs(1, numList[0], opList[0], opList[1], opList[2], opList[3], n);
        System.out.println(maximum);
        System.out.println(minimum);
    }

    public static void main(String[] args) throws IOException {
        new Q14888().solution();
    }
}
