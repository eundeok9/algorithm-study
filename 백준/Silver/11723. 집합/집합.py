import sys
input = sys.stdin.readline

m = int(input())

S = set()

for _ in range(m):
    command = input().split()
    
    if len(command) == 1:
        if command[0] == 'all':
            S = set([x for x in range(1, 21)])
        else:
            S = set()
    else:
        cmd, x = command[0], int(command[1])
        if cmd == 'add':
            S.add(x)
        elif cmd == 'remove':
            S.discard(x)
        elif cmd == 'check':
            print(1 if x in S else 0)
        elif cmd == 'toggle':
            if x in S:
                S.discard(x)
            else:
                S.add(x)
