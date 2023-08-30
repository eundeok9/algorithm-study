import sys

input = sys.stdin.readline


def fact(n):
    num = 1
    for i in range(2, n + 1):
        num *= i
    return num


n, m = list(map(int, input().split()))

mFact = fact(m)
nFact = fact(n)
diffFact = fact(n - m)

answer = nFact // (mFact * diffFact)
print(answer)
