import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        char[][] tmpMap = new char[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(tmpMap[i], '.');
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == 'X') {
                    int cnt = 0;
                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(0 <= nx && nx < R && 0 <= ny && ny < C) {
                            // 주변이 물인 경우
                            if(map[nx][ny] == '.') {
                                cnt++;
                            }
                        } else { // 범위를 벗어나는 곳인 경우
                            cnt++;
                        }
                    }
                    if(cnt < 3) {
                        tmpMap[i][j] = 'X';
                        minR = Math.min(minR, i);
                        maxR = Math.max(maxR, i);
                        minC = Math.min(minC, j);
                        maxC = Math.max(maxC, j);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=minR; i<=maxR; i++) {
            for(int j=minC; j<=maxC; j++) {
                sb.append(tmpMap[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}