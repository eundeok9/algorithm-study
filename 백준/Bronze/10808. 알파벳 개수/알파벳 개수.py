# 시간 1초, 메모리 256mb
import sys
input = sys.stdin.readline

arr = [0 for _ in range(26)]

s = list(input().rstrip())

for word in s:
    arr[ord(word)-ord('a')] += 1

for num in arr:
    print(num, end= " ")
