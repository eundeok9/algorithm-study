import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine()); // 반 수
        List<List<Integer>> scoreList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++) {
            scoreList.add(new ArrayList<>());
            
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++) {
                scoreList.get(i).add(Integer.parseInt(st.nextToken()));
            }
            
            Collections.sort(scoreList.get(i)); // 오름차순 정렬
            
            int maxGap = Integer.MIN_VALUE;
            for(int x=0; x<N-1; x++) {
                maxGap = Math.max(maxGap, Math.abs(scoreList.get(i).get(x) - scoreList.get(i).get(x+1)));
            }
            
            sb.append("Class ").append(i+1).append("\n");
            sb.append("Max ").append(scoreList.get(i).get(N-1)).append(", Min ").append(scoreList.get(i).get(0)).append(", Largest gap ").append(maxGap).append("\n");
        }
        
        System.out.println(sb);
    }
}