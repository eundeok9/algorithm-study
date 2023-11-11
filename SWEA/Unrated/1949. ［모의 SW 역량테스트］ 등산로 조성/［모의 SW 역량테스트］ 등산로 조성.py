# 등산로 조성 / 파이썬 15초

# 풀이 방법
# 1. 지도 입력 받고, 가장 높은 곳의 높이 저장
# 2. dfs를 통해 사방탐색
#   - 이동할 위치가 현재 위치보다 낮으면 방문처리
#       - 방문 처리는 현재 위치 + 1로 거리를 저장해야함
# 3. 산을 깎을 기회가 있고, 다음 이동할 위치에서 k 를 깎은 것이 현 위치보다 작다면 기회를 사용해보자
#   - 근데 이동할 위치의 기존 높이를 저장해놔야함. 왜냐하면 재귀 탈출하고 나서 원복 해줘야하니까
#   - 이동할 위치의 높이를 1~k를 다 검사해서 깎는 것보단, 현재위치보다 1 작게만 깎아주면 될 듯
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def dfs(r, c, chance):
    global maxLength, visited
    maxLength = max(maxLength, visited[r][c])

    for d in range(4): # 사방탐색
        nr = r + dx[d]
        nc = c + dy[d]
        if not (0 <= nr < n and 0 <= nc < n) or visited[nr][nc]:
            continue
        if graph[r][c] > graph[nr][nc]: # 이동할 위치의 높이가 더 낮다면
            visited[nr][nc] = visited[r][c] + 1 # 방문처리 => 길이 정보 저장
            dfs(nr, nc, chance)
            visited[nr][nc] = 0 # 재귀 탈출 => 방문 처리 초기화
        elif chance and graph[nr][nc] - k < graph[r][c]:
            temp = graph[nr][nc] # 원래 높이 저장
            graph[nr][nc] = graph[r][c] - 1 # 기회를 사용해서 높이를 현재 높이보다 1 낮게 설정
            visited[nr][nc] = visited[r][c] + 1 # 방문 처리 => 거리 저장
            dfs(nr, nc, chance - 1)
            visited[nr][nc] = 0
            graph[nr][nc] = temp


t = int(input())

for tc in range(1, t+1):
    n, k = map(int, input().split())
    graph = []
    maxHeight = 0
    for i in range(n):
        graph.append(list(map(int, input().split())))
        for j in range(n):
            if maxHeight < graph[i][j]:
                maxHeight = graph[i][j] # 가장 높은 곳의 높이 저장

    maxLength = 0
    visited = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j] == maxHeight:
                visited[i][j] = 1
                dfs(i, j, 1) # 현재 위치, 찬스
                visited[i][j] = 0

    print("#{} {}".format(tc, maxLength))