from itertools import product

n, m = list(map(int, input().split()))

arr = [i for i in range(1, n+1)]

numbers = product(arr, repeat=m)

for number in numbers:
    print(*number)