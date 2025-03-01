import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int floor = (N % H == 0) ? H : N % H; // 층 번호
            int room = (N + H - 1) / H; // 호수 번호

            System.out.printf("%d%02d\n", floor, room);
        }
    }
}