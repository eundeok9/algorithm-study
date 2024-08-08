# 2초, 128mb
import sys
input = sys.stdin.readline

n = int(input())

count = 1
isPossible = True
stack = []
op = []



for _ in range(n):
    num = int(input())
    
    while count <= num:
        stack.append(count)
        op.append('+')
        count += 1
    
    if stack[-1] == num:
        stack.pop()
        op.append('-')
    
    else:
        isPossible = False
        print("NO")
        break
    
if isPossible == True:
    for data in op:
        print(data)