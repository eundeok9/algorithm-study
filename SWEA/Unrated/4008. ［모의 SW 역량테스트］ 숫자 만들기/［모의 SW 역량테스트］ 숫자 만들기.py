
t = int(input())

def dfs(idx, res):
    global max_value, min_value

    if idx == n:
        max_value = max(max_value, res)
        min_value = min(min_value, res)
        return

    for i in range(4):
        if opers[i] <= 0:
            continue
        opers[i] -= 1
        if i == 0:
            new_res = res + numbers[idx]
        elif i == 1:
            new_res = res - numbers[idx]
        elif i == 2:
            new_res = res * numbers[idx]
        elif i == 3:
            new_res = int(res / numbers[idx])
        dfs(idx+1, new_res)
        opers[i] += 1

for tc in range(1, t+1):
    n = int(input())

    opers = list(map(int, input().split()))
    numbers = list(map(int, input().split()))

    max_value = -1e9
    min_value = 1e9

    dfs(1, numbers[0])

    print("#{} {}".format(tc, max_value - min_value))