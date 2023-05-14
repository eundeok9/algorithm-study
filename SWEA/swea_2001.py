# title: 파리 퇴치
# difficulty: D2
# 시간: 10개 테스트 케이스 합쳐서 30초
# 메모리: 힙, 정적 메모리 합쳐서 256MB이내, 스택 메모리 1MB 이내

T = int(input())

for test_case in range(1, T+1):
    N, M = list(map(int,input().split()))

    flies = []

    for _ in range(N):
        flies.append(list(map(int,input().split())))

    table = [[0 for _ in range(M)] for _ in range(M)]

    max = 0

    for i in range(N-(M-1)):
        for j in range(N-(M-1)):
            tmp = 0
            for x in range(i, i+M):
                for y in range(j, j+M):
                    tmp += flies[x][y]
                    if tmp > max:
                        max = tmp

    print("#{} {}".format(test_case, max))
