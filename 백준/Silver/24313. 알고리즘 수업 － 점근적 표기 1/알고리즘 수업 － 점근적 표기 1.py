import sys
input = sys.stdin.readline

# O(g(n)) = f(n)
# 모든 n >= n0에 대하여 f(n) <= c * g(n) 인 양의 상수 c와 n0가 존재

a1, a0 = list(map(int, input().split()))
c = int(input())
n0 = int(input())

if (a1 * n0 + a0 <= c * n0) and (a1 <= c):
    ans = 1
else:
    ans = 0

print(ans)