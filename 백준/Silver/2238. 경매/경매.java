import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int U = Integer.parseInt(st.nextToken()); // 금액의 상한
        int N = Integer.parseInt(st.nextToken()); // 경매 참여 횟수

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            if(!map.containsKey(price)) {
                map.put(price, new ArrayList<>());
            }
            ArrayList<String> list = map.get(price);
            list.add(name);
            map.replace(price, list);
        }

        ArrayList<Integer> key = new ArrayList<>(map.keySet());
        key.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1).size() == map.get(o2).size()) {
                    return o1 - o2;
                }
                return map.get(o1).size() - map.get(o2).size();
            }
        });

        System.out.println(map.get(key.get(0)).get(0) + " " + key.get(0));
    }
}
