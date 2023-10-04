import sys
input = sys.stdin.readline

n, m = list(map(int, input().split()))
compare = [[0 for _ in range(n)] for _ in range(n)]
for _ in range(m):
    small, tall = map(int, input().split())
    compare[small-1][tall-1] = 1


for k in range(n):
    for i in range(n):
        for j in range(n):
            if compare[i][k] == 1 and compare[k][j] == 1:
                compare[i][j] = 1

ans = 0
for i in range(n):
    possible = 0
    for j in range(n):
        possible += compare[i][j] + compare[j][i]

    if possible == (n-1):
        ans += 1

print(ans)