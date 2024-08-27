# 2초, 256mb
import sys
input = sys.stdin.readline
from collections import deque

k = int(input())
w, h = map(int, input().split())

graph = []

for _ in range(h):
    graph.append(list(map(int, input().split())))
    
dist = [[1,0], [0,1],[-1,0], [0,-1]] # 사방 이동
horse = [[-2,-1], [-2,1], [-1,-2], [-1,2], [1,-2], [1,2], [2,-1], [2,1]] # 말 이동

def bfs():
    visited = [[[0] * (k+1) for _ in range(w)] for _ in range(h)]
    queue = deque()
    queue.append([0, 0, 0])
    visited[0][0][0] = 1
    
    while queue:
        x, y, z = queue.popleft()
        
        if x == h-1 and y == w-1:
            return visited[x][y][z]-1
        
        for (i, j) in dist:
            dx, dy = x+i, y+j
            
            if 0<=dx<h and 0<=dy<w and not visited[dx][dy][z] and not graph[dx][dy]: # 방해물이 아니고, 방문하지 않았다면
                visited[dx][dy][z] = visited[x][y][z] + 1
                queue.append([dx,dy,z])
               
        if z < k: # 말의 이동 방법으로 이동할 수 있는 경우
            for (hi, hj) in horse:
                hx, hy = x + hi, y + hj
                if 0<=hx<h and 0<=hy<w:
                    if not graph[hx][hy] and not visited[hx][hy][z+1]:
                        visited[hx][hy][z+1] = visited[x][y][z] + 1
                        queue.append([hx, hy, z+1])
    
    return -1             

print(bfs()) 