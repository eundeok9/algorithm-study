import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 팀 별 매치
	static int home[] = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int away[] = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int[] win;
	static int[] draw;
	static int[] lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		win = new int[6];
		draw = new int[6];
		lose = new int[6];
		
		for(int tc=0; tc<4; tc++) {
			int total = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<6; i++) {
				win[i] = Integer.parseInt(st.nextToken()); // 이김
				draw[i] = Integer.parseInt(st.nextToken()); // 비김
				lose[i] = Integer.parseInt(st.nextToken()); // 짐
				total += win[i] + draw[i] + lose[i];
			}
			
			if(total > 30) { // 승부 결과의 합이 30이 넘으면 불가능한 결과
				sb.append(0 + " ");
				continue;
			}
			
			if(backtracking(0)) {
				sb.append(1 + " ");
			}
			else {
				sb.append(0 + " ");
			}

		}
		
		System.out.println(sb);
	}
	
	private static boolean backtracking(int game) {
		if(game==15) {
			return true;
		}
		// 홈 팀이 이기는 경우
		if(win[home[game]] > 0 && lose[away[game]] > 0) {
			win[home[game]]--;
			lose[away[game]]--;
			if(backtracking(game + 1)) return true;
			win[home[game]]++;
			lose[away[game]]++;
		}
		
		// 어웨이 팀이 이기는 경우 
		if(lose[home[game]] > 0 && win[away[game]] > 0) {
			lose[home[game]]--;
			win[away[game]]--;
			if(backtracking(game + 1)) return true;
			lose[home[game]]++;
			win[away[game]]++;
		}
		
		// 비기는 경우 
		if(draw[home[game]] > 0 && draw[away[game]] > 0) {
			draw[home[game]]--;
			draw[away[game]]--;
			if(backtracking(game + 1)) return true;
			draw[home[game]]++;
			draw[away[game]]++;
		}
				
		return false;
	}

}
