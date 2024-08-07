# 1초, 256mb
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    pwd = []
    popList = []
    line = list(input().rstrip())
    
    for i in range(len(line)):
        if line[i] == '<':
            if pwd:
                popList.append(pwd.pop())
        
        elif line[i] == '>':
            if popList:
                pwd.append(popList.pop())
        
        elif line[i] == '-':
            if pwd:
                pwd.pop()
        else:
            pwd.append(line[i])
    
    pwd.extend(reversed(popList))
    print(''.join(pwd))