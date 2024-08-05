# 1초, 128mb
import sys
input = sys.stdin.readline

from collections import deque

m, n, k = map(int, input().split())

rect = [[0 for _ in range(m)] for _ in range(n)]

# 좌표에 직사각형 표시하기
for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    
    for i in range(x1, x2):
        for j in range(y1, y2):
            rect[i][j] += 1

# m*n 좌표 탐색
ans1 = 0
ans2 = []

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

for i in range(n):
    for j in range(m):
        cnt = 0
        if rect[i][j] == 0:
            rect[i][j] = -1
            cnt += 1
            
            queue = deque()
            queue.append((i, j))
            
            while(queue):
                x, y = queue.popleft()
                
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]
                    
                    if 0 <= nx < n and 0 <= ny < m:
                        if rect[nx][ny] == 0:
                            rect[nx][ny] = -1
                            queue.append((nx, ny))
                            cnt += 1
                            
            ans1 += 1
            ans2.append(cnt)
            
ans2.sort()
print(ans1)
print(*ans2)