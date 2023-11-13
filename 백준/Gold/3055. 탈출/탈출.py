# 백준 3055. 탈출
# 시간 1초 / 메모리 128MB

# 물이 차오르는 시간을 담고 있는 배열을 만들자 by BFS

from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def makeWaterGraph():
    global water_queue
    x, y = water_queue.popleft()
    waters[x][y] = 0
    water_queue.appendleft((x, y))
    while water_queue:
        x, y = water_queue.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if not(0 <= nx < r and 0 <= ny < c) or waters[nx][ny] != -1:
                continue

            if graph[nx][ny] == '.' or graph[nx][ny] == 'S':
                waters[nx][ny] = waters[x][y] + 1
                water_queue.append((nx, ny))

def move():
    global answer
    queue = deque()
    queue.append((gosumdochi[0][0], gosumdochi[0][1]))
    visited[gosumdochi[0][0]][gosumdochi[0][1]] = 0

    while queue:
        x, y = queue.popleft()

        if graph[x][y] == 'D':
            answer = visited[x][y]

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]


            # 범위 넘어가거나 이미 방문한 경우 continue
            if not (0 <= nx < r and 0 <= ny < c) or visited[nx][ny] != -1:
                continue

            # 돌을 만나면 continue
            if graph[nx][ny] == 'X':
                continue

            # 다음 이동할 위치가 물이 찰 예정인 칸이면 continue
            if waters[nx][ny] != -1 and waters[nx][ny] <= visited[x][y] + 1 and graph[nx][ny] != 'D':
                continue

            # 다른 예외는 없겠지...
            else:
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))


r, c = map(int, input().split())

# r * c 지도 입력 받고 물이 위치한 곳 좌표를 queue에 담기
graph = []
water_queue = deque()
gosumdochi = []
for i in range(r):
    graph.append(list(input()))
    for j in range(c):
        if graph[i][j] == '*':
            water_queue.append((i, j))
        if graph[i][j] == 'S':
            gosumdochi.append([i, j]) # 고슴도치 위치 저장

waters = [[-1 for _ in range(c)] for _ in range(r)] # 물이 차오를 시간을 담고 있는 배열
if water_queue:
    makeWaterGraph()
# print(waters)

answer = r * c + 1
visited = [[-1 for _ in range(c)] for _ in range(r)]
move()

if answer == r * c + 1:
    print("KAKTUS")
else:
    print(answer)