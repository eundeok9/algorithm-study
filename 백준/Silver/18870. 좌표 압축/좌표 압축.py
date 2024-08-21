# 2초, 512mb
import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

sorted_numbers = sorted(list(set(numbers)))

dict = {}
for i in range(len(sorted_numbers)):
    dict[sorted_numbers[i]] = i
    
for i in numbers:
    print(dict[i], end=" ")