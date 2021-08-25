import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphaCount = new int[26];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            byte c = (byte) s.charAt(i);
            alphaCount[c - 97] += 1;
        }
        for (int i : alphaCount)
            sb.append(i).append(" ");
        System.out.println(sb.toString().trim());
        br.close();
    }
}
