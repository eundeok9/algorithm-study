
from collections import deque


def perm(cnt):
    global min_route
    if cnt == n:
        tmp = calc()
        min_route = min(min_route, tmp)
        return
    else:
        for i in range(n):
            if isSelected[i] == 1:
                continue
            numbers[cnt] = i
            isSelected[i] = 1
            perm(cnt+1)
            isSelected[i] = 0

def calc():
    dist = 0
    dist = abs(companyX - customer[numbers[0]][0]) + abs(companyY - customer[numbers[0]][1])

    for i in range(n-1):
        dist += abs(customer[numbers[i]][0] - customer[numbers[i+1]][0])\
                + abs(customer[numbers[i]][1] - customer[numbers[i+1]][1])

    dist += abs(customer[numbers[n-1]][0] - homeX) + abs(customer[numbers[n-1]][1] - homeY)

    return dist

t = int(input())
for tc in range(1, t+1):

    n = int(input()) # 고객 수
    location = deque(map(int, input().split()))

    numbers = [int(0) for _ in range(n)]
    isSelected = [int(0) for _ in range(n)]
    min_route =9999999

    companyX = location.popleft() # 회사 좌표
    companyY = location.popleft()
    homeX = location.popleft() # 집 좌표
    homeY = location.popleft()

    customer = [[int(0) for _ in range(2)] for _ in range(n)] # 고객 좌표

    for i in range(n):
        customer[i][0] = location.popleft()
        customer[i][1] = location.popleft()

    perm(0)
    print("#{} {}".format(tc, min_route))