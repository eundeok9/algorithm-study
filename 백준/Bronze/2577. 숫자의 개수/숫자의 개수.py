# 1초, 128mb
import sys
input = sys.stdin.readline

a = int(input())
b = int(input())
c = int(input())
abc = list(str(a*b*c))

arr = [0 for _ in range(10)]
for i in range(10):
    arr[i] = abc.count(str(i))

for num in arr:
    print(num)