import sys
input = sys.stdin.readline

def dfs(cur, num):
    global ans
    num += 1
    visited[cur] = True

    if cur == b:
        ans = num

    for nxt in family[cur]:
        if not visited[nxt]:
            dfs(nxt, num)


n = int(input())
a, b = list(map(int, input().split()))
m = int(input())

family = [[] for _ in range(n+1)]
visited = [False] * (n+1)
for _ in range(m):
    x, y = list(map(int, input().split()))
    family[x].append(y)
    family[y].append(x)

ans = 0
dfs(a,ans)
print(ans-1)
