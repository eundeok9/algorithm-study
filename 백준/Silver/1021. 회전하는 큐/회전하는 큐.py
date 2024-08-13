# 2초, 128mb
import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())
position = list(map(int, input().split()))

queue = deque([i for i in range(1, n+1)])

count = 0
for i in position:
    while True:
        if queue[0] == i:
            queue.popleft()
            break
        else:
            if queue.index(i) < len(queue) / 2: # queue 길이의 절반을 기준으로 왼쪽에 위치하면 오른쪽으로 한 칸 이동
                while queue[0] != i:
                    queue.append(queue.popleft())
                    count += 1
            
            else: # queue 길이의 절반을 기준으로 오른쪽에 위치하면 왼쪽으로 한 칸 이동
                while queue[0] != i:
                    queue.appendleft(queue.pop())
                    count += 1
                    
print(count)
