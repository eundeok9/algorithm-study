import sys
input = sys.stdin.readline
from collections import deque

def bfs(s, g):
    queue = deque()
    queue.append(s)
    visited = [-1 for _ in range(f+1)]
    visited[s] = 0

    while queue:
        cur = queue.popleft()

        if cur == g:
            return visited[cur]

        for nxt in (cur+u, cur-d):
            if 0 < nxt <= f and visited[nxt] == -1:
                queue.append(nxt)
                visited[nxt] = visited[cur] + 1

    return "use the stairs"


# f: 빌딩의 높이
# s: 현재 위치
# g: 스타트링크 위치
# u: 위로 올라가는 층수
# d: 아래로 내려가는 층수
# s -> g 까지 가는데 누르는 버튼 최소 횟수
f, s, g, u, d = list(map(int, input().split()))

print(bfs(s, g))