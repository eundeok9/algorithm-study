from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 섬 번호 정하기
def bfs(x, y):
    global islandNum
    queue = deque()
    queue.append([x, y])
    graph[x][y] = islandNum
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                graph[nx][ny] = islandNum
                queue.append([nx, ny])

# 다리 연결
def makeBridge(num):
    global answer

    queue = deque()

    dist = [[-1 for _ in range(n)] for _ in range(n)]

    # 현재 섬 번호를 갖고 있는 곳의 좌표 queue에 넣기
    for i in range(n):
        for j in range(n):
            if graph[i][j] == num:
                queue.append([i, j])
                dist[i][j] = 0 # 섬의 위치는 시작점이 될 것이므로 거리를 0으로 저장

    while queue:
        x, y = queue.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if not(0 <= nx < n and 0 <= ny <n):
                continue

            if graph[nx][ny] == 0 and dist[nx][ny] == -1: # 바다를 만났을 때
                dist[nx][ny] = dist[x][y] + 1
                queue.append([nx, ny])

            if graph[nx][ny] != num and graph[nx][ny] != 0: # 섬을 만났을 때
                answer = min(answer, dist[x][y])
                return


n = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]

islandNum = 1
visited = [[False for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and not visited[i][j]:
            bfs(i,j)
            islandNum += 1


answer = 1e9
for num in range(1, islandNum):
    makeBridge(num)

print(answer)