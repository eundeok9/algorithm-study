# 2초, 256mb
import sys
input = sys.stdin.readline

n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]


result = []
def sol(x, y, n):
    color = paper[x][y]
    
    for i in range(x, x+n):
        for j in range(y, y+n):
            if color != paper[i][j]:
                sol(x, y, n//3)
                sol(x+n//3, y, n//3)
                sol(x+2*(n//3), y, n//3)
                sol(x, y+n//3, n//3)
                sol(x, y+2*(n//3), n//3)
                sol(x+n//3, y+n//3, n//3)
                sol(x+2*(n//3), y+n//3, n//3)
                sol(x+n//3, y+2*(n//3), n//3)
                sol(x+2*(n//3), y+2*(n//3), n//3)
                return
    
    if color == -1:
        result.append(-1)
    elif color == 0:
        result.append(0)
    else:
        result.append(1)

sol(0, 0, n)
print(result.count(-1))
print(result.count(0))
print(result.count(1))