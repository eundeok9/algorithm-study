import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 1;
        int range = 2;

        if(n==1) {
            System.out.println(1);
        } else {
            // 벌집의 개수가 2 + 6 * n 의 규칙을 가지고 늘어남
            while(range <= n) {
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }
    }
}
