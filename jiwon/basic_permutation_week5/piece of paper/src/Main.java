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
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int nm = n * m;
        int res = 0;
        for (int i = 0; i < (1 << nm); i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                int cur = 0;

            }

        }

    }
}
