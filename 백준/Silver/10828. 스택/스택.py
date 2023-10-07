import sys
input = sys.stdin.readline

n = int(input())
stack = []
for _ in range(n):
    # print(stack)
    num = 0
    line = list(input().split())
    word = line[0]

    if len(line) == 2:
        num = int(line[1])

    if word == "push":
        stack.append(num)

    if word == "pop":
        if len(stack) != 0:
            print(stack.pop())
        else:
            print(-1)

    if word == "size":
        print(len(stack))

    if word == "empty":
        if len(stack) == 0:
            print(1)
        else:
            print(0)

    if word == "top":
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])