/*
직사각형 종이
길이가 N인 조각은 N자리 수로 나타낼 수 있다.
종이를 적절히 잘라 조각의 합을 최대로 하는 프로그램을 작성

생각
- 앞자리가 제일 큰 수가 나올 수 있게 하면 되는데..
- 비트마스크...
- 모든 경우의 수는 얼마나 될까
- 숫자는 주변의 것만 자를 수 있다.
-
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int nm = n * m;
        board = new int[n][m];
        for (int i = 0; i < n; i++)
            board[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        int result = 0;
        int a = 0;
        for (int s = 0; s < (1 << nm); s++) {
           int sum = pieceOfPaper(s, n, m, a++);
           sum += pieceOfPaper(s, m, n, a++);
           result = Math.max(result, sum);
        }
        System.out.println(result);
    }

    static int pieceOfPaper(int s, int row, int col, int a) {
        int sum = 0;
        for (int i = 0; i < row; i++) {
            int cur = 0;
            for (int j = 0; j < col; j++) {
                if (a % 2 == 0) {
                    int k = i * col + j;
                    if ((s & (1 << k)) == 0)
                        cur = cur * 10 + board[i][j];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                } else {
                    int k = j * row + i;
                    if ((s & (1 << k)) != 0)
                        cur = cur * 10 + board[j][i];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
            }
            sum += cur;
        }
        return sum;
    }
}
