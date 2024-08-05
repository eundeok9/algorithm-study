# 2초, 128mb
import sys
input =  sys.stdin.readline

n = input().rstrip()
arr = [0 for _ in range(10)]

for i in n:
    if i == '6' or i == '9':
        if arr[6] <= arr[9]:
            arr[6] += 1
        else:
            arr[9] += 1
    else:
        arr[int(i)] += 1

print(max(arr))