# 0.5초, 256mb
import sys
input = sys.stdin.readline

n = int(input())
stack = []

for _ in range(n):
    cmd = input().split()
    
    if cmd[0] == 'push':
        stack.append(cmd[1])
    
    elif cmd[0] == 'pop':
        if stack:
            print(stack.pop())
        else:
            print(-1)
    
    elif cmd[0] == 'size':
        print(len(stack))
    
    elif cmd[0] == 'empty':
        if stack:
            print(0)
        else:
            print(1)
    
    elif cmd[0] == 'top':
        if stack:
            print(stack[len(stack)-1])
        else:
            print(-1)