from itertools import product

n, m = list(map(int, input().split()))
num_list = [i for i in range(1,n+1)]
numbers = product(num_list, repeat=m)

for number in numbers:
    print(*number)