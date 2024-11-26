class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // park를 2차원 배열로 저장
        String[][] map = new String[park.length][park[0].length()];
        int sx = -1;
        int sy = -1;
        for(int i=0; i<park.length; i++) {
            String s = park[i];
            for(int j=0; j<s.length(); j++) {
                map[i][j] = String.valueOf(s.charAt(j));
                
                // 시작 위치 찾기
                if(s.charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        // N, W, S, E
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for(String route: routes) {
            String[] s = route.split(" ");
            int dir = s[0].equals("N") ? 0 : s[0].equals("W") ? 1 : s[0].equals("S") ? 2 : 3;
            int dist = Integer.parseInt(s[1]);
            boolean possible = true;
            
            int nx = sx;
            int ny = sy;
            for(int i=0; i<dist; i++) {
                nx += dx[dir];
                ny += dy[dir];
                if(!check(map, nx, ny) || map[nx][ny].equals("X")) {
                    possible = false;
                    break;
                }
            }
            
            if(!possible) {
                continue;
            } else {
                sx = nx;
                sy = ny;
            }
            
        }
        
        answer[0] = sx;
        answer[1] = sy;
        
        return answer;
    }
    
    static public boolean check(String[][] map, int nx, int ny) {
        return 0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length;
    }
}