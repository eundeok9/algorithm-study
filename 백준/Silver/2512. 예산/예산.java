import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
           int N = Integer.parseInt(br.readLine());
           
           int left = 0;
           int right = -1;
           int[] arr = new int[N];
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int i=0; i<N; i++) {
               arr[i] = Integer.parseInt(st.nextToken());
               right = Math.max(right, arr[i]);
           }
           
           int m = Integer.parseInt(br.readLine());
           while(left <= right) {
               int mid = (left+right) / 2;
               long money = 0;
               for(int i=0; i<N; i++) {
                   if(arr[i] > mid) money += mid;
                   else money += arr[i];
               }
               if(money <= m) {
                   left = mid + 1;
               } else {
                   right = mid -  1;
               }
           }
           System.out.println(right);
    }
}
