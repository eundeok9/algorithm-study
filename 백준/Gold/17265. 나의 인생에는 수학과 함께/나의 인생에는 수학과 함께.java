import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static char[][] map;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, map[0][0] - '0', ' ');

        System.out.println(max + " " + min);
    }

    public static void dfs(int x, int y, int current, char oper) {
        if(x == N-1 && y == N-1) {
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for(int d=0; d<2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < N && ny < N) {
                char next = map[nx][ny];
                
                if(Character.isDigit(next)) {
                    int num = next - '0';
                    int nextVal = current;

                    if(oper == '+') {
                        nextVal += num;
                    } else if(oper == '-') {
                        nextVal -= num;
                    } else if(oper == '*') {
                        nextVal *= num;
                    }
                    
                    dfs(nx, ny, nextVal, ' ');
                } else {
                    dfs(nx, ny, current, next);
                }
            }
        }
    }
}