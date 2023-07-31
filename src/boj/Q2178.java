package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    public boolean[][] visited;
    public int[][] arr;
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        bfs(0, 0);
    }

    public void bfs(int ix, int iy) {
        Queue<Integer> q = new LinkedList<>();
//        visited
    }

    public static void main(String[] args) throws IOException {
        new Q2178().solution();
    }
}

class Pos {
    public int x;
    public int y;

}
