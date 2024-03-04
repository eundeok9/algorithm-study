from itertools import combinations

n, m = list(map(int, input().split()))

arr = [i for i in range(1, n+1)]

numbers = combinations(arr, m)

for number in numbers:
    print(*number)