# 2초 128mb

import sys
input = sys.stdin.readline

n = int(input())

end = 0
cnt = 0

arr = []

for i in range(n):
    s, e = map(int, input().split())
    arr.append([s, e])

arr.sort(key = lambda x: (x[1], x[0]))

for s, e in arr:
    if end <= s:
        cnt += 1
        end = e

print(cnt)