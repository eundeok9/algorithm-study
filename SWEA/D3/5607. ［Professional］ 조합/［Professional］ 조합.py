# SWEA 5607 조합, 파이썬 8초(20개 테스트케이스)
# 페르마의 소정리

t = int(input())

for tc in range(1, t+1):
    n, r = map(int, input().split())
    p = 1234567891

    memo = [0] * 1000001
    memo[1] = 1
    memo[2] = 2
    for i in range(3, 1000001):
        memo[i] = (memo[i - 1] * i) % p

    nFact = memo[n]
    nrFact = memo[n-r]
    rFact = memo[r]

    res = nFact * pow(nrFact, p-2, p) * pow(rFact, p-2, p)
    res %= p

    print("#{} {}".format(tc, res))
