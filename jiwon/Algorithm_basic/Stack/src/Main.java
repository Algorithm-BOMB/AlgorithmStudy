import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("\\s");
            if (inputs[0].contentEquals("push")) {
                stack.push(inputs[1]);
            } else if (inputs[0].contentEquals("top")) {
                if (stack.empty())
                    sb.append("-1\n");
                else
                    sb.append(stack.peek() + "\n");
            } else if (inputs[0].contentEquals("size")) {
                sb.append(stack.size() + "\n");
            } else if (inputs[0].contentEquals("empty")) {
                if (stack.empty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
            } else if (inputs[0].contentEquals("pop")) {
                if (!stack.empty())
                    sb.append(stack.pop() + "\n");
                else
                    sb.append("-1\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
