import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        List<Integer> forms = new ArrayList<>(); // 폼 제출한 사람
        List<Integer> deposits = new ArrayList<>(); // 입금했는데 아직 폼 안낸 사람
        Set<Integer> list = new HashSet<>(); // 잊은 사람

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());

            if(type == 0) {
                forms.add(id);
                // 폼 제출한 사람이 입금한 사람이라면 입금햇는데 아직 폼 안낸 사람 리스트에서 제거
                if(deposits.contains(id)) {
                    deposits.remove((Integer)id);
                }
                // 남은 모든 입금자 카운드 + 1, s 이상이면 answer에 추가
                for(int j: deposits) {
                    arr[j-1]++;
                    if(arr[j-1] >= S) list.add(j);
                }
            } else {
                // 아직 폼 제출 안했다면
                if(!forms.contains(id)) {
                    deposits.add(id);
                }
            }

        }

        if(list.isEmpty()) {
            System.out.println(-1);
        } else {
            List<Integer> answer = new ArrayList<>(list);
            Collections.sort(answer);
            StringBuilder sb = new StringBuilder();
            for(int x: answer) {
                sb.append(x).append("\n");
            }
            System.out.println(sb);
        }
    }
}