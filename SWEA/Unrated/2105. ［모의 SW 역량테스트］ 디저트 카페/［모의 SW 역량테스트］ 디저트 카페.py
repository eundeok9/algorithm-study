test_case = int(input())

def dfs(x, y, dir, cnt, dessert):
    global result

    for d in range(dir, 4):
        nx = x + dx[d]
        ny = y + dy[d]

        if 0 <= nx < n and 0 <= ny < n and visited[nx][ny]: # 범위 안에 있는 방문하지 않은 곳이라면
            if cafes[nx][ny] in dessert: # 다음에 방문할 카페가 같은 수의 디저트를 파는 곳일 경우
                if visited[nx][ny] == 2 and len(dessert) >= 4: # 출발한 곳이었다면 디저트 수 갱신
                    result = max(result, cnt)
                    return
                continue # 출발한 곳이 아니면 continue
            visited[nx][ny] = 0 # 방문처리
            dfs(nx, ny, d, cnt+1, dessert + [cafes[nx][ny]])
            visited[nx][ny] = 1 # 방문처리 해제


for tc in range(1,test_case+1):
    n = int(input())
    cafes = [list(map(int, input().split())) for _ in range(n)]

    # 좌하 우하 우상 좌상
    dx = [1, 1, -1, -1]
    dy = [-1, 1, 1, -1]

    visited = [[1 for _ in range(n)] for _ in range(n)]

    result = -1
    for i in range(n):
        for j in range(1, n):
            visited[i][j] = 2 # 출발지 표시
            dfs(i, j, 0, 1, [cafes[i][j]])
            visited[i][j] = 1 # 출발지 리셋
    print("#{} {}".format(tc, result))