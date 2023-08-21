import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// A 5분(=300초), B 1분(=60초), C 10초
		// A, B, C 누르는 횟수의 합 => 최소가 되도록

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // t초
		
		int aCnt = 0; // a 버튼 누른 횟수
		int bCnt = 0; // b 버튼 누른 횟수
		int cCnt = 0; // c 버튼 누른 횟수
		boolean isPossible = true; // 버튼 3개로 시간 맞추는게 가능한지 여부 판단
		
		if(T % 10 != 0) { // T가 10으로 나누어 떨어지지 않으면 버튼 3개로 시간 맞추는 것 불가능
			isPossible = false;
		}
		else {
			while(T != 0) { // 시간이 0이 될때까지 반복문 수행 
				if(T >= 300) { // 5분(=300초)보다 클 때 a버튼 누른 횟수 증가해주고 T에서 300 빼줌
					T -= 300;
					aCnt++;
				}
				else if(T >= 60) { // 1분(=60초)보다 클 때 b버튼 누른 횟수 증가해주고 T에서 60 빼줌
					T -= 60;
					bCnt++;
				}
				
				else if(T >= 10) { // 10초보다 클 때 c버튼 누른 횟수 증가해주고 T에서 10 빼줌
					T -= 10;
					cCnt++;
				}
			}
		}
		
		if(isPossible) { // 3개의 버튼으로 맞추는게 가능하면 그 결과 출력
			System.out.println(aCnt + " " + bCnt + " " + cCnt);
		}
		else { // 가능하지 않다면 -1 출력
			System.out.println(-1);
		}
		
	}

}
