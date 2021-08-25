import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                StringBuilder sb = new StringBuilder();
                int[] count = new int[4];
                String s = br.readLine();
                for (int i = 0; i < s.length(); i++) {
                    byte c = (byte) s.charAt(i);
                    if ('A' <= c && c <= 'Z')
                        count[1]++;
                    else if ('a' <= c && c <= 'z')
                        count[0]++;
                    else if ('0' <= c && c <= '9')
                        count[2]++;
                    else
                        count[3]++;
                }
                for (int i : count)
                    sb.append(i).append(" ");
                System.out.println(sb.toString().trim());
            } catch (Exception e) {
                break;
            }

        }

        br.close();

    }
}
