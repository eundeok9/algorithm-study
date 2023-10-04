import sys
input = sys.stdin.readline

def dfs(x, y):
    dx = [-1, 0, 1]
    dy = [1, 1, 1]

    for i in range(3):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx > R-1 or ny < 0 or ny > C-1:
            continue
        if table[nx][ny] == '.':
            if ny == C-1:
                return True
            table[nx][ny] = 'x'
            if dfs(nx, ny):
                return True
    return False

def main():
    for _ in range(R):
        table.append(list(map(str, input().rstrip())))

    cnt = 0
    for i in range(R):
        if dfs(i, 0):
            cnt += 1

    print(cnt)

R, C = list(map(int, input().split()))
table = []
main()

