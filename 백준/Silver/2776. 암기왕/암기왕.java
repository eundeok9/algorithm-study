import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		for(int tc=0; tc<test_case; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int[] memo = new int[N+1];
			for(int i=0; i<N; i++) {
				memo[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(memo);
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for(int i=0; i<M; i++) {
				int left = 0, right = N, val = Integer.parseInt(st.nextToken());
				boolean isIn = false;
				
				while(left<=right) {
					int mid = (left+right)/2;
					
					if(memo[mid] == val) {
						isIn = true;
						break;
					} else if(memo[mid] < val) {
						left = mid +1;
					} else {
						right = mid - 1;
					}
				}
				sb.append(isIn? 1: 0).append("\n");
			}
		}

		
		System.out.println(sb);

	}

}

