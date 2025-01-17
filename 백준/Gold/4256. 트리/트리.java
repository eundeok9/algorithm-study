import java.io.*;
import java.util.*;
public class Main {
    static int[] preOrder, inOrder, postOrder;
    static int[] indexMap;
    static int postIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());

            postIdx = N-1;
            preOrder = new int[N];
            inOrder = new int[N];
            postOrder = new int[N];
            indexMap = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                preOrder[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
                indexMap[inOrder[i]] = i;
            }

            StringBuilder sb = new StringBuilder();
            recur(0, N-1, 0, N-1);
            for(int i=0; i<N; i++) {
                sb.append(postOrder[i]).append(" ");
            }
            System.out.println(sb);
        }

    }
    public static void recur(int inStart, int inEnd, int preStart, int preEnd) {
        if(inStart > inEnd || preStart > preEnd) {
            return;
        }

        int root = preOrder[preStart];
        postOrder[postIdx--] = root;

        int rootIdx = indexMap[root];
        int leftSize = rootIdx - inStart;

        // 오른쪽 서브트리 탐색
        recur(rootIdx + 1, inEnd,preStart + leftSize + 1, preEnd);

        // 왼쪽 서브트리 탐색
        recur(inStart, rootIdx - 1, preStart + 1, preStart + leftSize);
    }
}