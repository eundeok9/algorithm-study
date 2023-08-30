# 외판원 순회 2

import sys
input = sys.stdin.readline

n = int(input())
w = []
visited = [0] * n
minimum = sys.maxsize

for _ in range(n):
    w.append(list(map(int, input().split())))

def dfs(depth, start, cost):
    global minimum
    # 방문한 도시가 입력 받은 도시 개수와 같아지면
    # 마지막 도시에서 출발 도시로 이동하는데
    if depth == n-1 and w[start][0] != 0: # 마지막 도시에서 출발 도시로 가는 비용이 0이 아닐 때
        minimum = min(minimum, cost+w[start][0]) # 이전에 구해놨던 비용과 현재 결과를 비교해서 최소비용 구함
        return

    for i in range(n):
        # 다음 방문할 도시가 이미 방문했던 곳이 아니고, 현재 도시에서 가는 비용이 0이 아니라면(=갈 수 있는 곳이라면)
        if not visited[i] and w[start][i] != 0:
            visited[i] = 1 # 방문 처리
            dfs(depth+1, i, cost+w[start][i]) # 다음 도시 방문
            visited[i] = 0 # 방문 끝나면 방문 처리 해제

visited[0] = 1
dfs(0, 0, 0)
print(minimum)