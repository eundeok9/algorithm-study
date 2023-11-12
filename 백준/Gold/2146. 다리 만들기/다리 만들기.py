# 백준 2146. 다리 만들기
# 시간 제한 2초 / 메모리 제한 192MB

from collections import deque
import sys
input = sys.stdin.readline

def findIsland(i, j):
    global islandNum

    queue = deque()
    queue.append((i, j))

    visited[i][j] = True # 방문 처리
    graph[i][j] = islandNum # 섬 번호 입력

    while queue:
        x, y = queue.popleft()

        for d in range(4): # 사방 탐색
            nx = x + dx[d]
            ny = y + dy[d]

            # 1. 범위 내에 들어어고
            # 2. 섬이고
            # 3. 방문 처리 하지 않은 곳이라면
            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True # 방문 처리
                graph[nx][ny] = islandNum # 섬 번호 입력
                queue.append((nx, ny)) # 주변 탐색 하기 위해 큐에 넣기

def makeBridge(num):
    global answer
    dist = [[-1 for _ in range(n)] for _ in range(n)] # 거리 저장할 배열
    queue = deque()

    # 번호가 num인 섬 찾기
    for i in range(n):
        for j in range(n):
            if graph[i][j] == num:
                queue.append((i, j))
                dist[i][j] = 0


    # 섬 번호가 num인 섬에서 다른 번호를 가진 섬까지 다리 연결하기
    while queue:
        x, y = queue.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            # 범위 넘어가면 continue
            if not(0 <= nx < n and 0 <= ny < n):
                continue

            # 다른 섬을 찾았다면
            if graph[nx][ny] > 0 and graph[nx][ny] != num:
                answer = min(answer, dist[x][y]) # 기존에 입력된 거리와, 현재까지 계산된 거리 중 최소값으로 갱신
                return

            if graph[nx][ny] == 0 and dist[nx][ny] == -1:

                dist[nx][ny] = dist[x][y] + 1 # 현재까지 계산된 거리 + 1 로 거리 저장해주기
                queue.append((nx, ny)) # 큐에 넣어주기

n = int(input())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 지도 입려 받기
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[False for _ in range(n)] for _ in range(n)]

# 섬 구분해주기
islandNum = 1 # 섬 번호
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and not visited[i][j]:
            findIsland(i, j)
            islandNum += 1

# 다리 이어주기

answer = n * n + 1 # 절대 나올 수 없는 최댓값을 미리 박아놓기
for i in range(1, islandNum):
    makeBridge(i)

print(answer)