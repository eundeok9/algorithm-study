from collections import deque
import sys
input = sys.stdin.readline

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 익은 토마토: 1
# 익지 않은 토마토: 0
# 토마토 들어있지 않은 칸: -1

# 토마토가 모두 익을 때까지의 최소 날짜 출력
# 모든 토마토가 익어있으면 0 출력
# 모든 토마토가 익지 못하는 상황이면 -1 출력

def bfs():
    while queue:
        x, y = queue.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < m and 0 <= ny < n and box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                queue.append((nx, ny))

n, m = map(int, input().split())

box = []
for _ in range(m):
    box.append(list(map(int,input().split())))

queue = deque()
for i in range(m):
    for j in range(n):
        if box[i][j] == 1:
            queue.append((i, j))

bfs()
result = -99
for row in box:
    for item in row:
        if item == 0:
            print(-1)
            exit(0)
    result = max(result, max(row))

print(result - 1)