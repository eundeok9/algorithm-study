import sys
input = sys.stdin.readline

N, M = list(map(int, input().split()))

arr = []
for _ in range(N):
    arr.append(str(input()))

checkArr = []
for _ in range(M):
    checkArr.append(str(input()))

cnt = 0
for i in checkArr:
    if i in arr:
        cnt += 1

print(cnt)

