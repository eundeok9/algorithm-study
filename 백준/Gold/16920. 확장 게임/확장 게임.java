import java.io.*;
import java.util.*;
public class Main {
    static int N, M, P;
    static char[][] map;
    static int[] S;
    static Queue<Node>[] queue;
    static boolean[][] visited;
    static int[] answer = new int[10];
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        queue = new Queue[P+1];
        for(int i=0; i<=P; i++) {
            queue[i] = new LinkedList<Node>();
        }

        st = new StringTokenizer(br.readLine());
        S = new int[P+1];
        for(int i=1; i<=P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for(int j=0; j<M; j++) {
                if(map[i][j] >= '1' && map[i][j] <= '9') {
                    visited[i][j] = true;
                    queue[map[i][j] - '0'].add(new Node(i, j));
                    answer[map[i][j]-'0'] += 1;
                }
            }
        }

        bfs();

        for(int i=1; i<=P; i++) {
            System.out.print(answer[i] + " ");
        }

    }

    public static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean flag = false;
        while(!flag) {
            flag = true;
            for(int i=1; i<=P; i++) {
                int s = S[i];
                int size = queue[i].size();
                int cnt = 0;
                int cycleCnt = 0;
                while(!queue[i].isEmpty() && cycleCnt < s) {
                    Node cur = queue[i].poll();
                    for(int d=0; d<4; d++) {
                        int nr = cur.r + dx[d];
                        int nc = cur.c + dy[d];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                        if(visited[nr][nc]) continue;
                        if(map[nr][nc] == '#') continue;
                        visited[nr][nc] = true;
                        answer[i] += 1;
                        flag = false;
                        queue[i].add(new Node(nr, nc));
                    }
                    cnt += 1;

                    if(size == cnt) {
                        size = queue[i].size();
                        cnt = 0;
                        cycleCnt += 1;
                    }
                }
            }
        }
    }
}