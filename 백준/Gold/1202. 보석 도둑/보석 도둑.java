import java.io.*;
import java.util.*;
public class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;
        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight; // 무게 오름차순 정렬
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }

        int[] bags = new int[K];
        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels); // 무게 오름차순
        Arrays.sort(bags); // 가방 무게 오름차순

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long total = 0;
        int j = 0;
        for(int i=0; i<K; i++) {
            int capacity = bags[i];

            // 현재 가방에 들어갈 수 있는 모든 보석을 pq에 담기
            while(j<N && jewels[j].weight <= capacity) {
                pq.offer(jewels[j].value);
                j++;
            }

            // 가장 가치 있는 보석 담기
            if(!pq.isEmpty()) {
                total += pq.poll();
            }
        }
        System.out.println(total);
    }
}
