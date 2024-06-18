import sys
input = sys.stdin.readline

n = int(input())
user = []

for _ in range(n):
    age, name = list(input().split())
    user.append([int(age), name])

sorted_user = sorted(user, key = lambda x: x[0])

for user in sorted_user:
    print(user[0], user[1])