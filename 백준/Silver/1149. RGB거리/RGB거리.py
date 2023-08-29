import sys
input = sys.stdin.readline

table = []

n = int(input())

for _ in range(n):
    table.append(list(map(int, input().split())))

for i in range(1, n):
    table[i][0] = min(table[i - 1][1], table[i - 1][2]) + table[i][0]
    table[i][1] = min(table[i - 1][0], table[i - 1][2]) + table[i][1]
    table[i][2] = min(table[i - 1][1], table[i - 1][0]) + table[i][2]

cost = min(table[n-1][0], table[n-1][1], table[n-1][2])
print(cost)