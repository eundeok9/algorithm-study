# 1초, 256mb
import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
arr.sort()

for i in range(1, len(arr)):
    arr[i] = arr[i-1] + arr[i]

print(sum(arr))