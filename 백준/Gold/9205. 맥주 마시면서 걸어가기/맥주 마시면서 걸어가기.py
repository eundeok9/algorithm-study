# 백준 9205. 맥주 마시면서 걸어가기
# 시간 1초 / 메모리 128MB
from collections import deque

def bfs():
    queue = deque()
    queue.append([startX, startY])

    while queue:
        x, y = queue.popleft()

        if (abs(x - pentaX) + abs(y - pentaY)) <= 1000:
            print('happy')
            return

        for i in range(n):
            dist = abs(x - graph[i][0]) + abs(y - graph[i][1])
            if not visited[i] and dist <= 1000:
                visited[i] = True
                queue.append([graph[i][0], graph[i][1]])

    print('sad')
    return

t = int(input())

for _ in range(t):
    n = int(input())

    startX, startY = map(int, input().split())

    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))

    pentaX, pentaY = map(int, input().split())
    graph.append([pentaX, pentaY])

    visited = [False for _ in range(n)]

    bfs()