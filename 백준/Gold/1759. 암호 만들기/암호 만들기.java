import java.util.*;
import java.io.*;

public class Main {

	static int L, C;
	static char[] alpha;
	static boolean[] isSelected;
	static char[] selectedAlpha; 
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		alpha = new char[C];
		for(int i=0; i<C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha); // 입력 받은 알파벳 오름차순 정렬
		
		isSelected = new boolean[C];
		selectedAlpha = new char[L];
		combi(0, 0);
		System.out.println(sb);
		
	}

	// C개의 문자 중 L개를 조합으로 뽑기
	private static void combi(int cnt, int init) {
		if(L == cnt) {
			makePassword();
			return;
		}
		for(int i=init; i<C; i++) {
//			if(isSelected[i] == true) {
//				continue;
//			}
			selectedAlpha[cnt] = alpha[i];
//			isSelected[i] = true;
			combi(cnt+1, i+1);
//			isSelected[i] = false;
		}
	}
	
	// 자음이 2개 이상, 모음이 1개 이상인 경우 비밀번호를 만들어 저장
	private static void makePassword() {
		int jaeum = 0;
		int moeum = 0;
		for(int i=0; i<L; i++) {
			if(selectedAlpha[i] == 'a' ||selectedAlpha[i] == 'e' || selectedAlpha[i] == 'i'
					|| selectedAlpha[i] == 'o' || selectedAlpha[i] == 'u') {
				moeum++;
			}
			else {
				jaeum++;
			}
		}
		if(moeum >= 1 && jaeum >= 2) {
			for(int i=0; i<L; i++) {
				sb.append(selectedAlpha[i]);
			}
			sb.append("\n");
		}
	}
	
}
