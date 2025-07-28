import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int from, to, weight;
        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(a, b, w));
            graph.get(b).add(new Node(b, a, w));
        }

        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 1, 0)); // 시작 정점 1
        int total = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.to]) continue;
            visited[cur.to] = true;
            total += cur.weight;

            for(Node nxt: graph.get(cur.to)) {
                if(!visited[nxt.to]) {
                    pq.offer(nxt);
                }
            }
        }

        System.out.println(total);
    }
}