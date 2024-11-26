class Solution {
    public int[] solution(String[] park, String[] routes) {
        
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
            // 공백을 기준으로 문자열 쪼개기
            String[] s = route.split(" ");
            
            // 이동 방향
            int dir = s[0].equals("N") ? 0 : s[0].equals("W") ? 1 : s[0].equals("S") ? 2 : 3;
            
            // 이동 거리
            int dist = Integer.parseInt(s[1]);
            
            // 이동 가능 여부 체크(공원 벗어남 or 이동 중 장애물 만남)
            boolean possible = true;
            
            int nx = sx;
            int ny = sy;
            for(int i=0; i<dist; i++) {
                nx += dx[dir];
                ny += dy[dir];
                
                // 공원을 벗어나거나 장애물 만나면 중단
                if(!check(map, nx, ny) || map[nx][ny].equals("X")) {
                    possible = false;
                    break;
                }
            }
            
            if(!possible) { // 장애물 만났으면 명령 무시
                continue;
            } else { // 장애물 안만났다면 시작 위치 변경
                sx = nx;
                sy = ny;
            }
            
        }
        
        return new int[] {sx, sy};
    }
    
    static public boolean check(String[][] map, int nx, int ny) {
        return 0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length;
    }
}