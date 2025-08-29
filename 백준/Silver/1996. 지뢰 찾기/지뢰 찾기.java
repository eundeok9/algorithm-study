import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != '.') {
                    sb.append("*");
                    continue;
                }

                int sum = 0;

                for(int d=0; d<8; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if(0<=ni && ni<N && 0<=nj && nj<N) {
                        char c = map[ni][nj];
                        if('1' <= c && c<= '9') sum += c-'0';
                    }
                }

                sb.append(sum >= 10 ? 'M' : (char)('0'+sum));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
