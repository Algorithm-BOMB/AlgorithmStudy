import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int c = (byte)s.charAt(i) - (byte)'a';
            if (alpha[c] == -1)
                alpha[c] = i;
        }
        for (int i : alpha)
            sb.append(i).append(" ");
        System.out.println(sb.toString().trim());
        br.close();
    }
}
