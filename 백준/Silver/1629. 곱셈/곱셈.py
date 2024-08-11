# 0.5초, 128mb
import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())

def pow(a, n):
    if n == 1:
        return a % c
    else:
        tmp = pow(a, n//2)
        if n%2 == 0:
            return (tmp * tmp) % c
        else:
            return (tmp * tmp * a) % c
    
print(pow(a,b))