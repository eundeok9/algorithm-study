import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(x);
            } else {
                minHeap.offer(x);
            }

            if (!minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int t1 = maxHeap.poll();
                    int t2 = minHeap.poll();
                    maxHeap.offer(t2);
                    minHeap.offer(t1);
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
