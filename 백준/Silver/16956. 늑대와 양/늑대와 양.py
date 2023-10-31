import sys
input = sys.stdin.readline

r, c = map(int, input().split())
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    for i in range(r):
        for j in range(c):
            if graph[i][j] == 'W':
                for d in range(4):
                    nx = i + dx[d]
                    ny = j + dy[d]

                    if nx < 0 or nx >= r or ny < 0 or ny >= c:
                        continue
                    if graph[nx][ny] == "S":
                        return False

    return True

graph = []
for _ in range(r):
    graph.append(list(input().rstrip()))

if bfs():
    print(1)
    for i in range(r):
        for j in range(c):
            if graph[i][j] == '.':
                graph[i][j] = "D"

    for r in graph:
        print(''.join(r))
else:
    print(0)