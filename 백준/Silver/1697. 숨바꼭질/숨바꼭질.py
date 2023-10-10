# 숨바꼭질

import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    queue = deque()
    queue.append(n)
    visited = [0 for _ in range(100001)]


    while queue:
        cur = queue.popleft()
        if cur == k:
            return visited[cur]

        for nxt in (cur-1, cur+1, cur*2):
            if 0 <= nxt <= 100000 and visited[nxt] == 0:
                visited[nxt] = visited[cur] + 1
                queue.append(nxt)


n, k = list(map(int, input().split()))

print(bfs())