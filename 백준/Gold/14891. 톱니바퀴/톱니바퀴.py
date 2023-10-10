import sys
input = sys.stdin.readline

def rotate(num, dir):
    check[num] = 1

    if num < 3:
        if magnet[num][2] != magnet[num+1][6] and check[num+1] == 0:
            rotate(num+1, dir * -1)
    if num > 0:
        if magnet[num][6] != magnet[num-1][2] and check[num-1] == 0:
            rotate(num-1, dir * -1)

    if dir == 1:
        magnet[num] = [magnet[num].pop()] + magnet[num]

    if dir == -1:
        magnet[num] = magnet[num][1:] + [magnet[num][0]]

magnet = []

for _ in range(4):
    magnet_info = list(map(int, input().rstrip()))
    magnet.append(magnet_info)

k = int(input())

for _ in range(k):
    num, dir = list(map(int, input().split()))
    check = [0] * 4
    rotate(num-1, dir)


ans = 0
for r in range(4):
    ans += magnet[r][0] * (2**r)

print(ans)