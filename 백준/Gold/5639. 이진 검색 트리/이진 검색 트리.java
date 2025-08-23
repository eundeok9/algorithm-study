import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void insert(int n) {
            if(n < this.value) {
                if(this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if(this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전위 순회: root -> 좌 -> 우
        // 후위 순회: 좌 -> 우 -> root
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while(true) {
            input = br.readLine();
            if(input == null || input.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);

        System.out.println(sb);
    }

    static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append("\n");
    }
}
