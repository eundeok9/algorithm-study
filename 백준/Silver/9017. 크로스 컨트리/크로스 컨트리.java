import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();

            // 각 팀에 몇 명 있는지 count
            st = new StringTokenizer(s);
            HashMap<Integer, Integer> count = new HashMap<>();
            for(int i=0; i<N; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                count.put(teamNum, count.getOrDefault(teamNum, 0) + 1);
            }

            // 팀 별로 점수를 저장하는 map
            int score = 1;
            st = new StringTokenizer(s);
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int i=0; i<N; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                if(count.get(teamNum) < 6) continue; // 6명이 되지 않는 팀은 skip
                ArrayList<Integer> list = map.getOrDefault(teamNum, new ArrayList<>());
                list.add(score++);
                map.put(teamNum, list);
            }

            int answer = 0; // 우승 팀 번호
            int minRecord = Integer.MAX_VALUE; // 우승 팀의 점수
            int fifth = Integer.MAX_VALUE; // 우승 팀의 5번째 선수 점수
            for(Integer num: map.keySet()) {
                if(map.get(num).size() != 6) {
                    continue;
                }
                int sum = 0; // 현재 팀의 점수
                int curFifth = map.get(num).get(4);
                for(int i=0; i<4; i++) {
                    sum += map.get(num).get(i);
                }

                // 현재 팀의 점수가 더 낮을 때
                if(sum < minRecord) {
                    minRecord = sum;
                    fifth = curFifth;
                    answer = num;
                }
                // 현재 팀의 점수와 우승 팀의 점수가 같을 때
                else if(sum == minRecord) {
                    // 우승 팀의 5번째 선수가 현재 팀의 5번째 선수 점수보다 높을 때
                    if(fifth > curFifth) {
                        answer = num;
                        fifth = curFifth;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
