import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    cnt_0, cnt_1 = 1, 0 # 0과 1이 호출된 횟수
    for i in range(n):
        cnt_0, cnt_1 = cnt_1, cnt_0 + cnt_1
    print(cnt_0, cnt_1)