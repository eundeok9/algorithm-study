import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{

	static int line, start;
	static ArrayList<Integer>[] graph;
	static int[] isVisited;
//	static ArrayList<Integer> answer;
	static Queue<Integer> queue;
	static int max;
	static int answer;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			line = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			
			graph = new ArrayList[101];
			
			// graph 리스트 초기화
			for(int i=0; i<101; i++) {
				graph[i] = new ArrayList<>();
			}
			
			// {from, to} 그래프에 저장
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<line/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}
			
			
			bfs(start);
			findMax(tc);
			
		}
		System.out.println(sb);


	}
	
	// 가까운 이웃부터 탐색, 방문했을 때 방문 순서를 isVisited에 저장
	static void bfs(int start) {
		queue = new ArrayDeque<>();
		isVisited = new int[101];
		
		queue.offer(start);
		isVisited[start] = 1;
		
		while(!queue.isEmpty()) {
			
			int node = queue.poll();
			
			for(int i=0; i < graph[node].size(); i++) {
				
				int next = graph[node].get(i);
				if(isVisited[next] == 0) {
					queue.offer(next);
					isVisited[next] = isVisited[node] + 1; // 방문 여부 저장
				}
			}
		}
	}
	
	static void findMax(int tc) {
		max = 0;
		answer = 0;
		
		for(int i=0; i < isVisited.length; i++) {
			if(isVisited[i] >= max) {
				max = isVisited[i]; // 가장 깊은 depth
//				answer = answer < i ? i : answer;
				answer = i; // 그때의 i(= 이웃의 번호)가 답이 됨
			}
		}
		sb.append("#" + tc + " " + answer + "\n");
	}

}
