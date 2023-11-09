# 오셀로 게임 파이썬 4초 ㄷㄷ

test_case = int(input())

def playGame(r, c, color):
    # 1. 내 8방 n칸 거리에 나와 같은 색의 돌이 있는지 확인
    # 2. 있다면, 그 방향의 1칸 거리에 나와 다른 색의 돌이 있는지 확인
    # 3. 다른 색의 돌이 있다면 내 돌 색으로 바꾸자

    for d in range(8):
        nr, nc = r, c
        while True:
            nr += dx[d]
            nc += dy[d]
            if 0 > nr or nr >= n or 0 > nc or nc >= n or board[nr][nc] == 0:
                break

            if board[nr][nc] == color:
                # 그 방향의 n-1칸 거리에 나와 다른 색의 돌이 있는지 확인
                while (nr, nc) != (r, c):
                    nr -= dx[d]
                    nc -= dy[d]
                    board[nr][nc] = color
                break # 같은 색 돌 찾았으면 이제 그 방향에서 찾는건 끝


dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

for tc in range(1, test_case +1):
    # n: 보드 한 변의 길이
    # m: 돌을 놓는 횟수
    n, m = map(int, input().split())

    board = [[0 for _ in range(n)] for _ in range(n)]

    board[n//2 - 1][n//2 -1] = 2
    board[n//2 - 1][n//2] = 1
    board[n//2][n // 2 - 1] = 1
    board[n//2][n // 2] = 2

    # for row in board:
    #     print(row)
    # 1이면 흑돌, 2면 백돌
    for _ in range(m):
        r, c, color = map(int, input().split())
        # index 1씩 줄여주자.. n+1로 만들기 귀찮으니까..
        r -= 1
        c -= 1
        board[r][c] = color
        playGame(r, c, color)
        # print(r, c, "에 ", color, "돌 놓음")
        # for row in board:
        #     print(row)
        # print("----------")


    black, white = 0, 0
    for r in range(n):
        for c in range(n):
            if board[r][c] == 1:
                black += 1
            elif board[r][c] == 2:
                white += 1

    print("#{} {} {}".format(tc, black, white))