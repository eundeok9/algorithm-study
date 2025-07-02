import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 차량과 순서 기록
        HashMap<String, Integer> record = new HashMap<>();
        for(int i=0; i<N; i++) {
            record.put(br.readLine(), i);
        }

        int pass = 0;
        for(int i=0; i<N; i++) {
            String outCar = br.readLine();

            for(String inCar: record.keySet()) {
                if(record.get(inCar) < record.get(outCar)) {
                    pass++;
                    break;
                }
            }

            record.remove(outCar);
        }

        System.out.println(pass);
    }
}