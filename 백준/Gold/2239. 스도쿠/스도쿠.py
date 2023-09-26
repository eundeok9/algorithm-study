import sys
input = sys.stdin.readline

sudoku = []
blank = []

def checkRow(x, i): # x열에 i가 있는지 확인
    for n in range(9):
        if sudoku[x][n] == i:
            return False
    return True

def checkCol(y, i): # y열에 i가 있는지 확인
    for n in range(9):
        if sudoku[n][y] == i:
            return False
    return True

def checkRect(x, y, i): # x, y가 속해있는 3x3 정사각형 영역에 i가 있는지 확인
    # (2, 3) 이라면... 왼 꼭짓점이 (0,3)인 정사각형 안에 있는 좌표
    startX = x // 3 * 3
    startY = y // 3 * 3
    for n in range(startX, startX+3):
        for m in range(startY, startY+3):
            if sudoku[n][m] == i:
                return False
    return True

def sol(n):
    if n == len(blank):
        for _ in range(9):
            print(*sudoku[_], sep="")
        exit(0)

    for i in range(1, 10):
        x = blank[n][0] # 빈칸의 x 좌표
        y = blank[n][1] # 빈칸의 y 좌표

        if checkRow(x, i) and checkCol(y, i) and checkRect(x, y, i):
            sudoku[x][y] = i
            sol(n+1)
            sudoku[x][y] = 0

for i in range(9):
    sudoku.append(list(map(int, input().rstrip())))
    for j in range(9):
        if sudoku[i][j] == 0:
            blank.append([i,j]) # 빈칸 좌표 저장


sol(0)