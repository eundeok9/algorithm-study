class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i!=j && computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(parent[i] == i) answer++;
        }
        
        return answer;
    }
    
    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if(pa != pb) {
            parent[pb] = pa;
        }
    }
    
    public static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}