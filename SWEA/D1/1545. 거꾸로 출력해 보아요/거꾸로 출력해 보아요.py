N = int(input())

numbers = []
for i in range(N, -1, -1):
    numbers.append(i)
print(*numbers)