# title: 달팽이 숫자
# difficulty: D2
# 시간: 10개 테스트케이스를 합쳐서 30초
# 메모리: 힙, 정적 메모리 합쳐서 256MB이내, 스택 메모리 1MB 이내

T = int(input())

# 우->하->좌->상 이동
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for test_case in range(1, T + 1):
    N = int(input())
    table = [[0 for _ in range(N)] for _ in range(N)]

    x, y = 0, 0 # 초기 위치
    dist = 0 # 초기 방향 (0: 우, 1: 하, 2: 좌, 3: 상)

    for n in range(1, N*N+1):
        table[x][y] = n

        # 방향 전환
        x += dx[dist]
        y += dy[dist]

        if x < 0 or y < 0 or x >= N or y >= N or table[x][y] != 0: # 범위를 벗어나거나, 다음 위치의 수가 0이 아닌 경우
            # 방향 전환 취소
            x -= dx[dist]
            y -= dy[dist]

            # 방향 다시 정해주기
            dist = (dist + 1) % 4

            # 방향 전환
            x += dx[dist]
            y += dy[dist]

    print("#" + str(test_case))
    for row in table:
        print(*row)


