class Solution {
    static boolean isOWin = false;
    static boolean isXWin = false;
    static int oCount = 0;
    static int xCount = 0;
    public int solution(String[] board) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i].charAt(j) == 'O') oCount++;
                else if(board[i].charAt(j) == 'X') xCount++;
            }
        }
        
        if (!(oCount == xCount || oCount == xCount + 1)) return 0;
        
        // 승리 여부 체크
        isOWin = checkWin(board, 'O');
        isXWin = checkWin(board, 'X');

        // 둘 다 이길 수 없음
        if (isOWin && isXWin) return 0;

        // O가 이겼으면 O가 하나 더 많아야 함
        if (isOWin && oCount != xCount + 1) return 0;

        // X가 이겼으면 개수 같아야 함
        if (isXWin && oCount != xCount) return 0;

        return 1;
    }
    
    // 누가 이겼는지 판별
    static boolean checkWin(String[] board, char c) {

        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c &&
                board[i].charAt(1) == c &&
                board[i].charAt(2) == c)
                return true;
        }

        // 세로
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == c &&
                board[1].charAt(j) == c &&
                board[2].charAt(j) == c)
                return true;
        }

        // 대각선
        if (board[0].charAt(0) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(2) == c)
            return true;

        if (board[0].charAt(2) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(0) == c)
            return true;

        return false;
    }
}