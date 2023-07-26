package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12891 {
    public int[] myArray;
    public int[] checkArray;
    public int result = 0;

    public void isValid() {
        for (int i = 0; i < 4; i++) {
            if (checkArray[i] > myArray[i]) {
                return;
            }
        }
        result++;
    }

    public void add(char a) {
        if (a == 'A') {
            myArray[0] += 1;
        } else if (a == 'C') {
            myArray[1] += 1;
        } else if (a == 'G') {
            myArray[2] += 1;
        } else {
            myArray[3] += 1;
        }
    }

    public void subtract(char a) {
        if (a == 'A') {
            myArray[0] -= 1;
        } else if (a == 'C') {
            myArray[1] -= 1;
        } else if (a == 'G') {
            myArray[2] -= 1;
        } else {
            myArray[3] -= 1;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] strArray = br.readLine().toCharArray();
        checkArray = new int[4];
        myArray = new int[4];
        int idx = P;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            add(strArray[i]);
        }

        isValid();

        for (int i = 0; i < S - P; i++) {
            subtract(strArray[i]);
            add(strArray[idx]);
            isValid();
            idx++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Q12891().solution();
    }
}
