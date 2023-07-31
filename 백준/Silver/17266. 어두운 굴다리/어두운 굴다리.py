import sys
input = sys.stdin.readline

N = int(input()) # 굴다리 길이
M = int(input()) # 가로등 개수
x = list(map(int, input().split())) # 가로등 위치

min_height = 0 # 가로등 최소 높이

if M == 1: # 가로등이 한 개이면 시작지점과 끝지점 중 더 먼거리만큼 높아야함
    min_height = max(x[0] - 0, N - x[0])

else:
    for i in range(M):
        if i == 0:
            tmpMin = x[0] - 0
        elif i == M - 1:
            tmpMin = N - x[i]
        else:
            tmp = x[i] - x[i-1]
            if tmp % 2:
                tmpMin = tmp // 2 + 1
            else:
                tmpMin = tmp // 2

        min_height = max(tmpMin, min_height)

print(min_height)