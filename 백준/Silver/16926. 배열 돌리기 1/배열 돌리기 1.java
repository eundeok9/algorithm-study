import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 배열 입력 받기 
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = Math.min(N, M)/2;
		

		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		while(R>0) {
			for(int i=0; i<cnt; i++) {
				// 각 테두리의 시작 위치는 (0,0), (1,1) , ... (i, i)
				int x = i;
				int y = i;
				int temp = map[x][y];
				
				int d = 0;
				while(d < 4) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (nx >= i && nx < N-i && ny >= i && ny < M-i) {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					} else {
						d++;
					}
				}
				map[x+1][y] = temp;
			}
			R--;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
