import java.io.*;
import java.util.*;
public class Main {
    static class Info implements Comparable<Info> {
        String filename, extension;
        int inSet;

        Info(String filename, String extension, int inSet) {
            this.filename = filename;
            this.extension = extension;
            this.inSet = inSet;
        }

        public int compareTo(Info o) {
            if(this.filename.equals(o.filename)) {
                if(this.inSet == o.inSet) {
                    return this.extension.compareTo(o.extension);
                }
                return Integer.compare(o.inSet, this.inSet);
            }
            return this.filename.compareTo(o.filename);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            list.add(br.readLine());
        }
        for(int i=0; i<M; i++) {
            set.add(br.readLine());
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(list.get(i),".");
            String filename = st.nextToken();
            String extension = st.nextToken();
            int flag = set.contains(extension) ? 1 : 0;
            pq.offer(new Info(filename, extension, flag));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            sb.append(info.filename).append(".").append(info.extension).append("\n");
        }
        System.out.println(sb);
    }
}
