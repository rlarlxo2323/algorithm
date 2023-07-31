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
    public int N,M;

    public Pos getPos(int idx, Pos now) {
        int x = now.x;
        int y = now.y;
        int level = now.level;
        int ix = dx[idx];
        int iy = dy[idx];

        if (x+ix >= 0 && x+ix < arr.length
        && y+iy >= 0 && y+iy < arr[0].length
        && arr[x+ix][y+iy] != 0) {
            x += ix;
            y += iy;
        }
        return new Pos(x, y, level + 1);
    }

    public int bfs(Pos start) {
        Queue<Pos> q = new LinkedList<>();
        visited[start.x][start.y] = true;
        q.add(start);
        while (!q.isEmpty()) {
            Pos now = q.poll();
            int x = now.x;
            int y = now.y;
            int level = now.level;

            if (x == N-1 && y == M-1) {
                return level;
            }

            for (int i = 0; i < 4; i++) {
                Pos next = getPos(i, now);
                if (!visited[next.x][next.y]) {
                    visited[next.x][next.y] = true;
                    q.add(next);
                }
            }
        }
        return -1;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        System.out.println(bfs(new Pos(0, 0, 1)));
    }

    public static void main(String[] args) throws IOException {
        new Q2178().solution();
    }
}

class Pos {
    public int x;
    public int y;
    public int level;

    public Pos(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}
