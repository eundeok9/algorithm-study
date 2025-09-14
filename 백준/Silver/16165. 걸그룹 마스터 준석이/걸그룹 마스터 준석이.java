import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Set<String>> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            String groupName = br.readLine();
            int size = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet<>();
            for(int j=0; j<size; j++) {
                String memberName = br.readLine();
                set.add(memberName);
                map.put(groupName, set);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String problem = br.readLine();
            int problemType = Integer.parseInt(br.readLine());

            if(problemType == 0) {
                // 팀이름에 속하는 멤버 이름
                List<String> list = new ArrayList<>(map.get(problem));
                Collections.sort(list);
                for(String name: list) {
                    sb.append(name).append("\n");
                }
            } else {
                // 멤버가 어떤 그룹에 속하는지
                List<String> list = new ArrayList<>(map.keySet());
                for(String group: list) {
                    if(map.get(group).contains(problem)) {
                        sb.append(group).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}