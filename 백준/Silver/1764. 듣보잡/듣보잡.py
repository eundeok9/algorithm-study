# 2초, 256mb
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = set()
for _ in range(n):
    arr.add(input().rstrip())


ans = set()
for _ in range(m):
    name = input().rstrip()
    
    if name in arr:
        ans.add(name)

print(len(ans))
for name in sorted(ans):
    print(name) 