import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        HashMap<String, Node> childs = new HashMap<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Node root = new Node();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            Node cur = root;
            for(int j=0; j<k; j++) {
                String s = st.nextToken();

                if(!cur.childs.containsKey(s)) {
                    cur.childs.put(s, new Node());
                }
                cur = cur.childs.get(s);
            }
        }

        print(root, 0);
    }

    static void print(Node node, int depth) {
        List<String> keys = new ArrayList<>(node.childs.keySet());
        Collections.sort(keys);

        for(String key: keys) {
            System.out.println("--".repeat(depth) + key);
            print(node.childs.get(key), depth + 1);
        }
    }
}