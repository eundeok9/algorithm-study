# 1초(파이썬 2초) 1024mb

from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
campus = []
start = []

for i in range(n):
    row = list(input().rstrip())
    
    for j in range(m):
        if row[j] == 'I':
            start = [i, j]
    campus.append(row)


#BFS
direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]
visited = [[False] * m for _ in range(n)]
cnt = 0

queue = deque([start])
visited[start[0]][start[1]] = True # 시작 지점 방문 처리

while(queue):
    x, y = queue.popleft()
    
    for dx, dy in direction:
        nx, ny = x + dx, y + dy
        
        # 캠퍼스 범위 벗어나는지 체크
        if 0 <= nx < n and 0 <= ny < m:
            # 벽이 아니고, 방문하지 않은 곳인지 체크
            if campus[nx][ny] != 'X' and not visited[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True
                
                # 사람이 있다면 만난 사람 1 증가
                if campus[nx][ny] == 'P':
                    cnt += 1
    
print(cnt if cnt > 0 else 'TT')