# 벽돌 깨기, 15초(50개 테스트케이스)
# n개의 구슬로 최대한 많은 벽돌을 깨서 남은 벽돌 개수 구하기
from collections import deque
from itertools import product
from itertools import combinations


col_list = [i for i in range(10)]
# print(list(product(col_list, repeat=3)))


# 중복 순열
def perm(cnt):
    global minBricks
    if cnt == n:
        minBricks = min(hit(numbers), minBricks)
        return

    for i in range(w):
        numbers[cnt] = i
        perm(cnt+1)
        numbers[cnt] = 0


# 벽돌 때리기
# - 때릴 위치가 저장되어있는 numbers의 값을 하나씩 빼와서
# - 해당 열의 가장 위에 있는 벽돌을 때린다
# - 그리고 그 벽돌에 적힌 숫자에 해당하는 범위만큼 벽돌을 없앤다
def hit(numbers):
    bricks_copy = [[0 for _ in range(w)] for _ in range(h)] # 복사본
    for i in range(h):
        for j in range(w):
            bricks_copy[i][j] = bricks[i][j]
    queue = deque()

    for col in numbers:
        for r in range(h):
            if bricks_copy[r][col]:
                number = bricks_copy[r][col] # 벽돌에 적힌 숫자

                queue.append((r, col, number))
                bricks_copy[r][col] = 0

                while queue:
                    size = len(queue)
                    for i in range(size):
                        x, y, num = queue.popleft()

                        for dir in range(4):  # 4방 탐색
                            for cnt in range(num):  # 벽돌에 적힌 수 만큼 이동
                                nx = x + dx[dir] * cnt
                                ny = y + dy[dir] * cnt
                                if 0 > nx or nx >= h or ny < 0 or ny >= w:
                                    continue
                                if bricks_copy[nx][ny] == 0:
                                    continue
                                queue.append((nx, ny, bricks_copy[nx][ny]))
                                bricks_copy[nx][ny] = 0

                        # print(x, y, num)
                        # for i in bricks_copy:
                        #     print(i)

                break
                # 빈칸 채워주기.
        falling_bricks(bricks_copy)
        # print(numbers, "번째", col)
        # for i in bricks_copy:
        #     print(i)


    # print(numbers, "번째")
    # # print(bricks_copy)
    # for i in bricks_copy:
    #     print(i)
    return count_bricks(bricks_copy)


# 빈 칸으로 벽돌 떨어트리기
def falling_bricks(bricks_copy):
    for i in range(w):
        for j in range(h-1, -1, -1):
            if bricks_copy[j][i] == 0:
                for k in range(j-1, -1, -1):
                    if bricks_copy[k][i] != 0:
                        bricks_copy[j][i] = bricks_copy[k][i]
                        bricks_copy[k][i] = 0
                        break


def count_bricks(bricks_copy):
    remain_bricks = 0
    for i in range(h):
        for j in range(w):
            if bricks_copy[i][j] != 0:
                remain_bricks += 1

    return remain_bricks


# 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

t = int(input())
for tc in range(1, t+1):
    # n : 구슬 개수
    # w : 가로 너비 (열)
    # h : 세로 높이 (행)
    n, w, h = list(map(int, input().split()))

    # 벽돌 입력 받기
    bricks = [] # 벽돌

    for _ in range(h):
        bricks.append(list(map(int, input().split())))

    # 전체 벽돌의 개수
    # total_bricks = 0
    # for i in range(h):
    #     for j in range(w):
    #         if bricks[i][j]:
    #             total_bricks += 1

    numbers = [0 for _ in range(n)]

    # 중복 순열로 타격할 열 위치 구하고, 깨트린 벽돌 개수 구하기
    minBricks = 9999
    perm(0)

    print("#{} {}".format(tc, minBricks))

