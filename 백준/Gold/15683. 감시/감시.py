# 백준 15683. 감시
# 시간 1초 / 메모리 512MB

import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 각 카메라가 감시할 수 있는 방향
cameraDir = [0, [0, 1, 2, 3], [[0, 1], [2, 3]], [[0,3],[0,2],[1,2],[1,3]], [[0,1,2],[0,1,3],[0,2,3],[1,2,3]], [[0,1,2,3]]]

def backtracking(depth):
    global result

    if depth == len(cameras):
        result = min(find(graph), result)
        return

    x, y = cameras[depth] # cctv 위치
    cameraNum = graph[x][y] # cctv 번호

    if cameraNum == 1:
        # 카메라 번호가 1번이면 dirArr = [0, 1, 2, 3]
        for d in range(4):
            nx = x
            ny = y
            while True:
                nx += dx[d]
                ny += dy[d]

                if not(0 <= nx < n and 0 <= ny < m) or graph[nx][ny] == 6:
                    break

                if graph[nx][ny] != '#' and 1 <= graph[nx][ny] <= 5:
                    continue

                graph[nx][ny] -= 1
            # print("----카메라번호----", cameraNum)
            # for row in graph:
            #     print(row)
            backtracking(depth + 1)
            nx = x
            ny = y
            while True:
                nx += dx[d]
                ny += dy[d]

                if not (0 <= nx < n and 0 <= ny < m) or graph[nx][ny] == 6:
                    break

                if graph[nx][ny] != '#' and 1 <= graph[nx][ny] <= 5:
                    continue

                graph[nx][ny] += 1

    else:
        # ex) 카메라 번호가 2번이면, dirArr = [[0, 1], [2, 3]]
        for dirArr in cameraDir[cameraNum]:
            # 그럼 이 d는 0, 1이 될 수 있으니, 한 번의 기회에 [0,1] 과 [2,3] 방향을 볼 수 있음
            for i in range(len(dirArr)):
                nx = x
                ny = y
                while True:
                    nx += dx[dirArr[i]]
                    ny += dy[dirArr[i]]

                    if not(0 <= nx < n and 0 <= ny < m) or graph[nx][ny] == 6:
                        break

                    if graph[nx][ny] != '#' and 1 <= graph[nx][ny] <= 5:
                        continue

                    graph[nx][ny] -= 1

                # print("----카메라번호----", cameraNum)
                # for row in graph:
                #     print(row)
            backtracking(depth+1)
            for i in range(len(dirArr)):
                nx = x
                ny = y
                while True:
                    nx += dx[dirArr[i]]
                    ny += dy[dirArr[i]]

                    if not (0 <= nx < n and 0 <= ny < m) or graph[nx][ny] == 6:
                        break

                    if graph[nx][ny] != '#' and 1 <= graph[nx][ny] <= 5:
                        continue

                    graph[nx][ny] += 1


def find(graph):
    count = 0
    for r in range(n):
        for c in range(m):
            if graph[r][c] == 0:
                count += 1
    return count

n, m = map(int, input().split())

graph = []
cameras = []
for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(m):
        if graph[i][j] != 0 and graph[i][j] != 6:
            cameras.append([i, j]) # cctv의 위치를 저장

result = 1e9
backtracking(0)

print(result)