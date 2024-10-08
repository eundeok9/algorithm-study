# 0.5초, 256mb
import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
queue = deque()

for _ in range(n):
    cmd = list(input().rstrip().split())
    if cmd[0] == 'push_front':
        queue.appendleft(cmd[1])
    
    elif cmd[0] == 'push_back':
        queue.append(cmd[1])
    
    elif cmd[0] == 'pop_front':
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    
    elif cmd[0] == 'pop_back':
        if queue:
            print(queue.pop())
        else:
            print(-1)
    
    elif cmd[0] == 'size':
        print(len(queue))
        
    elif cmd[0] == 'empty':
        if queue:
            print(0)
        else:
            print(1)
        
    elif cmd[0] == 'front':
        if queue:
            print(queue[0])
        else:
            print(-1)
    
    elif cmd[0] == 'back':
        if queue:
            print(queue[-1])
        else:
            print(-1)