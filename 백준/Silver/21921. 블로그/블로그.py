#1초 512mb

import sys
input = sys.stdin.readline

n, x = map(int, input().split())
visitor = list(map(int, input().split()))

if max(visitor) == 0:
  print("SAD")
  exit()
  
value = sum(visitor[:x]) # 0번째부터 x번째 전까지의 합
max_value = value
cnt = 1

for i in range(x, n):
    value += visitor[i] # 다음 날 값 더해주기
    value -= visitor[i-x] # 앞 날 값 빼기
    
    if value > max_value:
        max_value = value
        cnt = 1
    elif value == max_value:
        cnt += 1
    
print(max_value)
print(cnt)