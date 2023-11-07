# 탈주범 검거

# 풀이 방법
# 1. 맨홀 지점에 적힌 숫자를 queue에 넣는다
# 2. 그 숫자를 queue에서 꺼낸다
# 3. pipes[꺼낸 숫자]에 해당하는 배열을 꺼내자
# 4. (꺼낸 숫자가 3일 때) [3, 4] // 배열 하나씩 접근해서 방향 벡터 적용
# 5. 해당 방향에 이동 가능한 파이프가 있으면 cnt 1 추가, 방문 체크

# 각 방향 벡터(index)별 이동 가능한 파이프
# [1]: 1, 2, 5, 6
# [2]: 1, 2, 4, 7
# [3]: 1, 3, 4, 5
# [4]: 1, 3, 6, 7

from collections import deque

test_case = int(input())

dx = [0, -1, 1, 0, 0] # 행 delta
dy = [0, 0, 0, -1, 1] # 열 delta
pipes = [0, [1,2,3,4], [1,2], [3,4], [1,4], [2,4], [2,3], [1,3]] # 각 파이프 별로 이동가능한 방향
possibleDir = [0, [1, 2, 5, 6], [1, 2, 4, 7], [1, 3, 4, 5], [1, 3, 6, 7]] # 각 방향벡터 별 이동 가능한 파이프

def bfs():
    global cnt
    queue = deque()
    queue.append((r, c, graph[r][c]))
    visited[r][c] = 1
    # graph[r][c] = -1 # 방문 처리

    while queue:
        # for row in visited:
        #     print(row)

        # print(cnt)
        curR, curC, pipeNum = queue.popleft()
        # print(curR, curC, visited[curR][curC])
        # print("----")
        if visited[curR][curC]+1 > l:
            return
        pipeArr = pipes[pipeNum]

        for dir in pipeArr: # 현재 파이프에서 이동 가능한 방향 하나씩 꺼내서 이동
            newR, newC = curR + dx[dir], curC + dy[dir]
            if 0 <= newR < n and 0 <= newC < m and visited[newR][newC] == 0:
                if graph[newR][newC] in possibleDir[dir]: # 이동 가능한 방향이라면
                    queue.append((newR, newC, graph[newR][newC])) # 큐에 넣기
                    visited[newR][newC] = visited[curR][curC] + 1 # 방문처리
                    # graph[newR][newC] = -1 # 방문 처리
                    # if visited[newR][newC] <= l:
                    cnt += 1 # 이동 가능한 위치 1 증가


for tc in range(1, test_case + 1):
    n, m, r, c, l = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(n)]
    visited = [[0 for _ in range(m)] for _ in range(n)]
    cnt = 1 # 맨홀은 이미 위치할 수 있는 곳이므로 1부터 시작
    bfs()
    print("#{} {}".format(tc, cnt))
