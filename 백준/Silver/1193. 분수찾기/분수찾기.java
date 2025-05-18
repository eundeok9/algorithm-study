import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int num = 0;

        if(x==1) {
            System.out.println("1/1");
        } else if(x==2) {
            System.out.println("1/2");
        }

        for(int i=1; i<x; i++) {
            num += i;

            if(num >= x) {
                num -= i;

                int sequence = x - num;

                if(i%2==0) {
                    System.out.println(sequence+"/"+((i+1)-sequence));
                } else {
                    System.out.println(((i+1)-sequence)+"/"+sequence);
                }
                break;
            }
        }
    }
}