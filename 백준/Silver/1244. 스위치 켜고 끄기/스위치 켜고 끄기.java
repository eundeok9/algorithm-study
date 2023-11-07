
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// 주석을 달자!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); // 스위치 개수
		String[] switchStr = br.readLine().split(" "); // 스위치 상태 입력 받고 공백을 기준으로 나눠서 배열에 저장
		int[] switches = new int[num+1]; // 스위치 상태를 저장할 정수 배열
		for(int i=1; i<=num; i++) {
			switches[i] = Integer.parseInt(switchStr[i-1]); // 스위치 상태 저장
		}
		
		// 학생 성별: 남자면 1, 여자면 2
		int students = Integer.parseInt(br.readLine()); // 학생 수
		for(int i=0; i<students; i++) {
			String[] studentStr = br.readLine().split(" "); // 학생에 대한 정보 입력 받고 공백을 기준으로 나눠서 저장
			
			// 남학생인 경우
			if(studentStr[0].equals("1")) {
				int switchNumber = Integer.parseInt(studentStr[1]); // 학생이 받은 번호
				for(int j=1; j<=num; j++) {
					if(j % switchNumber == 0) { // 스위치의 번호가 학생이 받은 번호의 배수인 경우, 배수에 해당하는 스위치 상태 변경
						if(switches[j] == 1) { // 1이면 0으로
							switches[j] = 0;
						} 
						else if(switches[j] == 0) { // 0이면 1로
							switches[j] = 1;
						}
					}
				}
			}
			
			// 여학생인 경우
			int[] dx = {-1, 1};
			if(studentStr[0].equals("2")) {
				int switchNumber = Integer.parseInt(studentStr[1]); // 학생이 받은 번호
				int count = 1;
				int leftIdx = -1; // 대칭 구간의 왼쪽 index
				int rightIdx = -1; // 대칭 구간의 오른쪽 index
				
				// 대칭인 구간 찾기, 대칭이 아니면 index 정보 저장하고 loop 탈출
				while(true) {
					leftIdx = switchNumber + (dx[0] * count);
					rightIdx = switchNumber + (dx[1] * count);
					
					if(leftIdx < 1 || rightIdx > num) {
						leftIdx -= dx[0];
						rightIdx -= dx[1];
						break;
					}
					
					int left = switches[leftIdx];
					int right = switches[rightIdx];
					
					if(left != right) {
						leftIdx -= dx[0];
						rightIdx -= dx[1];
						break;
					}

					count += 1;
				}
				
				// 대칭인 구간의 스위치 상태 변경하기
				for(int k=leftIdx; k<=rightIdx;k++) {
					if(switches[k] == 1) {
						switches[k] = 0;
					}
					else if(switches[k] == 0) {
						switches[k] = 1;
					}
				}
			}
			
		}
		for(int idx = 1; idx <= num; idx++) {
			System.out.print(switches[idx] + " ");
			if(idx % 20 == 0) {
				System.out.println();
			}
		}

	}

}
