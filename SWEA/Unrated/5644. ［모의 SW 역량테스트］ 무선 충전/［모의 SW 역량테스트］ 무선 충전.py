# 무선 충전, 파이썬 15초


def move():
    totalSum = getCharge()
    for time in range(m):
        players[0][0] += dx[pathA[time]]
        players[0][1] += dy[pathA[time]]
        players[1][0] += dx[pathB[time]]
        players[1][1] += dy[pathB[time]]


        totalSum += getCharge()

    return totalSum


def getCharge():
    maxCharge = 0
    for a in range(apCnt):
        for b in range(apCnt):
            sum = 0
            aSum = check(a, players[0][0], players[0][1])
            bSum = check(b, players[1][0], players[1][1])
            if a != b:
                sum = aSum + bSum
            else:
                sum = max(aSum, bSum)

            if sum > maxCharge:
                maxCharge = sum
    return maxCharge

def check(a, x, y):
    if abs(ap[a][0]-x) + abs(ap[a][1]-y) <= ap[a][2]:
        return ap[a][3]
    else:
        return 0


t = int(input())
dx = [0, 0, 1, 0, -1]
dy = [0, -1, 0, 1, 0]
for tc in range(1, t+1):
    m, apCnt = list(map(int, input().split())) # 움직이는 시간, 배터리 개수

    players = [[0 for _ in range(2)] for _ in range(2)] # 두 명의 사용자 현재 위치
    players[0][0] = players[0][1] = 1 # 첫번째 사용자 초기 위치 (1,1)
    players[1][0] = players[1][1] = 10 # 두번째 사용자 초기 위치 (10,10)


    # 두 사용자가 움직일 방향 저장
    pathA = list(map(int, input().split()))
    pathB = list(map(int, input().split()))

    ap = [[0 for _ in range(4)] for _ in range(apCnt)] # 배터리 정보
    for i in range(apCnt):
        apList = list(map(int, input().split()))
        ap[i][0] = apList[0]
        ap[i][1] = apList[1]
        ap[i][2] = apList[2]
        ap[i][3] = apList[3]
        apList.clear()
    print("#{} {}".format(tc, move()))