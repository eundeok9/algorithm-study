# 2초, 128mb
import sys
input = sys.stdin.readline

# +, - 로 이루어진 수식의 최솟값 구하기
# => - 기준으로 앞 뒤에 있는 + 연산을 먼저 한 다음에 - 연산 하기

arr = input().split('-')
num = []

for i in arr:
    sum = 0
    
    data = i.split('+')
    
    for j in data:
        sum += int(j)
    
    num.append(sum)

n = num[0]

for i in range(1, len(num)):
    n -= num[i]

print(n)