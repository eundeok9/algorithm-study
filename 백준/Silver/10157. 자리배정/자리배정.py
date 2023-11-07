import sys
input = sys.stdin.readline

c, r = map(int, input().split())
k = int(input())

graph = [[0 for _ in range(r)] for _ in range(c)]

graph[0][0] = 1

# 우 하 좌 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

startR = 0
startC = 0

# k가 1이면 (1, 1)
if k == 1:
    print(1, 1)
    exit(0)

# k가 1이 아니면 달팽이 탐색
d = 0
for i in range(r*c):
    nr = startR + dx[d]
    nc = startC + dy[d]


    if 0 <= nr < c and 0 <= nc < r and graph[nr][nc] == 0:
        graph[nr][nc] = graph[startR][startC] + 1
    else:
        nr -= dx[d]
        nc -= dy[d]
        d = (d+1) % 4

        nr += dx[d]
        nc += dy[d]
        graph[nr][nc] = graph[startR][startC] + 1
    startR = nr
    startC = nc
    if graph[nr][nc] == k:
        print(nr+1, nc+1)
        exit(0)

# 탐색 했는데 k가 나오지 않으면 0 출력
print(0)
