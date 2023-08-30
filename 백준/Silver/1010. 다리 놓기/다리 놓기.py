import sys
input = sys.stdin.readline

T = int(input())

def fact(n):
    memo = [1, 1]
    if n==1: return 1
    for i in range(2, n+1):
        memo.append(i * memo[i - 1])

    return memo[n]

for _ in range(T):
    N, M = list(map(int, input().split()))
    nFact = fact(N)
    nmFact = fact(M-N)
    mFact = fact(M)

    answer = mFact // (nFact * nmFact)
    print(answer)