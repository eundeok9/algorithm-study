# swea 1767. 프로세서 연결하기 (몇번쨰인지...)
# 시간 8초 / 메모리 256MB

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def connect(idx, coreCnt, length):
    global maxCore, minLength

    if idx == len(cores):
        if coreCnt == maxCore: # 카운트 된 코어 개수가 같으면
            minLength = min(length, minLength)
        elif coreCnt > maxCore: # 카운트 된 코어 개수가 더 많다면
            maxCore = coreCnt
            minLength = length
        return

    x, y = cores[idx]

    for d in range(4):
        nx, ny = x, y
        cnt = 0
        while True:
            nx += dx[d]
            ny += dy[d]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                break

            if graph[nx][ny] ==1:
                cnt = 0
                break

            cnt += 1

        if cnt == 0: # 이 방향으로는 전선 연결 못한다 돌아가라
            connect(idx+1, coreCnt, length)

        else:
            originX, originY = x, y

            for i in range(cnt):
                originX += dx[d]
                originY += dy[d]
                graph[originX][originY] = 1

            connect(idx+1, coreCnt+1, length+cnt)

            for i in range(cnt):
                graph[originX][originY] = 0
                originX -= dx[d]
                originY -= dy[d]


t = int(input())

for tc in range(1, t+1):
    n = int(input())
    graph = []
    cores = []
    for i in range(n):
        graph.append(list(map(int, input().split())))
        for j in range(n):
            if i == 0 or i == n-1 or j == 0 or j == n-1: # 이미 연결된 코어는 제외
                continue
            if graph[i][j] == 1: # 코어의 위치를 리스트에 담기
                cores.append([i, j])

    minLength = 1e8
    maxCore = -1
    connect(0, 0, 0)

    print("#{} {}".format(tc, minLength))