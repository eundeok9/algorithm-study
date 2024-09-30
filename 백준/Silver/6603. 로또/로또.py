# 1초, 128mb
from itertools import combinations
import sys
input = sys.stdin.readline

while True:
    num_list = list(map(int, input().split()))
    k = num_list[0]
    num_arr = num_list[1:]
    
    
    for arr in combinations(num_arr, 6):
        print(*arr)
    
    if k == 0:
        break

    print()