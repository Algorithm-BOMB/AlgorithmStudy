import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split("\\s");
            for (int j = 0; j < s.length; j++) {
                for (int k = 0; k < s[j].length(); k++)
                    stack.push(Character.toString(s[j].charAt(k)));
                for (int k = 0; k < s[j].length(); k++)
                    sb.append(stack.pop());
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
