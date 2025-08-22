import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Node> tree = new HashMap<>();
    static class Node {
        char value;
        Node left;
        Node right;
        Node(char value) {
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

        preOrder(tree.get('A'));
        sb.append("\n");
        inOrder(tree.get('A'));
        sb.append("\n");
        postOrder(tree.get('A'));
        System.out.println(sb);
    }

    static void preOrder(Node node) {
        if(node == null) return;
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}
