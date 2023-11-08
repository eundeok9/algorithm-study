# 핀볼 게임

def playball(r, c, d):
    score = 0
    originR = r
    originC = c
    originD = d
    while True:
        r += dx[d] # 현재 방향으로 1칸 이동
        c += dy[d]

        if 0 <= r < n and 0 <= c < n and graph[r][c] == -1: # 블랙홀 만나면 핀볼게임 끝
            break
        if originR == r and originC == c: # 시작 위치로 돌아오면 핀볼게임 끝
            break

        if r < 0 or r >= n or c < 0 or c >= n: # 벽 만나는 경우
            # 방향 전환시켜주자
            if d == 0:
                d = 1
            elif d == 1:
                d = 0
            elif d == 2:
                d = 3
            elif d == 3:
                d = 2
            score+=1

        elif 1 <= graph[r][c] <= 5: #도형 만나는 경우, 도형 모양에 따른 방향 전환
            num = graph[r][c] # 도형 숫자를 가져오자
            d = switchedDir[num][d] # 새로운 방향을 설정해주자
            score += 1 # 벽 만났을 때 점수 올려주자

        elif 6 <= graph[r][c] <= 10: #웜홀 만나는 경우
            num = graph[r][c] # 웜홀 숫자 가져와
            warmholeArr = warmhole[num] # 웜홀 정보 담은 배열에서 숫자에 해당하는 좌표쌍 꺼내와
            if (r,c) == warmholeArr[0]:
                (r, c) = warmholeArr[1]
            elif (r, c) == warmholeArr[1]:
                (r, c) = warmholeArr[0]

    return score

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 각 도형에 대해서 다가오는 방향이 상,하,좌,우 일 때 바뀌는 방향 index
# 바뀔 방향 = switchedDir[도형숫자][현재방향]
switchedDir = [0, [1, 3, 0, 2], [3, 0, 1, 2], [2, 0, 3, 1],[1, 2, 3, 0], [1, 0, 3, 2]]


test_case = int(input())

for tc in range(1, test_case + 1):
    n = int(input())
    graph = []
    warmhole = [[] for _ in range(11)]
    for r in range(n):
        graph.append(list(map(int, input().split())))
        for c in range(n):
            if 6 <= graph[r][c] <= 10:
                warmhole[graph[r][c]].append((r, c))

    maxScore = -1
    for r in range(n):
        for c in range(n):
            if graph[r][c] == 0:
                for d in range(4):
                    maxScore = max(playball(r, c, d), maxScore)

    print("#{} {}".format(tc, maxScore))
