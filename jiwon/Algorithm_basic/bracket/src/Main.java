import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
'('인 것은 모두 스택에 넣고 ')'가 나오면 스택에서 pop
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<String> stack = new Stack<>();
            String s = br.readLine();
            int j;
            for (j = 0; j < s.length(); j++) {
                String c = Character.toString(s.charAt(j));
                if (c.contentEquals("("))
                    stack.push(c);
                else if (!stack.isEmpty() && c.contentEquals(")"))
                    stack.pop();
                else if (stack.isEmpty() && c.contentEquals(")"))
                    break;
            }
            if (j == s.length() && stack.size() == 0)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
        br.close();
    }
}
