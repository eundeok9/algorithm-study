# 벽돌 깨기
from itertools import product
from collections import deque
# 풀이 방법
# 1. w칸 중에 구슬을 때릴 칸을 n번 선택한다 (wPn) -> perm 배열에 저장
# 2. perm 배열에서 숫자 하나씩 꺼내고, 해당 숫자에 해당하는 열 위에서부터 탐색 -> 0이 아닌 수 만나면 queue에 (좌표, 숫자) 넣기
# 3. 벽돌을 깨자, queue에서 값을 꺼내자
#   - 벽돌에 적힌 숫자가 1이면: 걔만 0으로 바꾸고 perm에서 다음 숫자 꺼내
#   - 1이 아니면: 걔를 0으로 바꾸고 사방 탐색을 (숫자-1)만큼 해야됨


def break_brick(arr):
    # 벽돌 배열 복사해오기
    # 이제 여기선 복사된 배열만 쓸거임.. 아마도?..
    bricksCopy = [[0 for _ in range(w)] for _ in range(h)]
    for r in range(h):
        for c in range(w):
            bricksCopy[r][c] = bricks[r][c]

    queue = deque()
    # print(arr, "일 때")
    # print("--------")
    for colNum in arr:
        for row in range(h):
            if bricksCopy[row][colNum] != 0: # 이 열에서 벽돌을 찾았다!
                queue.append((row, colNum, bricksCopy[row][colNum]))

                while queue: # 큐를 돌아보자..
                    size = len(queue)
                    for _ in range(size):
                        r, c, num = queue.popleft()

                        bricksCopy[r][c] = 0
                        for d in range(4):
                            for i in range(1,num):
                                nr = r + dx[d] * i
                                nc = c + dy[d] * i
                                if 0 <= nr < h and 0 <= nc < w and bricksCopy[nr][nc] != 0:
                                    queue.append((nr, nc, bricksCopy[nr][nc]))
                                    bricksCopy[nr][nc] = 0
                break # 젤 위에 하나 깼으면 끝내고 벽돌 내리고 perm 배열에서 다음 값 꺼내

        # 잘 깨지는지 중간 점검
        # for row in bricksCopy:
        #     print(row)
        # print("- - - - - - - -")
        fall_brick(bricksCopy)



    # 다 끝나면 남은 벽돌 개수 세자
    cnt = count_remain_brick(bricksCopy)

    return cnt

def fall_brick(bricks):
    for col in range(w):
        for i in range(h-1, 0, -1):
            if bricks[i][col] == 0:
                for j in range(i-1, -1,-1):
                    if bricks[j][col] == 0:
                        continue
                    elif bricks[j][col] != 0:
                        bricks[i][col] = bricks[j][col]
                        bricks[j][col] = 0
                        i = j+1
                    break

def count_remain_brick(bricks):
    cnt = 0
    for r in range(h):
        for c in range(w):
           if bricks[r][c] != 0:
               cnt += 1
    return cnt

# 좌 하 우 상
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

test_case = int(input())

for tc in range(1, test_case+1):
    n, w, h = map(int, input().split())
    bricks = [list(map(int, input().split())) for _ in range(h)]

    minCnt = 1e8
    num_arr = [int(i) for i in range(w)]
    for perm in product(num_arr, repeat=n):
        minCnt = min(break_brick(perm), minCnt)

    print("#{} {}".format(tc, minCnt))

