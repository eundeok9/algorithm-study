# 0.3초, 512mb
import sys
input = sys.stdin.readline

n = list(input().rstrip())
m = int(input())

popList = []

def move(cmd):
    if cmd[0] == 'L':
        if n:
            popList.append(n.pop())
    
    elif cmd[0] == 'D':
        if popList:
            n.append(popList.pop())
    
    elif cmd[0] == 'P':
        n.append(cmd[1])
    
    elif cmd[0] == 'B':
        if n:
            n.pop()
            

for _ in range(m):
    cmd = list(map(str, input().rstrip().split()))
    move(cmd)

n.extend(reversed(popList))
print("".join(n))