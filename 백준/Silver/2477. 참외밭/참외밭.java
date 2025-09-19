import java.io.*;
import java.util.*;
public class Main {
    static int[] length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        length = new int[6];
        int maxHeight = -1;
        int maxWidth = -1;
        int maxHeightIdx = -1;
        int maxWidthIdx = -1;
        for(int i=0; i<6; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
            if(direction == 1 || direction == 2) {
                if(maxWidth < length[i]) {
                    maxWidth = length[i];
                    maxWidthIdx = i;
                }
            } else {
                if(maxHeight < length[i]) {
                    maxHeight = length[i];
                    maxHeightIdx = i;
                }
            }
        }

        int smallHeight = calcLength(maxHeightIdx);
        int smallWidth = calcLength(maxWidthIdx);

        int size = (maxWidth * maxHeight) - (smallHeight * smallWidth);

        System.out.println(size * K);
    }

    static int calcLength(int index) {
        int result = 0;

        if(index == 0) {
            result = Math.abs(length[index+1] - length[5]);
        } else if(index == 5) {
            result = Math.abs(length[index-1] - length[0]);
        } else {
            result = Math.abs(length[index+1] - length[index-1]);
        }

        return result;
    }
}