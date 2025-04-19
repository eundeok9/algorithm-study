import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        for(int t=1; t<=K; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 놀러온 친구 수
            int C = Integer.parseInt(st.nextToken()); // 자동차 수
            int L = Integer.parseInt(st.nextToken()); // 지역 수

            int[][] people = new int[L+1][2];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String state = st.nextToken();
                if(state.equals("I")) people[num][0]++;
                else people[num][1]++;
            }

            ArrayList<Integer>[] cars = new ArrayList[L+1];
            for (int i = 1; i <= L; i++) cars[i] = new ArrayList<>();

            for (int i = 0; i < C; i++) {
                st = new StringTokenizer(br.readLine());
                int region = Integer.parseInt(st.nextToken());
                int seats = Integer.parseInt(st.nextToken());
                cars[region].add(seats);
            }

            int totalUsed = 0;
            for (int i = 1; i <= L; i++) {
                List<Integer> seatList = cars[i];
                Collections.sort(seatList, Collections.reverseOrder());
                int drunk = people[i][0];
                int notDrunk = people[i][1];

                for(int cap: seatList) {
                    if(notDrunk==0) break;
                    notDrunk--;
                    totalUsed++;
                    int seats = cap - 1;

                    int useI = Math.min(seats, drunk);
                    drunk -= useI;
                    seats -= useI;
                    totalUsed += useI;

                    int useS = Math.min(seats, notDrunk);
                    notDrunk -= useS;
                    totalUsed += useS;
                }
            }

            System.out.println("Data Set " + t + ":");
            System.out.println(N - totalUsed);
        }
    }
}