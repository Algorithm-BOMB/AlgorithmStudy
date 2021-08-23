import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
()가 만나면 stack.size만큼 더하기
))가 만나면 + 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int res = 0;
        int cnt = 0;
        String pre = "";
        for (int i = 0; i < s.length(); i++) {
            String c = Character.toString(s.charAt(i));
            if (c.contentEquals("(")) {
                stack.push("(");
                cnt += 1;
                pre = "(";
            } else {
                stack.pop();
                cnt -= 1;
                if (pre.contentEquals(")"))
                    res++;
                else
                    res += cnt;
                pre = ")";
            }
        }
        System.out.println(res);
        br.close();
    }
}
