import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] paper = new int[100][100];
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());
			
			for(int r = left; r < left+10; r++) {
				for(int c = bottom; c < bottom+10; c++) {
					paper[r][c] += 1;
				}
			}
		}
		
		int size = 100 * n;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j] > 1) {
					size -= paper[i][j] -1;
				}
			}
		}
		System.out.println(size);
		
		
	}

}
