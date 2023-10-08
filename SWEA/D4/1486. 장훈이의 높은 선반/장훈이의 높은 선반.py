# 장훈이의 높은 선반, 4초(10개 테스트케이스)

from itertools import combinations

t = int(input())
for tc in range(1, t+1):
    n, b = list(map(int, input().split()))
    height = list(map(int, input().split()))

    minHeight = 999999
    for i in range(1, n+1):
        for number in list(combinations(height, i)):
            if sum(number) >= b:
                minHeight = min(sum(number), minHeight)

    print("#{} {}".format(tc, minHeight - b))
