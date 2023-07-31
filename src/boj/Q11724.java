package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11724 {
    public boolean[] visited;
    public ArrayList<Integer>[] list;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        // 노드 정보 초기화
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        // 노드 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }

    public void dfs(int idx) {
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;
        for (int n : list[idx]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Q11724().solution();
    }
}
