import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int M = Integer.parseInt(br.readLine());
            sb.append(M/2+1).append("\n");

            int cnt = 0; // 줄 간격 띄우기

            for(int i=0; i<M; i++) {
                if(i%10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());

                if(maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(x);
                } else {
                    minHeap.offer(x);
                }

                // maxHeap은 중앙값 이하의 숫자만 갖도록 조정
                if(!minHeap.isEmpty()) {
                    if(maxHeap.peek() > minHeap.peek()) {
                        int t1 = maxHeap.poll();
                        int t2 = minHeap.poll();

                        maxHeap.offer(t2);
                        minHeap.offer(t1);
                    }
                }

                // 인덱스가 0부터였으므로 짝수번째일 때마다 중앙값 출력
                if(i%2 == 0) {
                    if(cnt==9 || i==M-1) {
                        sb.append(maxHeap.peek()).append("\n");
                        cnt = 0;
                    } else {
                        sb.append(maxHeap.peek()).append(" ");
                    }
                    cnt++;
                }
            }
        }
        System.out.println(sb);
    }
}