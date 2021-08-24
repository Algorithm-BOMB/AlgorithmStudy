import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
풀이
1. 피연산자는 출력
2. 연산자는 연산순위가 같거나 낮은 건 스택에서 모두 pop
3. (가 나오면 일단 스택에 push
4. )가 나오면 (가 나올 때까지 모두 pop
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split("");
        for (String s : str) {
            if (Character.isLetter(s.charAt(0)))
                sb.append(s);
            else {
                if (s.contentEquals("*") ||
                        s.contentEquals("/")) {
                    while (!stack.isEmpty() &&
                            (stack.peek().contentEquals("*") || stack.peek().contentEquals("/")))
                        sb.append(stack.pop());
                } else if (s.contentEquals("+") || s.contentEquals("-")) {
                    while (!stack.isEmpty() &&
                            !stack.peek().contentEquals("("))
                        sb.append(stack.pop());
                } else if (s.contentEquals(")")) {
                    while (!stack.isEmpty()) {
                        String op = stack.pop();
                        if (op.contentEquals("("))
                            break;
                        sb.append(op);
                    }
                }
                if (!s.contentEquals(")"))
                    stack.push(s);
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb);
        br.close();
    }
}
