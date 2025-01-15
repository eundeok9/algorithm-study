import java.io.*;
import java.util.*;
public class Main {
    public static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }
    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.putIfAbsent(parent, new Node(parent));
            Node parentNode = tree.get(parent);

            if(left != '.') {
                parentNode.left = new Node(left);
                tree.put(left, parentNode.left);
            }
            if(right != '.') {
                parentNode.right = new Node(right);
                tree.put(right, parentNode.right);
            }
        }

        preOrder(tree.get('A'), sb);
        sb.append("\n");
        inOrder(tree.get('A'), sb);
        sb.append("\n");
        postOrder(tree.get('A'), sb);
        System.out.println(sb);
    }

    static void preOrder(Node node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.value); // 루트
        preOrder(node.left, sb); // 왼쪽
        preOrder(node.right, sb); // 오른쪽
    }

    static void inOrder(Node node, StringBuilder sb) {
        if(node == null) return;
        inOrder(node.left, sb); // 왼쪽
        sb.append(node.value); // 루트
        inOrder(node.right, sb); // 오른쪽
    }

    static void postOrder(Node node, StringBuilder sb) {
        if(node == null) return;
        postOrder(node.left, sb); // 왼쪽
        postOrder(node.right, sb); // 오른쪽
        sb.append(node.value); // 루트
    }
}
