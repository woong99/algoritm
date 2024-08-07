import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;

    private static int m;

    private static int[] arr;

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        dfs(0);

        bw.flush();
        bw.close();
    }

    private static void dfs(int r) throws IOException {
        if (r == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]);
                if (i != m - 1) {
                    sb.append(" ");
                }
            }
            bw.write(sb.toString());
            bw.newLine();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[r] = i + 1;
                dfs(r + 1);
                visited[i] = false;
            }
        }
    }
}