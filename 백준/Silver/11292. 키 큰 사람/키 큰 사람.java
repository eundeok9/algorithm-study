import java.util.*;
import java.io.*;
public class Main {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true){
			int n = Integer.parseInt(br.readLine());

			if(n==0) break;

			ArrayList<String> al = new ArrayList<>();
			double maxHeight = 0.0;

			for(int i=0;i<n;i++){
				StringTokenizer st = new StringTokenizer(br.readLine());

				String name = st.nextToken();
				double height = Double.parseDouble(st.nextToken());

				if(height>maxHeight){
					maxHeight=height;
					al.clear();
					al.add(name);
				}else if(height==maxHeight){
					al.add(name);
				}
			}

			for(String name: al){
				sb.append(name).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}