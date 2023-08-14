import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static int[][] map;
	static int[][] tmpMap; // map 배열 사본
	static int[][] operate; // 연산 정보
	static int[] order; // 연산 순서
	static boolean[] isSelected; // 순열에서 선택 여부 저장
	static int answer;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열의 크기
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 회전 연산 개수
		
		// 배열 입력 받기
		map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		operate = new int[K][3]; // 연산 정보 (r, c, s)를 2차원 배열에 행을 기준으로 저장
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			operate[k][0] = Integer.parseInt(st.nextToken());
			operate[k][1] = Integer.parseInt(st.nextToken());
			operate[k][2] = Integer.parseInt(st.nextToken());
		}
		
		order = new int[K];
		isSelected = new boolean[K];
		answer = Integer.MAX_VALUE;
		perm(0);
		
		System.out.println(answer);
		
	}
	
	private static int[][] copyMap() {
		int[][] tmp = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		return tmp;
	}
	
	private static void perm(int cnt) {
		if(cnt == K) {
			rotate(order);

			return;
		}
		for(int i=0; i<K; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			order[cnt] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	private static void rotate(int[] arr) {
		int[][] tmp = copyMap();
		
		
		for(int k=0; k<K; k++) {
			int r = operate[order[k]][0];
			int c = operate[order[k]][1];
			int s = operate[order[k]][2];
			
			// 시계방향
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			
			// 배열 돌리기 1 방법으로 해보려고 했지만.. 실패하였습니다...
			int R = (r+s) - (r-s) +1; // (r-s,c-s)~(r+s, c+s) 행의 수
			int C = (c+s) - (c-s) +1; // (r-s,c-s)~(r+s, c+s) 열의 수
			int cnt = Math.min(R, C) /2; // 회전 횟수
			
			for(int i=0; i<cnt; i++) {
				// 각 테두리의 시작 x, y는 대각선방향으로 가니까 i를 더해준다..
				int startX = r-s + i;
				int startY = c-s + i;
				int temp = tmp[startX][startY]; // 시작위치 임시 저장
				int temp2 = 0;
				
				int d =0;
				while(d < 4) {
					int nx = startX + dx[d];
					int ny = startY + dy[d];
					
					if (nx >= r-s+i && nx <= r+s-i && ny >= c-s+i && ny <= c+s-i) { // 연산이 정해준 범위를 넘어가지 않았을 때
						temp2 = tmp[nx][ny];
						tmp[nx][ny] = temp;
						startX = nx;
						startY = ny;
					} else { // 범위를 넘어가면
						d++; // 방향 전환
					}
					temp = temp2;
				}
			}	
		}
		
		getAnswer(tmp);
	}
	
	private static void getAnswer(int[][] tmp) {
		for(int i=1; i<=N; i++) {
			int tmpMin = 0;
			for(int j=1; j<=M; j++) {
				tmpMin += tmp[i][j];
			}
			if(tmpMin < answer) answer = tmpMin;
		}
	}
}
