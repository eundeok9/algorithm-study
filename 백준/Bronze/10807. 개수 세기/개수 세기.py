# 1초, 256mb
import sys
input = sys.stdin.readline

n = int(input().rstrip())
arr = list(map(int, input().split()))
v = int(input())

print(arr.count(v))