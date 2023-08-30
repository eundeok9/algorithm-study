import sys
input = sys.stdin.readline

N, M = list(map(int, input().split()))
candyMap = []
resultMap = [[0 for _ in range(M+1)] for _ in range(N+1)]

for _ in range(N):
    candyMap.append(list(map(int, input().split())))

for i in range(1, N+1):
    for j in range(1, M+1):
        resultMap[i][j] = max(resultMap[i-1][j], resultMap[i][j-1], resultMap[i-1][j-1]) + candyMap[i-1][j-1]

print(resultMap[N][M])