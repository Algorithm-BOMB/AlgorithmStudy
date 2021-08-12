/*
원소 추가
n = 3
print(bin(0b0010 | (1 << n)))  #  0b1010

원소 제거
n = 3
print(bin(0b1010 & ~(1 << n)))  #  0b10

원소 조회
n = 3
print(bin(0b1010 & (1 << n)))  #  0b1000

원소 토글
n = 3
print(bin(0b1010 ^ (1 << n)))  #  0b10

풀이
1.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int num = 0;
        int n = 0;
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split("\\s");
            if (!s[0].contentEquals("all") && !s[0].contentEquals("empty"))
                n = Integer.parseInt(s[1]);
            if (s[0].contentEquals("add"))
                num = add(num, n);
            else if (s[0].contentEquals("remove"))
                num = remove(num, n);
            else if (s[0].contentEquals("check"))
                num = check(num, n);
            else if (s[0].contentEquals("toggle"))
                num = toggle(num, n);
            else if (s[0].contentEquals("all"))
                num = all(num);
            else
                num = empty();
        }
        System.out.print(sb.toString());
    }

    public static int add(int num, int n) {
        return (num | (1 << n));
    }
    public static int remove(int num, int n) {
        return (num & ~(1 << n));
    }
    public static int check(int num, int n) {
        int temp = num & (1 << n);
        sb.append(temp != 0 ? 1 : 0).append("\n");
        return num;
    }
    public static int toggle(int num, int n) {
        return (num ^ (1 << n));
    }
    public static int all(int num) {
        return (num | ((1 << 21) - 1));
    }
    public static int empty() {
        return 0;
    }
}
