# 2초, 128mb
import sys
input = sys.stdin.readline
from collections import deque

n = int(input())

cards = deque()
for i in range(n):
    cards.append(i+1)
    
while len(cards) > 1:
    cards.popleft()
    cards.append(cards.popleft())

print(cards.pop())