import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1 ~ n 까지의 수열로 입력되어 있는 수열을 만들 수 있는지
처음 수까지는 push, 그 다음 pop 한 번
아래에 있는 경우 pop
위에 있는 경우는 거기까지 push하고 pop
이렇게 해서 입력된 결과와 동일한지 확인

동일하면 +- 입력받고
아니면 NO
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder line = new StringBuilder();
        int idx = 0;
        while (n-- > 0) {
            int v = Integer.parseInt(br.readLine());

            if (v > idx) {
                for (int i = idx + 1; i <= v; i++) {
                    stack.push(i);
                    line.append("+\n");
                }

                idx = v;
            }


            else if (v != stack.peek()) {
                System.out.println("NO");
                return;
            }

            System.out.println(stack.pop());
            line.append("-\n");
        }

        System.out.print(line);

        br.close();

    }
}
