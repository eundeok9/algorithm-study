import java.io.*;
import java.util.*;

public class Main {

	static int[][] myBingo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Deque<Integer> queue = new ArrayDeque<Integer>();

		// 철수 빙고판 입력 받기
		myBingo = new int[5][5]; 
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				myBingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자 빙고판 입력 받기
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				queue.addLast(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		// 빙고 값 비교 후 빙고 조건 완성 되면 횟수 출력
		int cnt = 1;
		while(!queue.isEmpty()) {
			int num = queue.pollFirst(); // 사회자가 부른 숫자 순서대로 꺼냄
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(myBingo[i][j]==num) { // 사회자가 부른 값이랑 빙고판의 숫자가 같으면 체크
						myBingo[i][j] = -1;
						break;
					}
				}
			}
			if(cnt >= 12) { // 3 빙고가 채워질 수 있는 최소 횟수 
				if(checkBingo()) { // 빙고판 체크 후 빙고 조건이 완성되면 횟수 출력
					System.out.println(cnt);
					queue.clear();
					break;
				}
			}
			cnt++; // 빙고 조건이 아직 완성되지 않았으면 횟수 증가
		}


	}
	
	private static boolean checkBingo() {
		int bingoCnt = 0;
		int sum = 0;
		
		// 가로 줄 체크
		for(int i=0; i<5; i++) {
			sum = 0;
			for(int j=0; j<5; j++) {
				sum += myBingo[i][j];
			}
			if(sum == -5) bingoCnt++; // 빙고 한 줄이 다 체크되면 한 줄을 이루는 숫자들의 합이 -5이므로 1빙고
		}
		
		// 세로 줄 체크
		for(int i=0; i<5; i++) {
			sum =0;
			for(int j=0; j<5; j++) {
				sum += myBingo[j][i];
			}
			if(sum == -5) bingoCnt++;
		}
		
		
		// 대각선(왼쪽위->오른쪽아래) 체크
		sum = 0;
		for(int i=0; i<5; i++) {
			sum += myBingo[i][i];
			if(sum==-5) bingoCnt++;
		}
		
		// 대각선 체크(오른쪽위->왼쪽아래)
		sum = 0;
		for(int i=0; i<5; i++) {
			sum += myBingo[i][4-i];
			if(sum==-5) bingoCnt++;
		}

		
		if (bingoCnt >= 3) {
			return true;
		}
		return false;
	}

}
