import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        char res;
        int n;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                n = c;
                res = (char) (n + 13 <= 'z' ? (n + 13) : ('a' + (n + 12) - 'z'));
            } else if (Character.isUpperCase(c)) {
                n = c;
                res = (char) (n + 13 <= 'Z' ? (n + 13) : ('A' + (n + 12) - 'Z'));
            } else
                res = c;

            sb.append(res);
        }
        System.out.println(sb);
        br.close();
    }
}
