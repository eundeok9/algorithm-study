# 1초, 256mb
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    pwd = []
    popList = []
    line = list(input().rstrip())
    
    for i in line:
        if i == '<':
            if pwd:
                popList.append(pwd.pop())
        
        elif i == '>':
            if popList:
                pwd.append(popList.pop())
        
        elif i == '-':
            if pwd:
                pwd.pop()
                
        else:
            pwd.append(i)
    
    pwd.extend(reversed(popList))
    print(''.join(pwd))