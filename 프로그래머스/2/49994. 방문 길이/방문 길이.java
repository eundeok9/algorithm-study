import java.util.*;
class Solution {
    static class Path {
        int x1, y1, x2, y2;
        Path(int x1, int y1, int x2, int y2) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;
            Path p = (Path) o;
            return (x1 == p.x1 && y1 == p.y1 && x2 == p.x2 && y2 == p.y2)
                || (x1 == p.x2 && y1 == p.y2 && x2 == p.x1 && y2 == p.y1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Math.min(x1, x2), Math.min(y1, y2),
                                Math.max(x1, x2), Math.max(y1, y2));
        }
    }
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public int solution(String dirs) {
        int answer = 1;
        
        char[] dir = dirs.toCharArray();
        HashSet<Path> set = new HashSet<>();
        
        int x = 0, y = 0;
        for (char c : dirs.toCharArray()) {
            int d = getDirection(c);
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            set.add(new Path(x, y, nx, ny));
            x = nx;
            y = ny;
        }
        
        return set.size();
    }
    
    static int getDirection(char dir) {
        switch(dir) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
        }
        
        return 0;
    }
}


// (0, 0)에서 시작
// 처음 걸어본 길의 길이
// 갈 수 없는 곳에 대한 명령어는 무시
