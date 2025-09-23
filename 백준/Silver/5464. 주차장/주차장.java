import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] fee = new int[N+1];
        for(int i=1; i<=N; i++) {
            fee[i] = Integer.parseInt(br.readLine());
        }

        int[] weight = new int[M+1];
        for(int i=1; i<=M; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        int[] parkingLot = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        for(int i=0; i<2*M; i++) {
            int cur = Integer.parseInt(br.readLine());

            if(cur > 0) {
                boolean parked = false;
                for(int j=1; j<=N; j++) {
                    if(parkingLot[j] == 0) {
                        parkingLot[j] = cur;
                        parked = true;
                        break;
                    }
                }
                if(!parked) queue.offer(cur);
            } else {
                for(int j=1; j<=N; j++) {
                    if(parkingLot[j] == -cur) {
                        answer += fee[j] * weight[-cur];
                        parkingLot[j] = 0;

                        if(!queue.isEmpty()) {
                            parkingLot[j] = queue.poll();
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}