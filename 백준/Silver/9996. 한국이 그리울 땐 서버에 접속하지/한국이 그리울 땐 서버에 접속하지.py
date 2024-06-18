# 1초, 128MB

import sys
input = sys.stdin.readline

n = int(input())
pattern = input().split("*")
length = len(pattern[0]) + len(pattern[1])

for _ in range(n):
    elem = input()
    
    if length > len(elem):
        print("NE")
        
    else:
        if pattern[0] == elem[:len(pattern[0])] and pattern[1] == elem[-len(pattern[1]):]:
            print("DA")
        else:
            print("NE")