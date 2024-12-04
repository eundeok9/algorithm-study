import java.io.*;
import java.util.*;

public class Main {
   static int R, C, time;
   static char[][] map;
   static int[] dx = {-1, 0, 1, 0};
   static int[] dy = {0, -1, 0, 1};
   static Queue<int[]> water;
   static Queue<int[]> hedgehog;

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       R = Integer.parseInt(st.nextToken());
       C = Integer.parseInt(st.nextToken());
       map = new char[R][C];
       water = new LinkedList<>();
       hedgehog = new LinkedList<>();
       for(int i=0; i<R; i++) {
           String s = br.readLine();
           for(int j=0; j<C; j++) {
               map[i][j] = s.charAt(j);
               if(map[i][j] == 'S') {
                   hedgehog.add(new int[] {i, j});
               } else if(map[i][j] == '*') {
                   water.add(new int[] {i, j});
               }
           }
       }

       System.out.println(bfs() ? time : "KAKTUS");
   }

   public static boolean bfs() {
       while(!hedgehog.isEmpty()) {
           time++;
           int size = water.size();
           for(int i=0; i<size; i++) {
               int[] cur = water.poll();
               for(int d=0; d<4; d++) {
                   int nx = cur[0] + dx[d];
                   int ny = cur[1] + dy[d];
                   if(check(nx, ny) || map[nx][ny] == 'X') continue;
                   if(map[nx][ny] == '*' || map[nx][ny] == 'D') continue;
                   map[nx][ny] = '*';
                   water.add(new int[] {nx, ny});
               }
           }

           size = hedgehog.size();
           for(int i=0; i<size; i++) {
               int[] cur = hedgehog.poll();
               for(int d=0; d<4; d++) {
                   int nx = cur[0] + dx[d];
                   int ny = cur[1] + dy[d];

                   if(check(nx, ny) || map[nx][ny] == 'X') continue;
                   if(map[nx][ny] == '*' || map[nx][ny] == 'S') continue;
                   if(map[nx][ny] == 'D') return true;

                   map[nx][ny] = 'S';
                   hedgehog.add(new int[] {nx, ny});
               }
           }
       }

       return false;
   }

    // 범위 넘어가는지 체크
    public static boolean check(int x, int y) {
        return 0 > x || x >= R || 0 > y || y >= C;
    }
}
