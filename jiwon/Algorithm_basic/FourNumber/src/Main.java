import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        long ab = Long.parseLong(s[0] + s[1]);
        long cd = Long.parseLong(s[2] + s[3]);
        System.out.println(ab + cd);
        br.close();
    }
}
