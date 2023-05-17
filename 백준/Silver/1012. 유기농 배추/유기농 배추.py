def dfs(x, y):
    if x < 0 or y < 0 or x >= N or y >= M:
        return False

    if graph[x][y] == 1:
        graph[x][y] = 0

        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True

    return False

T = int(input()) # 테스트 케이스 수

for test_case in range(T):
    M, N, K = list(map(int, input().split())) # M: 가로길이 N: 세로길이

    graph = [[0 for _ in range(M)] for _ in range(N)]

    for _ in range(K):
        a, b = list(map(int,input().split()))
        graph[b][a] = 1

    result = 0
    for i in range(N):
        for j in range(M):
            if dfs(i, j) == True:
                result += 1

    print(result)
