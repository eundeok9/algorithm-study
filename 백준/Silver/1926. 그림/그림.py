import sys
input = sys.stdin.readline
from collections import deque

def bfs(x, y):
    cnt = 1
    queue = deque()
    queue.append((x, y))
    paper[x][y] = -1 # 방문 처리

    while queue:

        x, y = queue.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 > nx or nx >= n or 0 > ny or ny >= m:
                continue
            if paper[nx][ny] == 1:
                queue.append((nx, ny))
                paper[nx][ny] = -1
                cnt += 1

    return cnt


# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

n, m = list(map(int, input().split()))
paper = []
for _ in range(n):
    paper.append(list(map(int, input().split())))

figure = []
for i in range(n):
    for j in range(m):
        if paper[i][j] == 1:
            figure.append(bfs(i, j))

if len(figure) == 0:
    print(0)
    print(0)

else:
    print(len(figure))
    print(max(figure))
