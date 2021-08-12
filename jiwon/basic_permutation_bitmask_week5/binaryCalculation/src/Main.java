import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a[] = br.readLine().split("");
        String b[] = br.readLine().split("");

        for (int i = 0; i < a.length; i++)
            sb.append(Integer.parseInt(a[i]) & Integer.parseInt(b[i]));
        sb.append("\n");

        for (int i = 0; i < a.length; i++)
            sb.append(Integer.parseInt(a[i]) | Integer.parseInt(b[i]));
        sb.append("\n");

        for (int i = 0; i < a.length; i++)
            sb.append(Integer.parseInt(a[i]) ^ Integer.parseInt(b[i]));
        sb.append("\n");

        for (String s : a) sb.append(Integer.parseInt(s) ^ 1);
        sb.append("\n");

        for (String s: b)
            sb.append(Integer.parseInt(s) ^ 1);

        System.out.print(sb.toString());
        br.close();
    }
}
