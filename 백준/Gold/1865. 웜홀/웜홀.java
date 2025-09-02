import java.io.*;
import java.util.*;
public class Main {
    static class Road {
        int end;
        int weight;

        Road(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static int N, M, W;
    static int[] dist;
    static List<List<Road>> graph;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<M+W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if(i < M) {
                    graph.get(start).add(new Road(end, weight));
                    graph.get(end).add(new Road(start, weight));
                } else {
                    graph.get(start).add(new Road(end, -weight));
                }
            }

            boolean isCycle = false;
            dist = new int[N+1];
            for(int i=1; i<=N; i++) {
                // 모든 노드에 대해 음수사이클 발생하는지 확인
                if (bellmanFord(i)) {
                    isCycle = true;
                    break;
                }
            }

            if(!isCycle) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
    }

    static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean updated = false;

        // N-1번 반복
        for(int i=1; i<N; i++) {
            updated = false;

            for(int j=1; j<=N; j++) {
                if(dist[j] == INF) continue;

                for(Road road: graph.get(j)) {
                    if(dist[j] + road.weight < dist[road.end]) {
                        dist[road.end] = dist[j] + road.weight;
                        updated = true;
                    }
                }
            }

            // 최단거리 초기화가 일어나지 않았을 경우 반복문 종료
            if(!updated) {
                break;
            }
        }

        // 음수 사이클 확인
        if(updated) {
            for(int i=1; i<=N; i++) {
                for(Road road: graph.get(i)) {
                    if(dist[i] != INF && dist[road.end] > dist[i] +road.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}