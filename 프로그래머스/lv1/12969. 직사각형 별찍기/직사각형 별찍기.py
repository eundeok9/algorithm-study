a, b = map(int, input().strip().split(' '))
answer = [['*' for _ in range(a)] for _ in range(b)]
for rows in answer:
    row = ''.join(rows)
    print(row)