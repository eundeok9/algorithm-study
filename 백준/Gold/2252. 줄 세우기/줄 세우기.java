import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] inDegree = new int[N+1]; // 진입 차수 배열
		// 인접 리스트
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to); // 인접 리스트 값 저장
			inDegree[to]++; // 진입 차수 값 저장
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입 차수가 0 인 값 큐에 넣기
		for(int i=1; i<inDegree.length; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			
			sb.append(next + " ");
			
			List<Integer> list = graph.get(next);
			
			for(int i=0; i < list.size(); i++) {
				int temp = list.get(i); // 해당 학생 뒤에 서야하는 학생 정보
				inDegree[temp]--; // 진입 차수 감소
				if(inDegree[temp] == 0) {
					queue.offer(temp);
				}		
			}
		}
		
		System.out.println(sb);
	}

}
