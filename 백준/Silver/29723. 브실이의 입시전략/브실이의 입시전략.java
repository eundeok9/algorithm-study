import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        for(int i=0; i<K; i++) {
            String subject = br.readLine();
            sum += map.get(subject);
            map.remove(subject);
        }

        List<Integer> scoreList = new ArrayList<>(map.values());
        Collections.sort(scoreList);

        int min = 0;
        int max = 0;
        for(int i=0; i<M-K; i++) {
            min += scoreList.get(i);
            max += scoreList.get(scoreList.size() - 1 - i);
        }

        System.out.println((sum + min) + " " + (sum + max));
    }
}