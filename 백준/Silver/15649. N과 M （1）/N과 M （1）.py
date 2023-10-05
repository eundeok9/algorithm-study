from itertools import permutations

n, m = list(map(int, input().split()))
num_list = [i for i in range(1, n+1)]
numbers = permutations(num_list,m)
for number in numbers:
    print(*number)