# 1초, 128mb
import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())
graph = []
visited = [[False] * m for _ in range(n)]
ans = [[-1] * m for _ in range(n)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(n):
    graph.append(list(map(int, input().split())))

def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    
    visited[i][j] == True
    ans[i][j] = 0
    
    while queue:
        x, y = queue.popleft()
        
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                if graph[nx][ny] == 1:
                    visited[nx][ny] = True
                    ans[nx][ny] = ans[x][y] + 1
                    queue.append((nx, ny))
                elif graph[nx][ny] == 0:
                    visited[nx][ny] = True
                    ans[nx][ny] = 0
    
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2 and visited[i][j] == False:
            bfs(i, j)

        
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            print(0, end =' ')
        else:
            print(ans[i][j], end=' ')
    print()