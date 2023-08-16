import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] map;
	static int sum;
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		sum = 0;
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j) - '0'; // 이렇게 하면 공백 없이 들어온 숫자를 파싱할 수 있다!
				sum += map[i][j];
			}
		}
		if(sum==0) {
			System.out.println(0);
		} else if (sum == N*N) {
			System.out.println(1);
		} else {
			sb.append("(");
			sol(0, 0, N/2);
			sol(0, N/2, N/2);
			sol(N/2, 0, N/2);
			sol(N/2, N/2, N/2);
			sb.append(")");
		}
		
		System.out.println(sb);
	}
	
	private static void sol(int r, int c, int size) {
		sum = 0;
		for(int i=r; i<size+r; i++) {
			for(int j=c; j<size+c; j++) {
				sum += map[i][j];
			}
		}
		
		if(sum ==0) {
			sb.append(0);
			return;
		} else if(sum==size*size) {
			sb.append(1);
			return;
		} else {
			int newSize = size/2;
			sb.append("(");
			sol(r, c, newSize);
			sol(r, c+newSize, newSize);
			sol(r+newSize, c, newSize);
			sol(r+newSize, c+newSize, newSize);
			sb.append(")");
		}
		
	}

}
