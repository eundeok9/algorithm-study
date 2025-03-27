import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalCredit = 0; // 총 이수 학점
        double totalGrade = 0; // 성적 총합
        for(int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            switch(grade) {
                case "A+":
                    totalGrade += credit * 4.5;
                    break;
                case "A0":
                    totalGrade += credit * 4.0;
                    break;
                case "B+":
                    totalGrade += credit * 3.5;
                    break;
                case "B0":
                    totalGrade += credit * 3.0;
                    break;
                case "C+":
                    totalGrade += credit * 2.5;
                    break;
                case "C0":
                    totalGrade += credit * 2.0;
                    break;
                case "D+":
                    totalGrade += credit * 1.5;
                    break;
                case "D0":
                    totalGrade += credit;
                    break;
                case "F":
                    totalGrade += 0;
                    break;
                case "P":
                    break;
            }

            if(grade.equals("P")) continue;
            totalCredit += credit;
        }

        System.out.printf("%.6f\n", totalGrade / totalCredit);
    }
}