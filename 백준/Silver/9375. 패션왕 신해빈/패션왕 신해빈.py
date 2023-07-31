import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())

    styles = {}
    answer = 1

    for _ in range(N):
        value, key = list(map(str, input().split()))
        if key not in styles:
            styles[key] = 1
        else:
            styles[key] += 1

    for i in styles:
        answer *= (styles[i] + 1)

    print(answer - 1)