test_case = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def connect(depth, curCnt, curLength):
    global maxCnt, minLength

    if depth == len(cores):
        if curCnt > maxCnt:
            minLength = curLength
            maxCnt = curCnt
        elif curCnt == maxCnt:
            minLength = min(minLength, curLength)
        return

    x, y = cores[depth]

    for d in range(4):
        count = 0
        nx = x
        ny = y

        while True:
            nx += dx[d]
            ny += dy[d]

            if nx < 0 or nx >= n or ny < 0 or ny >= n: # 범위 밖으로 나가는 경우 정상 연결 완료
                break

            if board[nx][ny] == 1: # 다른 코어 or 전선 만난 경우 연결 실패
                count = 0
                break

            count += 1

        # 연결되지 못한 경우
        # 다음 코어로 넘어가기 위해 depth만 1 올려주고 재귀 호출
        if count == 0:
            connect(depth + 1, curCnt, curLength)
            
        # 연결된 경우
        # 다음 코어로 넘어가기, 현재까지 연결된 코어 개수, 전선 길이 갱신
        else:
            originX = x
            originY = y
            
            # 일단 연결된 전선 표시해주고
            for _ in range(count):
                originX += dx[d]
                originY += dy[d]
                board[originX][originY] = 1
            
            # 다음 코어 살피러 간다
            connect(depth + 1, curCnt + 1, curLength + count)
            
            # 갔다 오면 현재 코어 연결했던 정보 날리기
            for _ in range(count):
                board[originX][originY] = 0
                originX -= dx[d]
                originY -= dy[d]


for tc in range(1, test_case+1):
    n = int(input())

    board = []
    cores = []

    for r in range(n):
        board.append(list(map(int, input().split())))
        for c in range(n):
            if r == 0 or r== n-1 or c == 0 or c== n-1: # 벽에 있는 코어 빼고
                continue
            if board[r][c] == 1: # 코어 위치 저장하기
                cores.append([r,c])

    maxCnt = -1 # 최대 코어 개수
    minLength = n * n # 최소 전선 길이

    connect(0, 0, 0)

    print("#{} {}".format(tc, minLength))