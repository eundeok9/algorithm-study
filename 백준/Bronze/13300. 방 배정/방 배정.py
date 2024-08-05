# 2초, 512mb
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

arr = [[0 for _ in range(2)] for _ in range(6)]

for _ in range(n):
    s, y = map(int, input().split())
    arr[y-1][s] += 1
    
cnt = 0
for i in range(6):
    for j in range(2):
        if arr[i][j] % k == 0:
            cnt += arr[i][j] // k
        else:
            cnt += (arr[i][j] // k) + 1
            

print(cnt)