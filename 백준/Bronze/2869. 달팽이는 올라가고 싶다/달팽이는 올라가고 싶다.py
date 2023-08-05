# V 미터 나무 막대
# 낮에 + A , 밤에 - B , 정상에서는 x
# 막대 올라가는데 며칠?
import sys
input = sys.stdin.readline

def main():
    A, B, V = list(map(int, input().split()))

    if (V-B) % (A-B) == 0:
        cnt = (V-B) / (A-B)
    else:
        cnt = (V-B) / (A-B) + 1

    print(int(cnt))

main()