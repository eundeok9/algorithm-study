
import java.util.*;
import java.io.*;

public class Solution {

	static int N;
	static int[][] map;
	static int minLength;
	static int maxCore;
	
	
	static class Core {
		int x, y;
		
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
	}
	
	static ArrayList<Core> list;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 1) { // 코어인 경우 코어 위치 리스트에 추가
						map[i][j] = temp;
						
						// 벽에 있는 코어는 추가 안 함
						if(i==0 || j == 0 || i == N-1 || j == N-1) {
							continue;
						}
						list.add(new Core(i,j));
					}
				}
			}
			
			minLength = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			connect(0, 0, 0);
			
			sb.append("#" + tc + " " + minLength + "\n");
		}
		System.out.println(sb);
	}
	
	static void connect(int idx, int cnt, int len) {
		
		if(idx == list.size()) {
			if(maxCore < cnt) { // 코어의 개수가 더 많아 질 때
				maxCore = cnt;
				minLength = len;
			}
			else if(maxCore == cnt) { // 코어의 개수가 같아질 때 전선 길이 비교
				if(minLength > len) minLength = len;
			}
			return;
		}
		
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		
		for(int d = 0; d < 4; d++) {
			int count = 0;
			int nx = x;
			int ny = y;
			
			while(true) {
				nx += dx[d];
				ny += dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) { // 벽 만났을 때(=전선or코어 안만났을 때)이므로 연결 됐다는 뜻
					break;
				}
				
				if(map[nx][ny] == 1) { // 전선 혹은 코어를 만나면 못가므로 break
					count =0;
					break;
				}
				
				count++; // 벽 만난 것도 아니고, 전선or코어가 있는 곳도 아니면 count++
			}
			
			// count한 개수만큼 1로 채워줌
			int originX = x;
			int originY = y;
			
			for(int i=0; i<count; i++) {
				originX += dx[d];
				originY += dy[d];
				
				map[originX][originY] = 1;
			}
			
			// count == 0 이면, 4방 중 어느 방향으로도 전선을 설치할 수 없음
			// 연결된 코어 개수, 전선 길이 그대로 두고 다음 코어 탐색
			if(count == 0) {
				connect(idx+1, cnt, len);
			}
			// count가 되었다는 것은 전선이 깔렸다는 뜻
			// 연결된 코어 개수 1 증가, 전선 길이 count만큼 증가 하고 다음 코어 탐색
			else {
				connect(idx+1, cnt+1, len+count);
				
				
				// 탐색 끝나면 탐색 하기 전 상태로 복원
				originX = x;
				originY = y;
				for(int i=0; i<count; i++) {
					originX += dx[d];
					originY += dy[d];
					
					map[originX][originY] = 0;
				}
			}
		}
	}

}
