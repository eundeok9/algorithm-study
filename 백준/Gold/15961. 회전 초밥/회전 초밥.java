import java.util.*;
import java.io.*;

public class Main  {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		// 마지막 접시부터 먹으면 그 접시 + 처음 나온 접시부터 k-1개 까지 먹을 수 있으므로 배열 크기는 N+k-1
		int[] sushi = new int[N+k-1];
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<k-1; i++) {
			sushi[N++] = sushi[i];
		}
		
		int[] eat = new int[d+1];
		eat[c] += 1; // 쿠폰 번호로 지급된 스시는 먹었다고 가정
		int max = 1;
		
		// 슬라이딩 윈도우 알고리즘
		int start = 0;
		for(int i = start; i<k; i++) {
			if(eat[sushi[i]] == 0) { // 이미 먹은 번호의 초밥이 아니라면
				max++; // 먹은 개수 추가
			}
			eat[sushi[i]] += 1; // 먹은 초밥이라고 표시
		}
		
		// 윈도우 이동
		// 맨 처음 먹은거 제외하고, 다음 위치거 하나씩 추가해서 먹은 개수 최댓값 찾기
		int end = k;
		int tmpMax = max;
		
		for(int i = end; i < sushi.length; i++) {
			eat[sushi[start]] -= 1; // 맨 처음 먹은거 제외
			
			// 처음 먹은(=제거된) 초밥이 중복으로 먹은게 아니라면, 먹은 개수 감소
			if(eat[sushi[start]] == 0) {
				tmpMax -= 1;
			}
			
			// 현재 먹을 초밥이 먹었던게 아니라면 먹은 개수 추가
			if(eat[sushi[i]]==0) { 
				tmpMax += 1;
			}
			
			// 현재 먹은 초밥 번호 먹은 개수 추가
			eat[sushi[i]] += 1;
			
			// 슬라이딩 윈도우 전, 후 값 비교 => 최댓값 구하기
			max = Math.max(max, tmpMax);
			
			start++; // 시작위치 조정
		}
		
		System.out.println(max);
	}

}
